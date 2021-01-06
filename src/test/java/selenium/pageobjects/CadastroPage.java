package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class CadastroPage extends Pages {
	
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"Digite o seu CPF\"]")
    public WebElement userCpf;
	
	@FindBy(how = How.XPATH, using = "//button[@data-field=\"CONTINUAR\"]")
    public WebElement butttonContinuar;
	
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
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-field=\"Continuar\"]")
    public WebElement butttonConfirmarSenha;
	
	@FindBy(how = How.XPATH, using = "//button[@data-form=\"Assinatura\"]")
    public WebElement buttonQueroEssa;
	
	@FindBy(how = How.XPATH, using = "//label[1]/span[1]")
    public WebElement checkaceitarTermos;

	@FindBy(how = How.XPATH, using = "//label[2]/span[1]")
    public WebElement checkaceitarComunicacao;
	
	@FindBy(how = How.XPATH, using = "//label[3]/span[1]")
    public WebElement checkaceitarLGPD;
	
	@FindBy(how = How.XPATH, using = "//button[@data-form=\"Termos de Uso\"]")
    public WebElement buttonAceitarTermos;  
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonContinuarDados;

	@FindBy(how = How.XPATH, using = "//input[@data-form=\"Seus Dados - Nome\"]")
    public WebElement name;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadoName;
	
	@FindBy(how = How.XPATH, using = "//input[@data-form=\"Seus Dados - Data de Nascimento\"]")
    public WebElement birthday;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadoBirthday;
	
	@FindBy(how = How.XPATH, using = "//input[@data-form=\"Seus Dados - Nome da Mãe\"]")
    public WebElement mother;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadoMother;
	
	@FindBy(how = How.XPATH, using = "//input[@type=\"tel\"]")
    public WebElement cellPhone;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadocellPhone;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos0\"]")
    public WebElement firstDigitToken;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos1\"]")
    public WebElement secondDigitToken;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos2\"]")
    public WebElement thirdDigitToken;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos3\"]")
    public WebElement fourthDigitToken;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos4\"]")
    public WebElement fifthDigitToken;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"tokeninput_pos5\"]")
    public WebElement sixthDigitToken;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonContinuarTelefone;
	
	@FindBy(how = How.XPATH, using = "//input[@data-form=\"Seus Dados - E-mail\"]")
    public WebElement email;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadoEmail;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-link=\"Prefiro enviar depois\"]")
    public WebElement buttonSendLater;
	
	@FindBy(how = How.XPATH, using = "//fieldset//label[1]/span[1]")
    public WebElement buttonGenderFemine;
	
	@FindBy(how = How.XPATH, using = "//fieldset//label[2]/span[1]")
    public WebElement buttonGenderMasculine;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
	 public WebElement buttonConfirmarDadoGender;
	
	@FindBy(how = How.XPATH, using = "//input[@type=\"tel\"]")
    public WebElement buttonZipCode;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
	public WebElement buttonConfirmarDadoZipCode;
		
	@FindBy(how = How.XPATH, using = "//input[@data-field=\"Número\"]")
    public WebElement inputNumberAddress;

	@FindBy(how = How.XPATH, using = "//button[@data-button=\"CONTINUAR\"]")
    public WebElement buttonConfirmarDadoAddress;
	

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_0\"]")
    public WebElement buttonCard0;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_1\"]")
    public WebElement buttonCard1;		

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_2\"]")
    public WebElement buttonCard2;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_3\"]")
    public WebElement buttonCard3;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_4\"]")
    public WebElement buttonCard4;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_5\"]")
    public WebElement buttonCard5;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_6\"]")
    public WebElement buttonCard6;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_7\"]")
    public WebElement buttonCard7;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_8\"]")
    public WebElement buttonCard8;

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"key_9\"]")
    public WebElement buttonCard9;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"Continuar\"]")
    public WebElement buttonConfirmarDadoPassword;
	
	@FindBy(how = How.XPATH, using = "//button[@data-button=\"Ok\"]")
    public WebElement buttonOk;
	
	@FindBy(how = How.XPATH, using = "//img[contains(@class,\"closeBtn\")]")
    public WebElement fecharPopAtualizar;

	
	public CadastroPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
