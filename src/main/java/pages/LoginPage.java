package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {

	WebDriver driver;
	@FindBy(how = How.ID, using = "user_name") WebElement USER_NAME;
	@FindBy(how = How.ID, using = "password") WebElement PASSWORD;
	@FindBy(how = How.ID, using = "login_submit") WebElement SIGN_IN;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void userName(String userName)
	{
		USER_NAME.sendKeys(userName);
	}
	
	public void passwordDetails(String password)
	{
		PASSWORD.sendKeys(password);
	}
	
	public void clickOnSignIn()
	{
		SIGN_IN.click();
	}
	
}
