package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class DashBoardPage{
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//strong[text()='Dashboard']") WebElement DASHBOARD;
	@FindBy(how = How.XPATH, using = "//span[text()='Customers']") WebElement CUSTOMERS_LINK;
	@FindBy(how = How.XPATH, using = "//span[text()='Add Customer']") WebElement ADD_CUSTOMER_LINK;
	
	
	public DashBoardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String validateDashBoard()
	{
		return DASHBOARD.getText();
	}
	
	public void clickOnCustomers()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CUSTOMERS_LINK.click();	
	}
	
	public void clickOnAddCustomer()
	{
		ADD_CUSTOMER_LINK.click();
	}

}
