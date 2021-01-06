package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import cucumber.api.java.Before;

public class DataBase {

	static Logger log = Logger.getLogger(DataBase.class); // Classe de Log

	private static Connection con;
 
 
	@Before
	public static void getConection() throws SQLException {
		if (con == null) {
			// Create a variable for the connection string.
			String connectionUrl = "jdbc:sqlserver://10.30.2.14;databaseName=super;user=aspnet;password=123456";
			con = DriverManager.getConnection(connectionUrl);
		}
	}

	public static String updateUser(String cpf) throws Exception {

		try {
			String SQL = "UPDATE DB_AUT..tbl_002_usuario SET cd_senha = '761732fec8458aefe5d3850e2a0ae3cf2068', cd_salt = '2068' WHERE  nm_login = ?";
			PreparedStatement stmt = con.prepareStatement(SQL);
			stmt.setString(1, cpf);
			stmt.execute();
			if (stmt.getUpdateCount() != 1) {
				throw new Exception();
			}

			SQL = "SELECT CC.ID as contaId " + "FROM Super..PessoasFisicas PF (NOLOCK) "
					+ "INNER JOIN Super..PessoasFisicasContasCorrentes PFCC ON PFCC.PessoaFisicaID = PF.ID "
					+ "INNER JOIN Super..ContasCorrentes CC ON CC.ID = PFCC.ContaCorrenteID WHERE PF.CPF = ?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			ResultSet rs = pstmt.executeQuery();
			String id = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				id = rs.getString("contaId");

			}
			System.out.println(" conta =  " + id);

			SQL = "UPDATE Super..ContasCorrentes SET status = 'A', statuscontaid = 1 WHERE  id = ? ";
			stmt = con.prepareStatement(SQL);
			stmt.setString(1, id);
			stmt.execute();
			if (stmt.getUpdateCount() != 1) {
				throw new Exception();
			}

			SQL = "DECLARE @CallStack VARCHAR(4000)\r\n"
					+ "DECLARE @LancamentoCreditoId bigint ,@LancamentoDebitoId bigint\r\n"
					+ "EXEC dbo.pInserirLancamento\r\n" + "    @LancamentoCreditoId              OUTPUT,\r\n"
					+ "    @LancamentoDebitoId               OUTPUT,\r\n"
					+ "    @ContaCreditoId                       = ? ,"
					+ "    @ContaDebitoId                        = 112724,  --(55763)\r\n"
					+ "    @LancamentoDecorrenteId      = NULL,\r\n"
					+ "    @Valor                                         = 1000, -->VALOR A SER CREDITADO\r\n"
					+ "    @HistoricoDebito                       = 'Lançamento Saldo Teste',\r\n"
					+ "    @HistoricoCredito                      = 'Lançamento Saldo Teste',\r\n"
					+ "    @Usuario                                     = 'Equipe#Teste',\r\n"
					+ "    @TipoLancamentoId                  = 28,\r\n"
					+ "    @MoedaId                                   = 1,\r\n"
					+ "    @MensagemOutput                   = NULL,\r\n"
					+ "    @Erro                                                                 = 0,\r\n"
					+ "    @CallStack                                                        = @CallStack OUTPUT ";

			stmt = con.prepareStatement(SQL);
			stmt.setString(1, id);
			stmt.execute();
			
			
			
			int senha=2068;
			SQL = "DECLARE @NovaIdSenha INT \r\n "    +
			"EXEC super..pAtribuirSenha @Pin = ?, @IdSenha = @NovaIdSenha OUTPUT \r\n"+
			"UPDATE Super..ContasCorrentes SET IdSenha = @NovaIdSenha WHERE id = ? \r\n"+
			"UPDATE Super..ContasCorrentes SET IdSenha = @NovaIdSenha WHERE ContaCorrenteID = ?";
			stmt = con.prepareStatement(SQL);
			stmt.setInt(1,senha);
			stmt.setString(2, id);
			stmt.setString(3, id);
			stmt.execute();
							

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getPasswordDataBase() throws SQLException {

		log.info("Getting the reset password");
		Statement stmt = con.createStatement();
		try {

			String SQL = "SELECT TOP 1 * FROM notificacoes order by id desc";
			ResultSet rs = stmt.executeQuery(SQL);
			String password = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				password = rs.getString("Conteudo");

			}
			int index = password.indexOf("é");

			return password.substring(index + 2, index + 8);
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String getToken() throws SQLException {

		log.info("Getting the token");
		try {
			// if(con==null)getConection();
			Statement stmt = con.createStatement();
			String SQL = "SELECT TOP 1 * FROM tokenscelular order by id desc";
			ResultSet rs = stmt.executeQuery(SQL);
			String token = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				token = rs.getString("Token");

			}

			log.info("Token was got");
			return token;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String checkBankSlipCreationDatabase(String linha) throws SQLException {

		log.info("Getting the information of bankslip at database");
		try {
			String SQL = "select * from SuperBoleto.dbo.Boleto where LinhaDigitavel=? order by BoletoId desc";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, linha);

			ResultSet rs = pstmt.executeQuery();
			String id = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				id = rs.getString("BoletoId");

			}

			return id;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static User[] getUsers(int quantity) throws SQLException {

		log.info("Getting a valid cpf");

		User[] listaPessoas = new User[quantity];

		try {
			String SQL = "select top " + quantity
					+ "  CPF,DataNascimento,pfe.Email,pft.NumeroTelefone,cc.Status from pessoasfisicas pf inner join PessoasFisicasEmails pfe on pf.ID=pfe.PessoaFisicaID  inner join PessoasFisicasTelefones pft on pf.ID=pft.PessoaFisicaID  inner join PessoasFisicasContasCorrentes pfc on pf.id=pfc.PessoaFisicaID inner join ContasCorrentes cc on pfc.ContaCorrenteID=cc.ID where cc.Status='A' and cc.StatusContaID=1 order by pf.id desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			int i = 0;
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				listaPessoas[i] = new User();
				listaPessoas[i].setCpf(rs.getString("cpf"));
				String dataT = rs.getString("dataNascimento").replaceAll("-", "/");
				String[] data = dataT.split("/");
				listaPessoas[i].setBirthday(data[2] + "/" + data[1] + "/" + data[0]);
				listaPessoas[i].setEmail(rs.getString("Email"));
				listaPessoas[i].setTelephone(rs.getString("NumeroTelefone"));
				System.out.println("---------------------------");
				System.out.println("" + listaPessoas[i].getCpf());
				System.out.println("" + listaPessoas[i].getBirthday());
				System.out.println("" + listaPessoas[i].getEmail());
				System.out.println("" + listaPessoas[i].getTelephone());
				i++;
			}

			return listaPessoas;

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static User[] getUsersLgpd(int quantityUser) {
		log.info("Getting a valid cpf");

		User[] listaPessoas = new User[quantityUser];

		try {
			String SQL = "select top " + quantityUser
					+ "  pf.CPF,pf.Nome,cc.ID as contacorrente ,tlgpd.Id as termolgpd  ,tlgpd.Plataforma,tlgpd.AceiteOnbording,tlgpd.DataAceiteOnbording,tlgpd.AceiteAreaLogada,tlgpd.DataAceiteAreaLogada from pessoasfisicas pf inner join PessoasFisicasContasCorrentes pfc on pf.id=pfc.PessoaFisicaID inner join ContasCorrentes cc on pfc.ContaCorrenteID=cc.ID  left join TermoLgpdAceiteUsuario tlgpd on tlgpd.ContaCorrenteId=cc.ID where tlgpd.AceiteOnbording is null and tlgpd.AceiteAreaLogada is  null order by pf.id desc";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			int i = 0;
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				listaPessoas[i] = new User();
				listaPessoas[i].setCpf(rs.getString("cpf"));
				listaPessoas[i].setContaCorrente(rs.getString("contacorrente"));
				System.out.println("---------------------------");
				System.out.println("" + listaPessoas[i].getCpf());
				i++;
			}

			return listaPessoas;

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static User[] getUserWithACard(int quantityUser) {
		log.info("Getting a valid user with a card");

		User[] listaPessoas = new User[quantityUser];

		try {
			String SQL = "select distinct top "+quantityUser+"  pf.cpf,pf.id,pfe.Email as email,cc.ContaCorrenteID as contacorrente from pessoasfisicas pf inner join PessoasFisicasEmails pfe on pf.ID=pfe.PessoaFisicaID  inner join PessoasFisicasTelefones pft on pf.ID=pft.PessoaFisicaID  inner join ContasCorrentes cc on cc.CriacaoPor=pfe.Email inner join cartoes ca on cc.id=ca.codconta where cc.Status='A' and cc.CriacaoPor=pfe.Email and cc.StatusContaID=1 and ca.CodModalidade=3 order by pf.id desc   ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			int i = 0;
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				listaPessoas[i] = new User();
				listaPessoas[i].setCpf(rs.getString("cpf"));
				listaPessoas[i].setEmail(rs.getString("email"));
				listaPessoas[i].setContaCorrente(rs.getString("contacorrente"));
				System.out.println("---------------------------");
				System.out.println("" + listaPessoas[i].getCpf());
				i++;
			}

			return listaPessoas;

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static String getTermoLgpd(String contaCorrente) {

		log.info("Getting the information of bankslip at database");
		try {
			String SQL = "select top 1 * from TermoLgpdAceiteUsuario where ContaCorrenteId=?";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, contaCorrente);

			ResultSet rs = pstmt.executeQuery();
			String termolgpd = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				termolgpd = rs.getString("AceiteAreaLogada");

			}
			return termolgpd;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}
	
	public static User getUserInformation(String cpf) {

		log.info("Getting the information of bankslip at database");
		try {
			User user = null;
			String SQL = "select top 1 pf.Nome as nome,pf.Pais as pais,CPF,DataNascimento,NumeroDocumento,OrgaoEmissorDocumento,pfe.Email,pft.NumeroTelefone,cc.Status from pessoasfisicas pf inner join PessoasFisicasEmails pfe on pf.ID=pfe.PessoaFisicaID  inner join PessoasFisicasTelefones pft on pf.ID=pft.PessoaFisicaID  inner join PessoasFisicasContasCorrentes pfc on pf.id=pfc.PessoaFisicaID inner join ContasCorrentes cc on pfc.ContaCorrenteID=cc.ID where cc.Status='A' and cc.StatusContaID=1 and  pf.cpf = ? order by pf.id desc";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, cpf);

			ResultSet rs = pstmt.executeQuery();
			 
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				user = new User();
				user.setCpf(rs.getString("cpf"));
				String dataT = rs.getString("dataNascimento").replaceAll("-", "/");
				String[] data = dataT.split("/");
				user.setBirthday(data[2] + "/" + data[1] + "/" + data[0]);
				user.setEmail(rs.getString("Email"));
				user.setTelephone(rs.getString("NumeroTelefone"));
				user.setRg(rs.getString("NumeroDocumento"));
				user.setOrgaoEmissor(rs.getString("OrgaoEmissorDocumento"));
				user.setCountry(rs.getString("pais"));
				user.setFullName(rs.getString("nome"));
				System.out.println("---------------------------");
				System.out.println("" + user.getFullName());
				System.out.println("" + user.getCpf());
				System.out.println("" + user.getBirthday());
				System.out.println("" + user.getEmail());
				System.out.println("" + user.getTelephone());
				System.out.println("" + user.getRg());
				System.out.println("" + user.getCountry());
				System.out.println("" + user.getOrgaoEmissor());
				
			}
			
			return user;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	
	
	public static String getCountCartao(String email) {
        System.out.println("Email = "+email);
		log.info("Getting the information of user's card at database");
		try {
			String SQL = "select count(CodCartao) as countCard from Cartoes where CriacaoPor=? order by 1 desc";
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, email);

			ResultSet rs = pstmt.executeQuery();
			String countCard = "";
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				countCard = rs.getString("countCard");

			}
			return countCard;
		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public static User[] getUserWithAVirtualCard(int quantityUser) {
		log.info("Getting a valid user with a card");

		User[] listaPessoas = new User[quantityUser];

		try {
			String SQL = "select distinct top "+quantityUser+"  pf.cpf,pf.id,pfe.Email as email,cc.ContaCorrenteID as contacorrente from pessoasfisicas pf inner join PessoasFisicasEmails pfe on pf.ID=pfe.PessoaFisicaID  inner join PessoasFisicasTelefones pft on pf.ID=pft.PessoaFisicaID  inner join ContasCorrentes cc on cc.CriacaoPor=pfe.Email inner join cartoes ca on cc.id=ca.codconta where cc.Status='A' and cc.CriacaoPor=pfe.Email and cc.StatusContaID=1 and ca.CodModalidade=30 order by pf.id desc   ";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);

			int i = 0;
			// Iterate through the data in the result set and display it.
			while (rs.next()) {
				listaPessoas[i] = new User();
				listaPessoas[i].setCpf(rs.getString("cpf"));
				listaPessoas[i].setEmail(rs.getString("email"));
				listaPessoas[i].setContaCorrente(rs.getString("contacorrente"));
				System.out.println("---------------------------");
				System.out.println("" + listaPessoas[i].getCpf());
				i++;
			}

			return listaPessoas;

		}
		// Handle any errors that may have occurred.
		catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}