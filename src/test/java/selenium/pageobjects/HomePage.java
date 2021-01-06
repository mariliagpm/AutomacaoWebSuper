package selenium.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HomePage extends Pages {



	@FindBy(how = How.XPATH, using = "//a[@data-class=\"holos-link-register\"]")
    public WebElement createAccountButton;
	
	@FindBy(how = How.XPATH, using = "//img[contains(@class,\"closeBtn\")]")
    public WebElement fecharPopAtualizar;
	
	public HomePage(final WebDriver driver) {
		super(driver);
	}

	public void open() {
		super.open();
	}

}
