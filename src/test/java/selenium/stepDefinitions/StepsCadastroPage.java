package selenium.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import selenium.SeleniumTestWrapper;
import selenium.interactions.CadastroInteraction;
import utils.User;


public class StepsCadastroPage {

	Logger log = Logger.getLogger(StepsCadastroPage.class); // Classe de Log
	String browserName = "";
	CadastroInteraction  cadastroInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema
	
	

	String pathLogFinal = "";
 
		
	@Given("^I send my new password as \"([^\"]*)\"$")
	public void i_send_my_new_password_as(String password) throws Throwable {
		cadastroInteraction.sendPassword(password);
	}
	
	@Given("^I repeat my new password as \"([^\"]*)\"$")
	public void i_repeat_my_new_password_as(String password) throws Throwable {
		cadastroInteraction.sendPassword(password);
	}

	@Given("^I choose my fees$")
	public void i_choose_my_fees() throws Throwable {
		cadastroInteraction.chosingMyfees();
	}

	@Given("^I send my cellphone token$")
	public void i_send_my_cellphone_token() throws Throwable {
		cadastroInteraction.sendToken();
	}

	@Given("^I send my email token$")
	public void i_send_my_email_token() throws Throwable {
		cadastroInteraction.sendToken();
	}

	@Given("^I dont send my document's phots$")
	public void i_dont_send_my_document_s_phots() throws Throwable {
		cadastroInteraction.sendLater();
	}
	
	
	
	@Given("^I send my card new password as \"([^\"]*)\"$")
	public void i_send_my_card_new_password_as(String password) throws Throwable {
		cadastroInteraction.sendCardPassword(password);
	}
	
	@Given("^I repeat my card new password as \"([^\"]*)\"$")
	public void i_repeat_my_card_new_password_as(String password) throws Throwable {
		cadastroInteraction.sendCardPassword(password);
	}
		
	@Given("^I click at ok button$")
	public void i_click_at_ok_button() throws Throwable {
		cadastroInteraction.clickOkbutton();
	}
	
	@Given("^I send my cpf$")
	public void i_send_my_cpf() throws Throwable {
		cadastroInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), CadastroInteraction.class);
		User.setUser(new User());
		cadastroInteraction.setPessoa(User.getUser());
		cadastroInteraction.sendCpf();
	}

	@Given("^I send my name$")
	public void i_send_my_name() throws Throwable {
		cadastroInteraction.sendName();
	}

	@Given("^I send my birthday$")
	public void i_send_my_birthday() throws Throwable {
		cadastroInteraction.sendBirthday();
	}

	@Given("^I send my mothers' name$")
	public void i_send_my_mothers_name() throws Throwable {
		cadastroInteraction.sendMotherName();
	}

	@Given("^I send my cellphone$")
	public void i_send_my_cellphone() throws Throwable {
		cadastroInteraction.sendCellPhone();
	}

	@Given("^I send my email$")
	public void i_send_my_email() throws Throwable {
		cadastroInteraction.sendEmail();
	}

	@Given("^I choose my gender$")
	public void i_choose_my_gender() throws Throwable {
		cadastroInteraction.sendGender(); 
	}

	@Given("^I send my zipCode$")
	public void i_send_my_zipCode() throws Throwable {
		cadastroInteraction.sendZipCode(); 
	}

	@Given("^I send my adress number$")
	public void i_send_my_adress_number() throws Throwable {
		cadastroInteraction.sendAddressNumber();
	}
	
	
	@Given("^I choose my terms as \"([^\"]*)\" and termoComunicao as \"([^\"]*)\" and termoLGPD as \"([^\"]*)\"$")
	public void i_choose_my_terms_as_and_termoComunicao_as_and_termoLGPD_as(String termoAceite, String termoComunicacao, String termoLGPD) throws Throwable {
		cadastroInteraction.sendTerms(termoAceite,termoComunicacao,termoLGPD);
	}


	
	
	
	
}