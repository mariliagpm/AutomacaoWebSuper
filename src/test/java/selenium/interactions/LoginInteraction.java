package selenium.interactions;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.testng.Assert;
import selenium.SeleniumTestWrapper;
import selenium.pageobjects.LoginPage;
import utils.DataBase;
import utils.User;

public class LoginInteraction extends LoginPage {

	private final Logger log = Logger.getLogger(LoginInteraction.class);
	private User[] userList;
	private User userLogin;

	private int quantityUser = 300;

	public User getUserLogin() {
		return userLogin;
	}

	public void setUserLogin(User userLogin) {
		this.userLogin = userLogin;
	}

	public LoginInteraction(final WebDriver driver) {
		super(driver);
	}

	public void sendCpf(String cpf) throws Exception {
		try {
			Thread.sleep(5000);
			if (isElementPresent(fecharPopAtualizar) && isElementVisible(fecharPopAtualizar)) {
				waitForElementAndClick(fecharPopAtualizar);
			}
			log.info("Current Url is  " + driver.getCurrentUrl());
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			sendElemet(userCpf, cpf);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User send the right cpf");
		} catch (Exception e) {
			log.error("It was not possible to send user's cpf");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void clickLoginPage() throws Exception {
		try {
			Thread.sleep(7000);
			SeleniumTestWrapper.takeScreenshot();
			if (isElementPresent(buttonContinuar) && isElementVisible(buttonContinuar)) {
				waitForElementAndClick(buttonContinuar);
			}
			log.info("User sent the cpf, now it is time to send the password");
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to redirect to HomePage");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendPassword(String password) throws Exception {
		try {
			Thread.sleep(3000);
			log.info("Password sent was " + password);
			char[] pa = password.toCharArray();
			for (int i = 0; i < password.length(); i++) {

				if (pa[i] == '0')
					waitForElementAndClick(button0);

				if (pa[i] == '1')
					waitForElementAndClick(button1);

				if (pa[i] == '2')
					waitForElementAndClick(button2);

				if (pa[i] == '3')
					waitForElementAndClick(button3);

				if (pa[i] == '4')
					waitForElementAndClick(button4);

				if (pa[i] == '5')
					waitForElementAndClick(button5);

				if (pa[i] == '6')
					waitForElementAndClick(button6);

				if (pa[i] == '7')
					waitForElementAndClick(button7);

				if (pa[i] == '8')
					waitForElementAndClick(button8);

				if (pa[i] == '9')
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

	public void clickEntrarButton() throws Exception {
		try {

			log.info("Click at Enter Buton");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(botaoEntrar);
			Thread.sleep(15000);
			/*
			 * SeleniumTestWrapper.takeScreenshot(); if
			 * (isElementPresent(fecharPopPularAbertura) &&
			 * isElementVisible(fecharPopPularAbertura)) {
			 * waitForElementAndClick(fecharPopPularAbertura);
			 * log.info("Pop up abertura was closed!"); } Thread.sleep(5000);
			 * SeleniumTestWrapper.takeScreenshot(); if
			 * (isElementPresent(fecharPopEmprestimo) &&
			 * isElementVisible(fecharPopEmprestimo)) {
			 * waitForElementAndClick(fecharPopEmprestimo);
			 * log.info("Pop up Emprestimo was closed!"); } Thread.sleep(5000);
			 * SeleniumTestWrapper.takeScreenshot(); if (isElementPresent(buttonAgreeTerms)
			 * && isElementVisible(buttonAgreeTerms)) {
			 * waitForElementAndClick(buttonAgreeTerms);
			 * log.info("Button Ciente was clicked"); }
			 * SeleniumTestWrapper.takeScreenshot(); log.info("User is logged");
			 * Assert.assertEquals(driver.getCurrentUrl(), "http://sw13vdesenv01:8080/home",
			 * "User is not logged");
			 * 
			 * log.info("Current Url is  " + driver.getCurrentUrl());/
			 */
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickAtForgotButton() throws Exception {
		try {
			log.info("Click at I forgot my password button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(3000);
			waitForElementAndClick(botaoForgotPassword);
			Thread.sleep(3000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendCpfToReset(String cpf) throws Exception {
		try {

			log.info("Sending cpf to reset password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputCpfReset, cpf);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendEmailToReset(String email) throws Exception {
		try {

			log.info("Sending email to reset password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputEmailReset, email);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendPhoneToReset(String phone) throws Exception {
		try {

			log.info("Sending phone to reset password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputPhoneReset, phone);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendBdayToReset(String bday) throws Exception {
		try {

			log.info("Sending birthday to reset password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputBdayReset, bday);
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void clickAtResetButton() throws Exception {
		try {

			log.info("Click at reset button");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(buttonReset);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(buttonOkPassword);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);

		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void getPassword() throws Exception {
		sendPassword(DataBase.getPasswordDataBase());
	}

	public void sendResetPassword() throws Exception {
		try {

			log.info("Sending the reset password!");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(3000);
			sendElemet(inputPasswordReset, DataBase.getPasswordDataBase());
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendMyNewPassword() throws Exception {
		try {
			log.info("Sending New Password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputNewPassword, "206831");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendMyNewPasswordAgain() throws Exception {
		try {
			log.info("Sending New Password Again");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			sendElemet(inputNewPasswordAgain, "206831");
			Thread.sleep(1000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickSavePasswordButton() throws Exception {
		try {
			log.info("Saving new Password");
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(buttonSaveNewPassword);
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(4000);

		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void clickAtLoginButton() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(1000);
			waitForElementAndClick(botaoEntrar);
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void checkUserIsNotLogged() throws InterruptedException {
		Thread.sleep(5000);
		Assert.assertEquals(wrongPasswordMessage.getText(),
				"Essa não é a sua senha. Lembre que essa senha tem 6 números.");
		Assert.assertEquals(driver.getCurrentUrl(), "http://sw13vdesenv01:8080/login");
		log.info("User is not logged");
		log.info("Current Url is  " + driver.getCurrentUrl());

	}

	public void checkUserIsLogged() throws Exception {
		try {
			Thread.sleep(10000);
			SeleniumTestWrapper.takeScreenshot();
			if (isElementPresent(fecharPopPularAbertura) && isElementVisible(fecharPopPularAbertura)) {
				waitForElementAndClick(fecharPopPularAbertura);
				log.info("Pop up abertura was closed!");
			}
			Thread.sleep(8000);
			SeleniumTestWrapper.takeScreenshot();
			if (isElementPresent(fecharPopEmprestimo) && isElementVisible(fecharPopEmprestimo)) {
				waitForElementAndClick(fecharPopEmprestimo);
				log.info("Pop up Emprestimo was closed!");
			}
			Thread.sleep(8000);
			SeleniumTestWrapper.takeScreenshot();
			if (isElementPresent(buttonAgreeTerms) && isElementVisible(buttonAgreeTerms)) {
				waitForElementAndClick(buttonAgreeTerms);
				log.info("Button Ciente was clicked");
			}
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(5000);
			if (isElementPresent(buttonConcordo) && isElementVisible(buttonConcordo))
				waitForElementAndClick(buttonNaoConcordo);
			log.info("User is logged");
			Assert.assertEquals(driver.getCurrentUrl(), "http://sw13vdesenv01:8080/home", "User is not logged");

			log.info("Current Url is  " + driver.getCurrentUrl());
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public User getRandonUser() throws Exception {
		Random r = new Random();
		int indice = r.nextInt(quantityUser);
		System.out.println(" " + indice);
		userLogin = userList[indice];
		DataBase.updateUser(userLogin.getCpf());
		return userLogin;
	}

	public User getLgpdUser() throws Exception {
		Random r = new Random();
		int indice = r.nextInt(quantityUser);
		System.out.println(" " + indice);
		userLogin = userList[indice];
		DataBase.updateUser(userLogin.getCpf());
		return userLogin;
	}

	public void getUsers() throws SQLException {
		userList = DataBase.getUsers(quantityUser);
	}

	public void getUsersWithCard() throws SQLException {
		userList = DataBase.getUserWithACard(quantityUser);
	}

	public void getUsersLgpd() throws SQLException {
		userList = DataBase.getUsersLgpd(quantityUser);
	}

	public void sendTermoLgpd(String termoLgpd) throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(3000);
			if (termoLgpd.equals("true"))
				waitForElementAndClick(buttonConcordo);
			if (termoLgpd.equals("false"))
				waitForElementAndClick(buttonNaoConcordo);

			Thread.sleep(4000);
			String termoLgpdDB = DataBase.getTermoLgpd(userLogin.getContaCorrente());
			if ((termoLgpd.equals("true") && termoLgpdDB.equals("0"))
					|| (termoLgpd.equals("false") && termoLgpdDB.equals("1")))
				throw new Exception("Termo lgpd não foi gravado corretamente no banco");

			log.info("Termo lgpd foi gravado corretamente");

		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void clickAtAccountMenu() throws Exception {
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonMenuAccount);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(menuMyInformations);
		Thread.sleep(5000);

	}

	public void checkUserInformation() throws InterruptedException, WebDriverException, IOException {
		SeleniumTestWrapper.takeScreenshot();
		User user = DataBase.getUserInformation(userLogin.getCpf());
		Thread.sleep(5000);
		System.out.println("Teste retorno ---------------------------");
		System.out.println("" + user.getFullName());
		System.out.println("" + user.getCpf());
		System.out.println("" + user.getBirthday());
		System.out.println("" + user.getEmail());
		System.out.println("" + user.getTelephone());
		System.out.println("" + user.getRg());
		System.out.println("" + user.getCountry());
		System.out.println("" + user.getOrgaoEmissor());
		Assert.assertEquals(nomeCompleto.getAttribute("value").toLowerCase(), user.getFullName().toLowerCase());
		Assert.assertEquals(cpf.getAttribute("value").toLowerCase(), user.getCpf());
		Assert.assertEquals(dataNascimento.getAttribute("value").toLowerCase(), user.getBirthday().toLowerCase());
		Assert.assertEquals(Identidade.getAttribute("value").toLowerCase(), user.getRg().toLowerCase());
		Assert.assertEquals(orgaoEmissor.getAttribute("value").toLowerCase(), user.getOrgaoEmissor().toLowerCase());
		Assert.assertEquals(paisNascimento.getAttribute("value").toLowerCase(), user.getCountry().toLowerCase());
		Assert.assertEquals(email.getAttribute("value").toLowerCase(), user.getEmail().toLowerCase());
		Assert.assertEquals(celular.getAttribute("value").replaceAll("\\(", "").replaceAll("\\)", "")
				.replaceAll("\\-", "").replaceAll(" ", ""), user.getTelephone().replaceAll(" ", ""));
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
	}

	public void clickAtMenuCards() throws Exception {
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(menuCards);
	}

	public void createVirtualCard() throws Exception {
		log.info("Creating a card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		if (isElementPresent(addCards) && isElementVisible(addCards))
			waitForElementAndClick(addCards);
		String countBefore = DataBase.getCountCartao(userLogin.getEmail());
		log.info("User already has " + countBefore + " card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		log.info("One virtual card will be created");
		waitForElementAndClick(cardVirtual);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(cardName, userLogin.getFullName());
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCardPartTwo);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(5000);
		sendPassword("2068");
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		String countAfter = DataBase.getCountCartao(userLogin.getEmail());
		System.out.println("Cartão depois " + countAfter);
		Assert.assertNotEquals(countBefore, countAfter, "Cartão não foi criado");
		if (Integer.valueOf(countBefore) >= Integer.valueOf(countAfter))
			throw new Exception("Cartão não foi criado");
		log.info("User already has " + countAfter + " card now");
		log.info("Card was created");
		waitForElementAndClick(buttonOk);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
	}

	public void createExtraCard() throws Exception {
		log.info("Creating a card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		if (isElementPresent(addCards) && isElementVisible(addCards))
			waitForElementAndClick(addCards);
		String countBefore = DataBase.getCountCartao(userLogin.getEmail());
		log.info("User already has " + countBefore + " card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(cardFisicoAdicional);
		log.info("One physical card will be created");
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(cardFisicoUserName, userLogin.getFullName());
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(cardFisicoUserCpf, userLogin.getCpf());
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCardPartTwo);
		Thread.sleep(5000);
		sendPassword("2068");
		waitForElementAndClick(buttonConfirmar);
		sendPassword("2068");
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(3000);
		sendPassword("2068");
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		String countAfter = DataBase.getCountCartao(userLogin.getEmail());
		System.out.println("Cartão depois " + countAfter);
		Assert.assertNotEquals(countBefore, countAfter, "Cartão não foi criado");
		if (Integer.valueOf(countBefore) >= Integer.valueOf(countAfter))
			throw new Exception("Cartão não foi criado");
		log.info("User already has " + countAfter + " card now");
		log.info("Card was created");
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
	}

	public void chargingMycard() throws Exception {
		log.info("Charging a card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCard);
		Thread.sleep(5000);
		String valueBefore = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");
		System.out.println("valor aa " + valueBefore);
		waitForElementAndClick(optionRecarregar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(inputValue, "75,00");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		sendPassword("2068");
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonOk);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCard);
		Thread.sleep(5000);
		String valueAfter = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");

		System.out.println("valor bb " + valueAfter);

		if (Double.valueOf(valueBefore) + 75 != Double.valueOf(valueAfter)) {

			log.error("Card was not charged");
			throw new Exception("Card was not charged");
		}

		valueBefore = valueAfter;
		log.info("Card was charged");
		log.info("Getting money from a card");
		waitForElementAndClick(optionResgatar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(inputValue, "40,00");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		sendPassword("2068");
		Thread.sleep(3000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonOk);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		log.info("Money was gotten");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCard);
		valueAfter = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");
		if (Double.valueOf(valueBefore) - 40 != Double.valueOf(valueAfter)) {

			log.error("Card was not charged");
			throw new Exception("Card was not charged");
		}

	}

	public void chargingMyVirtualCard() throws Exception {
		log.info("Charging a card");
		Thread.sleep(10000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCardVirtual);
		Thread.sleep(5000);
		String valueBefore = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");
		;
		System.out.println("valor aa " + valueBefore);
		waitForElementAndClick(optionRecarregar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(inputValue, "75,00");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		sendPassword("2068");
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		Thread.sleep(5000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonOk);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCardVirtual);
		Thread.sleep(5000);
		String valueAfter = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");

		System.out.println("valor bb " + valueAfter);

		if (Double.valueOf(valueBefore) + 75 != Double.valueOf(valueAfter)) {

			log.error("Card was not charged");
			throw new Exception("Card was not charged");
		}
		
		
		valueBefore = valueAfter;
		log.info("Card was charged");
		log.info("Getting money from a card");
		waitForElementAndClick(optionResgatar);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		sendElemet(inputValue, "40,00");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarCard);
		Thread.sleep(5000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(3000);
		SeleniumTestWrapper.takeScreenshot();
		sendPassword("2068");
		Thread.sleep(3000);
		waitForElementAndClick(buttonConfirmar);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonOk);
		Thread.sleep(8000);
		SeleniumTestWrapper.takeScreenshot();
		log.info("Money was gotten");
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(firstCardVirtual);
		valueAfter = valueOfCard.getText().replace("R$ ", "").replace(",00", "").replace(",", ".");
		if (Double.valueOf(valueBefore) - 40 != Double.valueOf(valueAfter)) {

			log.error("Card was not charged");
			throw new Exception("Card was not charged");
		}

	}

	public void getUsersWithVirtualCard() {
		 userList = DataBase.getUserWithAVirtualCard(quantityUser);
	}

}
