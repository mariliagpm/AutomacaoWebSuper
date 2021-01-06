package selenium.stepDefinitions;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import cucumber.api.java.en.Given;
import selenium.SeleniumTestWrapper;
import selenium.interactions.BankSlipInteraction;


public class StepsBankSlipPage {

	Logger log = Logger.getLogger(StepsBankSlipPage.class); // Classse de Log
	String browserName = "";
	BankSlipInteraction  bankSlipInteraction;// Classe responsável
									// pelos steps de
									// entrada na home
									// page do sistema
	
	

	String pathLogFinal = "";

	
	@Given("^I click at create a bank slip button$")
	public void i_click_at_create_a_bank_slip_button() throws Throwable {
		bankSlipInteraction = PageFactory.initElements(SeleniumTestWrapper.getDriver(), BankSlipInteraction.class);
		bankSlipInteraction.clickCreateBankSlip();
	}

	@Given("^I click at first option of bank slip$")
	public void i_click_at_first_option_of_bank_slip() throws Throwable {
		bankSlipInteraction.clickFirstOptionCreateBankSlip();
	}

	@Given("^I send the value of my bank slip  as \"([^\"]*)\"$")
	public void i_send_the_value_of_my_bank_slip_as(String value) throws Throwable {
	    bankSlipInteraction.sendValueOfBankSlip(value);
	}

	@Given("^I send the due date of my bank slip$")
	public void i_send_the_due_date_of_my_bank_slip() throws Throwable {
		bankSlipInteraction.sendDateOfBankSlip();
	}

	@Given("^I click at continue button$")
	public void i_click_at_continue_button() throws Throwable {
		bankSlipInteraction.clickContinueButton();
	}

	@Given("^I send my card password as \"([^\"]*)\"$")
	public void i_send_my_card_password_as(String password) throws Throwable {
		bankSlipInteraction.sendPassword(password);
	}

	@Given("^I click at generate a bank slip button$")
	public void i_click_at_generate_a_bank_slip_button() throws Throwable {
		bankSlipInteraction.clickGenerateBankSlip();
	}

	@Given("^I confirm the generation of my bank slip$")
	public void i_confirm_the_generation_of_my_bank_slip() throws Throwable {
	   bankSlipInteraction.clickConfirmButton();
	}
	 
	@Given("^I check my bankslip history$")
	public void i_check_my_bankslip_history() throws Throwable {
		 bankSlipInteraction.checkHistory();
	}

	
}