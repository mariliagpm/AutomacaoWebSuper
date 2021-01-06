package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class BankSlipPage extends Pages {
	
	@FindBy(how = How.XPATH, using = "//div[@data-label=\"Depositar\"]")
    public WebElement buttonCreatBankSlip;
	
	@FindBy(how = How.XPATH, using = "//div[@text=\"Depósito por boleto\"]")
    public WebElement firstOptionBankSlip;
	
	@FindBy(how = How.XPATH, using = "//input[@datatest=\"currency\"]")
    public WebElement inputValueBankSlip;
    		
	@FindBy(how = How.XPATH, using = "//input[@type=\"tel\"]")
    public WebElement inputDateBankSlip;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"continuar\"]")
    public WebElement buttonContiue;
	
	
	@FindBy(how = How.XPATH, using = "//button[@data-label=\"Gerar Boleto\"]")
    public WebElement generateBankSlipButton;
	
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
	

	@FindBy(how = How.XPATH, using = "//button[@datatest=\"continuar\"]")
    public WebElement confirmBankSlipButton;
	

	@FindBy(how = How.XPATH, using = "//div/div//p//span")
    public WebElement spanLinhaDigitavel;
	
	@FindBy(how = How.XPATH, using = "//button[@datatest=\"fechar\"]")
    public WebElement buttonClose;
	

	@FindBy(how = How.XPATH, using = "//a[@datatest=\"historico\"]")
    public WebElement buttonBankSlipHistory;


	@FindBy(how = How.XPATH, using = "//div[contains(@class,\"boletoItem\")][1]//span")
    public WebElement firstBankSlip;

	@FindBy(how = How.XPATH, using = "//p[contains(@class, \"MuiTypography-body1\")]//span")
    public WebElement firstBankSlipLine;
	
	public BankSlipPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
