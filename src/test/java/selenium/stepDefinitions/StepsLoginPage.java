package selenium.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import selenium.SeleniumTestWrapper;
import selenium.interactions.LoginInteraction;
import utils.DataBase;
import utils.User;

public class StepsLoginPage {

	Logger log = Logger.getLogger(StepsLoginPage.class); // Classse de Log
	String browserName = "";
	LoginInteraction loginInteraction;// Classe responsável
										// pelos steps de
										// entrada na home
										// page do sistema

	String pathLogFinal = "";

	@Before("@nCards")
	public void getUserFromDataBase() throws Exception {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.getUsers();
	}

	@Before("@yCards")
	public void getUserWithCard() throws Exception {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.getUsersWithCard();
	}


	@Before("@vCards")
	public void getUserWithVirtualCard() throws Exception {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.getUsersWithVirtualCard();
	}

	
	@When("^I use my cpf at login page$")
	public void i_use_my_cpf_at_login_page() throws Throwable {
	 	if (loginInteraction.getUserLogin() == null) {
			loginInteraction.getRandonUser();
			System.out.println("Pegando cpf =  "+ loginInteraction.getUserLogin().getCpf());
			DataBase.updateUser(loginInteraction.getUserLogin().getCpf());
			System.out.println("cpf  " + loginInteraction.getUserLogin().getCpf());

		}
		//loginInteraction.getUserLogin().setCpf("087.819.858-00");
		loginInteraction.sendCpf(loginInteraction.getUserLogin().getCpf());
	}

	@Given("^I click at Continuar button$")
	public void i_click_at_Continuar_button() throws Throwable {
		loginInteraction.clickLoginPage();
	}

	@Given("^I send my password as \"([^\"]*)\"$")
	public void i_send_my_password_as(String password) throws Throwable {
		loginInteraction.sendPassword(password);
	}

	@Given("^I click at Entrar button$")
	public void i_click_at_Entrar_button() throws Throwable {
		loginInteraction.clickEntrarButton();

	}

	@Given("^I use my cpf to login$")
	public void i_use_my_cpf_to_login() throws Throwable {
		loginInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), LoginInteraction.class);
		loginInteraction.sendCpf(User.getUser().getCpf());
		loginInteraction.setUserLogin(User.getUser());
	}

	@Given("^I click at login button$")
	public void i_click_at_login_button() throws Throwable {
		loginInteraction.clickAtLoginButton();
	}

	@Given("^I click at forgot button$")
	public void i_click_at_forgot_button() throws Throwable {
		loginInteraction.clickAtForgotButton();
	}

	@When("^I send my cpf to reset my password$")
	public void i_send_my_cpf_to_reset_my_password() throws Throwable {
		loginInteraction.sendCpfToReset(loginInteraction.getUserLogin().getCpf());
	}

	@When("^I send my email to reset my password$")
	public void i_send_my_email_to_reset_my_password() throws Throwable {
		loginInteraction.sendEmailToReset(loginInteraction.getUserLogin().getEmail());
	}

	@When("^I send my cellPhone to reset my password$")
	public void i_send_my_cellPhone_to_reset_my_password() throws Throwable {
		loginInteraction.sendBdayToReset(loginInteraction.getUserLogin().getBirthday());
	}

	@When("^I send my birthday to reset my password$")
	public void i_send_my_birthday_to_reset_my_password() throws Throwable {
		loginInteraction.sendPhoneToReset(loginInteraction.getUserLogin().getTelephone());
	}

	@Given("^I click at redefine password button$")
	public void i_click_at_redefine_password_button() throws Throwable {
		loginInteraction.clickAtResetButton();
	}

	@Given("^I send new password$")
	public void i_send_new_password() throws Throwable {
		loginInteraction.getPassword();
	}

	@Given("^I send reset password$")
	public void i_send_reset_password() throws Throwable {

		loginInteraction.sendResetPassword();
	}

	@Given("^I send my new password$")
	public void i_send_my_new_password() throws Throwable {

		loginInteraction.sendMyNewPassword();
	}

	@Given("^I repeat my new password$")
	public void i_repeat_my_new_password() throws Throwable {

		loginInteraction.sendMyNewPasswordAgain();
	}

	@Given("^click at save password button$")
	public void click_at_save_password_button() throws Throwable {
		loginInteraction.clickSavePasswordButton();
	}

	@Then("^I check if user send wrong password$")
	public void i_check_if_user_send_wrong_password() throws Throwable {
		loginInteraction.checkUserIsNotLogged();
		Thread.sleep(2000);
		DataBase.updateUser(loginInteraction.getUserLogin().getCpf());
	}

	@Then("^I check if user is logged$")
	public void i_check_if_user_is_logged() throws Throwable {
		loginInteraction.checkUserIsLogged();
		Thread.sleep(2000);
		DataBase.updateUser(loginInteraction.getUserLogin().getCpf());

	}

	@When("^I use my cpf at login page without lgpd$")
	public void i_use_my_cpf_at_login_page_without_lgpd() throws Throwable {
		loginInteraction.getUsersLgpd();
		if (loginInteraction.getUserLogin() == null) {
			loginInteraction.getLgpdUser();
			DataBase.updateUser(loginInteraction.getUserLogin().getCpf());
			System.out.println("cpf  " + loginInteraction.getUserLogin().getCpf());

		}
		loginInteraction.sendCpf(loginInteraction.getUserLogin().getCpf());
	}

	@Then("^I send my termo lgpd as \"([^\"]*)\"$")
	public void i_send_my_termo_lgpd_as(String termoLgpd) throws Throwable {
		loginInteraction.sendTermoLgpd(termoLgpd);
	}

	@Then("^I click at user information$")
	public void i_click_at_user_information() throws Throwable {
		loginInteraction.clickAtAccountMenu();
		
	}

	@Then("^I check user information$")
	public void i_check_user_information() throws Throwable {
	     loginInteraction.checkUserInformation();
	}
	

	@Then("^I click at cards menu$")
	public void i_click_at_cards_menu() throws Throwable {
	   loginInteraction.clickAtMenuCards();
	}
	
	@Then("^I create a virtual card$")
	public void i_create_a_virtual_card() throws Throwable {
    loginInteraction.createVirtualCard();
		
	}

	@Then("^I create a extra card$")
	public void i_create_a_extra_card() throws Throwable {
		loginInteraction.createExtraCard();
		
	}

	@Then("^I click at first card$")
	public void i_click_at_first_card() throws Throwable {
	   loginInteraction.chargingMycard();
	}

	
	@Given("^I click at virtual card$")
	public void i_click_at_virtual_card() throws Throwable {
		loginInteraction.chargingMyVirtualCard();
	}
	
}