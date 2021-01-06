package utils;

import java.text.Normalizer;
import java.util.Random;
import java.util.regex.Pattern;

import org.testng.Assert;

/**
 * @author marilia.prime
 *
 */
public class User {
	private String telephone;
	private String firstName;
	private String lastName;
	private String fullName;
	private String cpf;
	private String email;
	private String gender;
	private String zipCode;
	private String birthday;
	private String rg;
	private String country;
	private String orgaoEmissor;
	
	private String contaCorrente;
	
	private static User user;
	private static String motherName;
	private static String digitos = "";
	private static int id;

	private static Random r = new Random();
	static String[] ListFirstName = { "Agda:F", "Ana:F", "Andréia:F", "André:M", "Adriano:M", "Abinadar:M", "Alice:F",
			"Ariana:F", "Alana:F", "Alencar:M", "Alcemir:M", "Aline:F", "Américo:M", "Ariane:F", "Bruno:M", "Bruna:F",
			"Beatriz:F", "Berenice:F", "Benedito:M", "Benedita:F", "Carlos:M", "Camila:F", "Caroline:F", "Camilo:M",
			"Ceverino:M", "Denis:M", "Denise:F", "Daniel:M", "Dorivaldo:M", "Darlene:F", "Edson:M", "Eliane:F",
			"Eliana:F", "Ester:F", "Everaldo:M", "Elias:M", "Estenio:M", "Etevaldo:M", "Euclides:M", "Eliezer:M",
			"Everaldo:M", "Eduardo:M", "Emanuel:M", "Eunice:F", "Elaine:F", "Jaqueline:F", "Josivaldo:M", "Josefina:M",
			"Larissa:M", "Laís:M", "Laercío:M", "Leandro:M", "Lucas:M", "Maria:F", "Marcos:M", "Marilia:F", "Melissa:F",
			"Marcelo:M", "Mariana:F", "Matheus:M", "Milena:F", "Neilson:M", "Naiara:F", "Nilson:M", "Nerivaldo:M",
			"Noemia:F", "Núbia:F", "Nilvan:M", "Olavo:M", "Oliver:M", "Olindo:M", "Paulo:M", "Paula:F", "Pedro:M",
			"Pedrina:F", "Pivanne:M", "Patrícia:F", "Quelvin:M", "Queila:F", "Ronaldo:M", "Ronan:M", "Romildo:M",
			"Rodolfo:M", "Rita:F", "Ravier:M", "Romã:M", "Salivan:M", "Selton:M", "Simirá:F", "Tadeu:M", "Taís:F",
			"Tamilá:F", "Telma:F", "Ulisson:M", "Umberto:M", "Vicente:M", "Vanice:F", "Vera:F", "Valdermor:M",
			"Zulmira:F", "Zenira:F" };
	static String[] listLastName = { "Alves da Silva", "Andrade Barbosa", "Barbosa Oliveira", "Oliveira da Silva",
			"Alves Pereira", "Conceição Barbosa", "Allen Young", "Hernandez King", "Wright Lopez", "Hill Scott",
			"Green Adams", "Conceição da Costa", "da Costa Oliveira", "Rodrigues de Oliveira", "Amaral Neto de Souza",
			"Pereira da Conceição", "Barros Neto de Andrade", "Borges de Andrade Pereira da Silva",
			"Batista Campos do Amaral", "Cardoso de Oliveira", "Pontes Guimarães", "Dias de Jesus", "Barbos de Lima",
			"Gonçalves da Silva", "Gonsalves de Lima", "Pereira de Oliveira Batista", "Dias de Freitas", "Ferreira",
			"Garcia da Paixão", "Lima Lopes", "Jesus da Silva", "da Silva de Lima", "da Silva Gonsalves Texeira",
			"Fernandes de Paula", "de Paula da Silva", "Barbosa de Mello Oliveira",
			"Oliveira Neto Conceição da Paixão" };
	static String[] listZipCode = { "01319010", "31930740", "01306030", "20530430", "30512040", "01318020", "31260340",
			"18071735", "30882110", "18075774", "01316020", "22631010", "13304070", "01330010", "18075215", "30320450",
			"18060545", "01327010", "30290030", "13327285", "01322000", "31140180", "31370090", "13312804", "31330400",
			"21730310", "30380320", "13322062", "13301471", "13320510", "13327169", "31845142", "22715550", "22772260",
			"13326050", "13323416", "01318999", "13308009", "13323165", "18052750", "31960090", "13322182", "01316030",
			"13306-780", "18016090", "01306040", "22720230", "01320030", "01333911", "01333912", "31250260", "31270070",
			"01332030" };
	static String[] listFistNameMother = { "Agda", "Agatha", "Ana", "Andréia", "Antonela", "Alecilda", "Alice", "Aline",
			"Ariana", "Aline", "Ariane", "Aurora", "Bruna", "Beatriz", "Berenice", "Benedita", "Carla", "Camila",
			"Caroline", "Denise", "Daniela", "Darlene", "Eliane", "Eliana", "Ester", "Estenia", "Etevalda", "Eunice",
			"Elaine", "Fátima", "Hellen", "Jaqueline", "Josivalda", "Josefina", "Jéssica", "Larissa", "Laura", "Lorena",
			"Laís", "Maria", "Marilia", "Melissa", "Marcela", "Mariana", "Milena", "Naiara", "Noemia", "Núbia", "Paula",
			"Pedrina", "Patrícia", "Queila", "Regina", "Rita", "Rosa", "Rosana", "Simirá", "Solange", "Taís", "Tamilá",
			"Tamires", "Telma", "Vanice", "Vera", "Zulmira", "Zenira" };

