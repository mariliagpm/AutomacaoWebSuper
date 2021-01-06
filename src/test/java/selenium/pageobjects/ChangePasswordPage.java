package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class ChangePasswordPage extends Pages {
	
	@FindBy(how = How.XPATH, using = "//button[@id=\"user-navbar\"]")
    public WebElement menuAccount;
	
	@FindBy(how = How.XPATH, using = "//li[@data-submenu=\"Alterar senha de acesso\"]")
    public WebElement menuChangePassword;
	
	@FindBy(how = How.XPATH, using = "//input[@name=\"currentPassword\"]")
    public WebElement oldPasswordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name=\"newPassword\"]")
    public WebElement newPasswordInput;
	
	@FindBy(how = How.XPATH, using = "//input[@name=\"confirmPassword\"]")
    public WebElement newPasswordInputR;
	
	@FindBy(how = How.XPATH, using = "//button[@data-label=\"Salvar\"]")
    public WebElement saveButton;
	
	@FindBy(how = How.XPATH, using = "//button[@data-label=\"Ok\"]")
    public WebElement okButton;

	@FindBy(how = How.XPATH, using = "//img[contains(@class,\"closeBtn\")]")
    public WebElement fecharPopAtualizar;
	
	public ChangePasswordPage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
