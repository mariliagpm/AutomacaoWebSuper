package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage extends Pages {
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"CPF\"]")
    public WebElement userCpf;		
	
	@FindBy(how = How.XPATH, using = "//button[@data-class=\"holos-login-button\"]")
    public WebElement buttonContinuar;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_0\"]")
    public WebElement button0;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_1\"]")
    public WebElement button1;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_2\"]")
    public WebElement button2;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_3\"]")
    public WebElement button3;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_4\"]")
    public WebElement button4;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_5\"]")
    public WebElement button5;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_6\"]")
    public WebElement button6;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_7\"]")
    public WebElement button7;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_8\"]")
    public WebElement button8; 
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_9\"]")
    public WebElement button9;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"Entrar\"]")
    public WebElement botaoEntrar;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"skipDiv\")]//button")
    public WebElement fecharPopPularAbertura;
	
	@FindBy(how = How.XPATH, using = "//img[contains(@class,\"close\")]" )
    public WebElement fecharPopEmprestimo;
	
	@FindBy(how = How.XPATH, using = "//a[@data-class=\"holos-link-pass-recovery\"]")
    public WebElement botaoForgotPassword;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"Digite o seu CPF\"]")
    public WebElement inputCpfReset;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"Digite o seu e-mail\"]")
    public WebElement inputEmailReset;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"CELULAR\"]")
    public WebElement inputPhoneReset;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"DATA DE NASCIMENTO\"]")
    public WebElement inputBdayReset;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"REDEFINIR SENHA\"]")
    public WebElement buttonReset;
	
	@FindBy(how = How.XPATH, using = "//button[@type=\"button\"]")
    public WebElement buttonOkPassword;
	

	@FindBy(how = How.XPATH, using = "//img[contains(@class,\"closeBtn\")]")
    public WebElement fecharPopAtualizar;
	

	@FindBy(how = How.XPATH, using = "//input[@name=\"temporaryPassword\"]")
    public WebElement inputPasswordReset;
	

	@FindBy(how = How.XPATH, using = "//input[@name=\"newPassword\"]")
    public WebElement inputNewPassword;
	

	@FindBy(how = How.XPATH, using = "//input[@name=\"confirmNewPassword\"]")
    public WebElement inputNewPasswordAgain;
	

	@FindBy(how = How.XPATH, using = "//button[@data-button=\"Salvar\"]")
    public WebElement buttonSaveNewPassword;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"AvisoFraude_modal\")]//button[contains(@class,\"MuiButton-text\")]")
    public WebElement buttonAgreeTerms;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"ModalError\")]/span[1]")
    public WebElement wrongPasswordMessage;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,\"AvisoLgpd_btn1\")]")
    public WebElement buttonNaoConcordo;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,\"AvisoLgpd_btn2\")]")
    public WebElement buttonConcordo;

	@FindBy(how = How.XPATH, using = "//button[@name='clickSource']")
    public WebElement buttonMenuAccount;
	
	@FindBy(how = How.XPATH, using = "//li[@data-submenu=\"Seus dados\"]")
    public WebElement menuMyInformations;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_nome']/input")
    public WebElement nomeCompleto;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_cpf']/input")
    public WebElement cpf; 
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_dtanascimento']/input")
    public WebElement dataNascimento;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_identidade']/input")
    public WebElement Identidade;

	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_orgemissor']/input")
    public WebElement orgaoEmissor;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_pais']/input")
    public WebElement paisNascimento;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_telefone']/input")
    public WebElement celular;
	
	@FindBy(how = How.XPATH, using = "//div[@datatest='campo_email']/input")
    public WebElement email;

	@FindBy(how = How.XPATH, using = "//div[@data-label=\"Cartões\"]")
    public WebElement menuCards;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"adicionar\"]")
    public WebElement addCards;
	
	@FindBy(how = How.XPATH, using = "//label[@class='MuiFormControlLabel-root'][1]/span[1]")
    public WebElement cardVirtual;
	

	@FindBy(how = How.XPATH, using = "//label[@class='MuiFormControlLabel-root'][2]/span[1]")
    public WebElement cardFisicoAdicional;
	
	@FindBy(how = How.XPATH, using = "//button[@data-label=\"Continuar\"]")
    public WebElement buttonContinuarCard;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'MuiGrid-root')][2]//button[@data-label=\"Continuar\"]")
    public WebElement buttonContinuarCardPartTwo;

	@FindBy(how = How.XPATH, using = "//div[@data-field='Ex: Aplicativos de taxi']/input")
    public WebElement cardName;
	 
	@FindBy(how = How.XPATH, using = "//button[@data-label=\"Confirmar\"]")
    public WebElement buttonConfirmar;
	
	@FindBy(how = How.XPATH, using = "//button[@data-label='Ok']")
    public WebElement buttonOk;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field='Escreva o nome']")
    public WebElement cardFisicoUserName;

	@FindBy(how = How.XPATH, using = "//input[@datatest='cpf']")
    public WebElement cardFisicoUserCpf;
	
	@FindBy(how = How.XPATH, using = "//div[@data-type='adicional'][1]")
    public WebElement firstCard;
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"Valor\"]")
    public WebElement inputValue;
	
	@FindBy(how = How.XPATH, using = "//li[@datatest='recarregar']")
    public WebElement optionRecarregar;
	 
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'Value')]")
    public WebElement valueOfCard;
	
	@FindBy(how = How.XPATH, using = "//li[@datatest='resgatar']")
    public WebElement optionResgatar;
	 
	
	@FindBy(how = How.XPATH, using = "//div[@data-type='virtual'][1]")
    public WebElement firstCardVirtual;
	
	public LoginPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