	public User() {
		telephone = fillTelefone();
		firstName = fillFirstName();
		gender = firstName.substring(firstName.length() - 1);
		firstName = firstName.substring(0, firstName.length() - 2);
		cpf = GenerateDocument.cpf(true);
		lastName = fillLastName();
		fullName = firstName + " " + lastName;
		birthday = fillDateOfBirthday();
		email = semAcento(firstName.toLowerCase()) + semAcento(lastName.replaceAll(" ", "").toLowerCase())
				+ birthday.replaceAll("/", "") + "@gmail.com";
		zipCode = fillZipCode();
		motherName = fillFirstNameMother();
		motherName = motherName + " " + lastName;
		user = this;
	}

	
	public String getContaCorrente() {
		return contaCorrente;
	}

	public void setContaCorrente(String contaCorrente) {
		this.contaCorrente = contaCorrente;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotherName() {
		return motherName;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getCpf() {
		return cpf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		User.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String name) {
		 fullName=name;
	}
	public String getFirstName() {
		return firstName;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGender() {
		return gender;
	}

	public String getZipCode() {
		return zipCode;
	}

	public String fillTelefone() {
		return nDDD() + "9" + nPrefixo() + nFinal();
	}

	// Gera o prefixo do telefone.
	private String nDDD() {
		int codArea = 19 - r.nextInt(9);
		return "(" + codArea + ") ";
	}

	// Gera os primeiros Numeros
	private String nPrefixo() {
		digitos = "";
		for (int i = 0; i < 4; i++)
			digitos += r.nextInt(7) + 2;
		return digitos;
	}

	// Gera a Numeracao final baseando-se em numeros aleatorios
	private String nFinal() {
		digitos = "";
		for (int i = 0; i < 4; i++)
			digitos += r.nextInt(10);
		return digitos;
	}

	// Gera os primeiros Numeros
	private String fillFirstName() {
		return ListFirstName[r.nextInt(ListFirstName.length)];

	}

	// Gera os primeiros Numeros
	private String fillFirstNameMother() {
		return listFistNameMother[r.nextInt(listFistNameMother.length)];

	}

//Gera os primeiros Numeros
	private String fillLastName() {
		return listLastName[r.nextInt(listLastName.length)];
	}

	// Gera os primeiros Numeros
	public int getAdressNumber() {
		return r.nextInt(5000);
	}

//Gera os primeiros Numeros
	private String fillZipCode() {
		return listZipCode[r.nextInt(listZipCode.length)];
	}

//Data de nascimento 
	public static String fillDateOfBirthday() {
		int minYear = 1930;
		int maxYear = 2001;
		String year = String.valueOf(Math.floor(Math.random() * (maxYear - minYear)) + minYear);
		if (year.isEmpty())
			year = "1982";
		year = year.substring(0, 4);
		int minMonth = 1;
		int maxMonth = 12;
		String month = String.valueOf(Math.floor(Math.random() * (maxMonth - minMonth)) + minMonth);
		month = month.replace(".0", "");
		if (month.isEmpty())
			month = "1";
		if (Integer.valueOf(month) <= 9)
			month = "0" + month;
		int minDay = 1;
		int maxDay = 30;
		String day = String.valueOf(Math.floor(Math.random() * (maxDay - minDay)) + minDay);
		day = day.replace(".0", "");
		if (day.isEmpty())
			day = "1";
		if (Integer.valueOf(day) <= 9)
			day = "0" + day;
		if (month == "2" && Integer.valueOf(day) > 29)
			day = "28";
		if ((month == "4" || month == "6" || month == "9" || month == "11") && Integer.valueOf(day) > 30)
			day = "30";
		return day + "/" + month + "/" + year;
	}

	public String value = "À Á Â Ã Ä Å Æ Ç È É Ê Ë Ì Í Î Ï Ð Ñ Ò Ó Ô Õ Ö Ø Ù Ú Û Ü Ý Þ ß à á â ã ä å æ ç è é ê ë ì í î ï ð ñ ò ó ô õ ö ø ù ú û ü ý þ ÿ ";

	public String semAcento(String str) {
		String nfdNormalizedString = Normalizer.normalize(str, Normalizer.Form.NFD);
		Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		return pattern.matcher(nfdNormalizedString).replaceAll("");
	}

	public static void main(String[] args) {
		/*
		 * var o = new Object(){ String nome = "Cleber"; int soma(){ return 2+1; }
		 * String getNome() { return nome; } };
		 * 
		 * System.out.println(o.soma());
		 * 
		 * System.out.println(o.getNome()); /
		 */
		String celular="(11)98177-6141";
		//celular=celular.replaceAll("\\(","");
		//celular=celular.replaceAll("\\)","");
		//celular=celular.replaceAll("\\-","");
		
		System.out.println(celular.replaceAll("\\(","").replaceAll("\\)","").replaceAll("\\-",""));
		
		String teste1 = "R$ 48,80";
		teste1 = teste1.replace("R$ ","").replace(",00","").replace(",",".");;
		double d= Double.valueOf(teste1);
		System.out.println(" " +d);
		
		String teste = "R$ 75,10";
		String a = teste.replace("R$ ","").replace(",",".");
		double b=Double.valueOf(a);
		System.out.println(" " +b);
		
	}

	public void imprimirPessoa() {

		System.out.printf("-------------------------------");
		System.out.printf("\n teste cpf = " + this.getCpf());
		System.out.printf("\n teste first Name =  " + this.getFirstName());
		System.out.printf("\n teste Full Name =  " + this.getFullName());
		System.out.printf("\n teste Gender =  " + this.getGender());
		System.out.printf("\n teste ZipCode =  " + this.getZipCode());
		System.out.printf("\n teste Telefone =  " + this.getTelephone());
		System.out.printf("\n teste email =  " + this.getEmail());
		System.out.printf("\n teste Bday =  " + fillDateOfBirthday());
		System.out.printf("\n teste Mother's name =  " + this.getMotherName());
		System.out.printf("\n ------------------------------- \n ");

	}

	public static User getUser() throws Exception {
		if (user == null)
			return null;
		return user;
	}

	public static void setUser(User userSent) throws Exception {
		 user = userSent;
	}


	public String getRg() {
		return rg;
	}


	public void setRg(String rg) {
		this.rg = rg;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}


	public String getOrgaoEmissor() {
		return orgaoEmissor;
	}


	public void setOrgaoEmissor(String orgaoEmissor) {
		this.orgaoEmissor = orgaoEmissor;
	}

}