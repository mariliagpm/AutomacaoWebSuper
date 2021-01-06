package selenium.interactions;

import utils.*;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import selenium.SeleniumTestWrapper;
import selenium.pageobjects.CadastroPage;

public class CadastroInteraction extends CadastroPage {

	private final Logger log = Logger.getLogger(CadastroInteraction.class);
	User pessoa = null;

	public CadastroInteraction(final WebDriver driver) {
		super(driver);
	}

	public void setPessoa(User pessoaP) {
		pessoa = pessoaP;
	}

	public void sendCpf() throws Exception {
		try {
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(3000);
			sendElemet(userCpf, pessoa.getCpf());
			SeleniumTestWrapper.takeScreenshot();
			log.info("User sent the cpf as " + pessoa.getCpf());
			waitForElementAndClick(butttonContinuar);
			Thread.sleep(2000);
		} catch (Exception e) {
			log.error("It was not possible to send user's cpf");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendPassword(String password) throws Exception {
		try {

			Thread.sleep(1500);
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
			Thread.sleep(2000);
			waitForElementAndClick(butttonConfirmarSenha);
			SeleniumTestWrapper.takeScreenshot();

		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void chosingMyfees() throws Exception {
		try {
			Thread.sleep(4000);
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonQueroEssa);
			log.info("Choosing my fees");
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to choose fees");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendName() throws Exception {
		try {
			Thread.sleep(2000);
			log.info("Sending user's name");
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(name, pessoa.getFullName());
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadoName);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User sent the name as " + pessoa.getFullName());
		} catch (Exception e) {
			log.error("It was not possible to send name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendBirthday() throws Exception {
		try {
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User is sending the birthday as " + pessoa.getBirthday());
			sendElemet(birthday, pessoa.getBirthday());
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadoBirthday);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User sent the birthday as " + pessoa.getBirthday());
		} catch (Exception e) {
			log.error("It was not possible to send birtday");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendMotherName() throws Exception {
		try {
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(mother, pessoa.getMotherName());
			SeleniumTestWrapper.takeScreenshot();
			log.info("User send the mother's name as " + pessoa.getMotherName());
			waitForElementAndClick(buttonConfirmarDadoMother);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendCellPhone() throws Exception {
		try {
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(cellPhone, pessoa.getTelephone());
			log.info("User send the cellphone as " + pessoa.getTelephone());
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadocellPhone);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendToken() throws Exception {
		try {

			log.info("Sending the token");
			Thread.sleep(2000);
			String token = DataBase.getToken();
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(500);
			sendElemet(firstDigitToken, String.valueOf(token.charAt(0)));
			Thread.sleep(500);
			sendElemet(secondDigitToken, String.valueOf(token.charAt(1)));
			Thread.sleep(500);
			sendElemet(thirdDigitToken, String.valueOf(token.charAt(2)));
			Thread.sleep(500);
			sendElemet(fourthDigitToken, String.valueOf(token.charAt(3)));
			Thread.sleep(500);
			sendElemet(fifthDigitToken, String.valueOf(token.charAt(4)));
			Thread.sleep(500);
			sendElemet(sixthDigitToken, String.valueOf(token.charAt(5)));
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonContinuarTelefone);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}

	}

	public void sendEmail() throws Exception {
		try {
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(email, pessoa.getEmail());
			SeleniumTestWrapper.takeScreenshot();
			Thread.sleep(2000);
			waitForElementAndClick(buttonConfirmarDadoEmail);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User send the email as " + pessoa.getEmail());
		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendLater() throws Exception {
		try {

			log.info("User clicked at Send later button");
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonSendLater);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendGender() throws Exception {
		try {

			log.info("Sending the gender as " + pessoa.getGender());
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

			if (pessoa.getGender().equals("F"))
				waitForElementAndClick(buttonGenderFemine);

			if (pessoa.getGender().equals("M"))
				waitForElementAndClick(buttonGenderMasculine);

			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadoGender);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

			log.info("User sent the gender");
		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendZipCode() throws Exception {
		try {

			log.info("Sending the ZipCode");
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();
			sendElemet(buttonZipCode, pessoa.getZipCode());
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadoZipCode);
			Thread.sleep(2000);
			SeleniumTestWrapper.takeScreenshot();

			log.info("User send the zipCode's Number as " + pessoa.getZipCode());
		} catch (Exception e) {
			log.error("It was not possible to send mother's name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendAddressNumber() throws Exception {
		try {

			log.info("Sending address' number");
			Thread.sleep(1000);
			SeleniumTestWrapper.takeScreenshot();
			String number = String.valueOf(pessoa.getAdressNumber());
			sendElemet(inputNumberAddress, number);
			SeleniumTestWrapper.takeScreenshot();
			waitForElementAndClick(buttonConfirmarDadoAddress);
			Thread.sleep(1000);
			SeleniumTestWrapper.takeScreenshot();
			log.info("User send the address' Number as " + number);
		} catch (Exception e) {
			log.error("It was not possible to send address number name");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendCardPassword(String password) throws Exception {
		try {

			log.info("User sent card's password");
			Thread.sleep(1500);
			char[] pa = password.toCharArray();
			for (int i = 0; i < password.length(); i++) {

				if (pa[i] == '0')
					waitForElementAndClick(buttonCard0);

				if (pa[i] == '1')
					waitForElementAndClick(buttonCard1);

				if (pa[i] == '2')
					waitForElementAndClick(buttonCard2);

				if (pa[i] == '3')
					waitForElementAndClick(buttonCard3);

				if (pa[i] == '4')
					waitForElementAndClick(buttonCard4);

				if (pa[i] == '5')
					waitForElementAndClick(buttonCard5);

				if (pa[i] == '6')
					waitForElementAndClick(buttonCard6);

				if (pa[i] == '7')
					waitForElementAndClick(buttonCard7);

				if (pa[i] == '8')
					waitForElementAndClick(buttonCard8);

				if (pa[i] == '9')
					waitForElementAndClick(buttonCard9);
				Thread.sleep(1000);

			}

			SeleniumTestWrapper.takeScreenshot();
			log.info("User sent the password");
			Thread.sleep(2000);
			waitForElementAndClick(buttonConfirmarDadoPassword);
 
			Thread.sleep(15000);
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void clickOkbutton() throws Exception {
		try {

			SeleniumTestWrapper.takeScreenshot();
			if (isElementPresent(buttonOk)) {
				waitForElementAndClick(buttonOk);
				SeleniumTestWrapper.takeScreenshot();
			}
			Thread.sleep(7000);
			if (isElementPresent(fecharPopAtualizar) && isElementVisible(fecharPopAtualizar)) {
				waitForElementAndClick(fecharPopAtualizar);
			}
			Thread.sleep(3000);
			log.info("User clicked at ok button");
		} catch (Exception e) {
			log.error("It was not possible to login");
			log.error(e.getMessage());
			log.error(e.getStackTrace());
			throw e;
		}
	}

	public void sendTerms(String termoAceite, String termoComunicacao, String termoLGPD) throws Exception {
		log.info("Accepting the terms");
		Thread.sleep(4000);
		if (termoAceite.equals("true")) {
			waitForElementAndClick(checkaceitarTermos);
			log.info("Accepted Termo de privacidade");
		}
		Thread.sleep(2000);
		if (termoComunicacao.equals("true")) {
			waitForElementAndClick(checkaceitarComunicacao);
			log.info("Accepted Termo de comunicação");
		}
		Thread.sleep(2000);
		if (termoLGPD.equals("true")) {
			waitForElementAndClick(checkaceitarLGPD);
			log.info("Accepted Termo LGPD");
		}
		Thread.sleep(2000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonAceitarTermos);
		Thread.sleep(2000);
		SeleniumTestWrapper.takeScreenshot();
		waitForElementAndClick(buttonContinuarDados);

	}

}
