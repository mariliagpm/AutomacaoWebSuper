package selenium.interactions;

 
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger; 
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import selenium.SeleniumTestWrapper;
import selenium.pageobjects.BankSlipPage;
import utils.DataBase;

public class BankSlipInteraction extends BankSlipPage{

	private final Logger log = Logger.getLogger(BankSlipInteraction.class);
	String line= "";
	
	public BankSlipInteraction(final WebDriver driver) {
		super(driver);
	}


	public void clickCreateBankSlip() throws Exception {
		try { 

			log.info("Enter at menu of create a bankslip");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(3000);;
			waitForElementAndClick(buttonCreatBankSlip);
			Thread.sleep(3000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}
	
	public void clickFirstOptionCreateBankSlip() throws Exception {
		try { 
			log.info("Choosing first option");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(firstOptionBankSlip);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}


	public void sendValueOfBankSlip(String value) throws Exception {
		try { 
			log.info("User sent the value of his bankslip");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			sendElemet(inputValueBankSlip, value);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("Value chosen was "+value);
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
		
	}
	
	
	public void sendDateOfBankSlip() throws Exception {
		try { 

			log.info("User sent the due date of his bankslip");
			Date data = new Date(System.currentTimeMillis()); 
			// Através do Calendar, trabalhamos a data informada e adicionamos 1 dia nela
			Calendar c = Calendar.getInstance();
			c.setTime(data);
			c.add(Calendar.DATE, +3);
			data=c.getTime();
			SimpleDateFormat formatarDate = new SimpleDateFormat("dd-MM-yyy");
			String dateFormate=formatarDate.format(data); 

			log.info("Date chosen was "+data);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			inputDateBankSlip.sendKeys(Keys.BACK_SPACE);
			Thread.sleep(200);
			sendElemet(inputDateBankSlip, dateFormate.replace("-", ""));
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
		
	}


	public void clickContinueButton() throws Exception {
		try { 
			log.info("Click at continue button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(buttonContiue);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}
	

	public void clickGenerateBankSlip() throws Exception {
		try { 

			log.info("Click at genereate bankslip button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(generateBankSlipButton);
			Thread.sleep(1000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}
	
	public void sendPassword(String password) throws Exception {
		try { 
			log.info("Sending password");
			Thread.sleep(2000);	
			char[] pa=password.toCharArray();
			for(int i=0;i<password.length();i++) {
				
					if(pa[i]=='0') 
					waitForElementAndClick(button0);
				
					if(pa[i]=='1') 
						waitForElementAndClick(button1);

					if(pa[i]=='2') 
						waitForElementAndClick(button2);

					if(pa[i]=='3') 
						waitForElementAndClick(button3);

					if(pa[i]=='4') 
						waitForElementAndClick(button4);

					if(pa[i]=='5') 
						waitForElementAndClick(button5);

					if(pa[i]=='6') 
						waitForElementAndClick(button6);

					if(pa[i]=='7') 
						waitForElementAndClick(button7);

					if(pa[i]=='8') 
						waitForElementAndClick(button8);

					if(pa[i]=='9') 
						waitForElementAndClick(button9);
					Thread.sleep(1000);			
				
			}
			SeleniumTestWrapper.takeScreenshot();
			log.info("User sent the password");
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}


	public void confirmBankSlip() throws Exception {
		try { 
			log.info("Click at confirm button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(generateBankSlipButton);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
		
	}


	public void clickConfirmButton() throws Exception {
		try { 

			log.info("Click at Confirm button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(confirmBankSlipButton);
			Thread.sleep(4000);
			waitForElement(spanLinhaDigitavel);
			line= spanLinhaDigitavel.getText();
			SeleniumTestWrapper.takeScreenshot();
			String id = DataBase.checkBankSlipCreationDatabase(line);
			if(id==null) throw new Exception("Boleto não criado");		
			SeleniumTestWrapper.takeScreenshot();
		 	Thread.sleep(2000);
		 	log.info("Click at close button");
		 	waitForElementAndClick(buttonClose);

			
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}



	public void checkHistory() throws Exception {
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		log.info("Checking bankSlip history");
		waitForElementAndClick(buttonBankSlipHistory);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstBankSlip);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		String line2= firstBankSlipLine.getText();
		Assert.assertEquals(line, line2, "Boleto não criado");
		SeleniumTestWrapper.takeScreenshot();
		log.info("BankSlip was created");
	}
	
	
}
