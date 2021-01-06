package selenium.interactions;


import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.SeleniumTestWrapper;
import selenium.pageobjects.ChangePasswordPage;

public class ChangePasswordInteraction extends ChangePasswordPage{

	private final Logger log = Logger.getLogger(ChangePasswordInteraction.class);
	
	
	public ChangePasswordInteraction(final WebDriver driver) {
		super(driver);
	}

	


	public void clickAccountMenu() throws Exception {
		log.info("Account Menu");
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
		waitForElementAndClick(menuAccount);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
	}





	public void changePasswordMenu() throws Exception {
		log.info("Change Password Menu");
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
		waitForElementAndClick(menuChangePassword);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(3000);
		log.info("Current Url is  "+driver.getCurrentUrl());
	}





	public void sendMyNewPassword(String password) throws Exception {
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
		sendElemet(newPasswordInput, password);
		log.info("Send new password as "+password);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
	}


	public void sendMyNewPasswordAgain(String password) throws Exception {
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
		sendElemet(newPasswordInputR, password);
		log.info("New password as "+password);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
	}


	public void sendMyOldPassword(String password)   throws Exception{
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
		sendElemet(oldPasswordInput, password);
		log.info("Old password as "+password);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
	}


	public void clickSaveButton() throws Exception {
		log.info("Clicking at save button");
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(3000);
		waitForElementAndClick(saveButton);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(1000);
	}

	public void clickOkButton() throws Exception {
		log.info("Clicking at ok button");
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(8000);
		waitForElementAndClick(okButton);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		if(isElementPresent(fecharPopAtualizar)){
			waitForElementAndClick(fecharPopAtualizar);
		}
	}
	
	
	
	
}
