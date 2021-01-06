package selenium.stepDefinitions;

 

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
 
import cucumber.api.java.en.Given; 
import selenium.SeleniumTestWrapper;
import selenium.interactions.ChangePasswordInteraction;
 

public class StepsChangePasswordPage {

	Logger log = Logger.getLogger(StepsChangePasswordPage.class); // Classe de Log
	String browserName = "";
	ChangePasswordInteraction  changePasswordInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema
	
	

	String pathLogFinal = "";


 
	@Given("^I send my new passowrd as \"([^\"]*)\"$")
	public void send_my_new_passowrd_as(String password) throws Throwable {
		changePasswordInteraction.sendMyNewPassword(password);
	}

	@Given("^I confirm my new passowrd as \"([^\"]*)\"$")
	public void i_confirm_my_new_passowrd_as(String password) throws Throwable {
		changePasswordInteraction.sendMyNewPasswordAgain(password); 
	}
		

	@Given("^I send my old passowrd as \"([^\"]*)\"$")
	public void send_my_old_passowrd_as(String password) throws Throwable {
		changePasswordInteraction.sendMyOldPassword(password);
	}
	
	
	
	@Given("^I click at account menu$")
	public void i_click_at_account_menu() throws Throwable {
		changePasswordInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), ChangePasswordInteraction.class);
		changePasswordInteraction.clickAccountMenu();
	}

	@Given("^I click at change password menu$")
	public void i_click_at_change_password_menu() throws Throwable {
		changePasswordInteraction.changePasswordMenu();
	}

	@Given("^I click at my save button$")
	public void i_click_at_my_save_button() throws Throwable {
		changePasswordInteraction.clickSaveButton();
	}


	@Given("^I click at ok button to confirm the password change$")
	public void i_click_at_ok_button_to_confirm_the_password_change() throws Throwable {
		changePasswordInteraction.clickOkButton();
	}
	
	


	
	
	
	
	
}