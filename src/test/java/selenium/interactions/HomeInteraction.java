package selenium.interactions;

import org.apache.log4j.Logger; 
import org.openqa.selenium.WebDriver;

import cucumber.api.Scenario;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.HomePage;

public class HomeInteraction extends HomePage {

	private final Logger log = Logger.getLogger(HomeInteraction.class);
	private Scenario sc;

	public HomeInteraction(final WebDriver driver) {
		super(driver);
	}

	public void navigateToHomePage() throws Exception {
		try {
			goToUrl(getTestData("homePage"));// redirecionando pra homepage
			SeleniumTestWrapper.takeScreenshot();
			log.info("User is in the Home Page");
			if (isElementPresent(fecharPopAtualizar) && isElementVisible(fecharPopAtualizar)) {
				waitForElementAndClick(fecharPopAtualizar);
			} 
			log.info("Pop up Atualizar was closed");
			log.info("Current Url is  " + driver.getCurrentUrl());
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to redirect to HomePage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickCreateAccountButton() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(createAccountButton);
			Thread.sleep(5000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("Current Url is  " + driver.getCurrentUrl());
		} catch (Exception e) {
			log.error("It was not possible to redirect to HomePage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public Scenario getSc() {
		return sc;
	}

	public void setSc(Scenario sc) {
		this.sc = sc;
	}

}
