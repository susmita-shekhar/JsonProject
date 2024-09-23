package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class AddCustomerPage extends BasePage {
	
	WebDriver driver;
	
	@FindBy(how = How.XPATH, using = "//strong[text()='New Customer']") WebElement ADD_CUSTOMER_PAGE;
	@FindBy(how = How.XPATH, using="//input[@class='form-control name ']") WebElement FULL_NAME;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[2]/div/select") WebElement COMPANY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[3]/div/input") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"phone\"]") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[5]/div/input") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[6]/div/input") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"port\"]") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"general_compnay\"]/div[8]/div[1]/select") WebElement COUNTRY_DROPDOWN_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"customer_group\"]") WebElement GROUP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"save_btn\"]") WebElement SAVE_BUTTON_ELEMENT;

	public AddCustomerPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public String validateAddCustomerPage()
	{
		
		return ADD_CUSTOMER_PAGE.getText();
		
	}
	
	public void enterCustomerName(String customerName)
	{
		String name=customerName+generateRandomNum(999);
		FULL_NAME.sendKeys(name);
	}
	
	public void selectCompanyName(String companyName)
	{
		selectFromDropdown(COMPANY_DROPDOWN_ELEMENT,companyName);
	}
	
	public void enterEmail(String customerEmail)
	{
		String email = generateRandomNum(999)+customerEmail;
		EMAIL_ELEMENT.sendKeys(email);
	}
	
	public void enterPhone(String customerPhone)
	{
		String phone = customerPhone+generateRandomNum(999);
		PHONE_ELEMENT.sendKeys(phone);
	}
	
	public void enterAddress(String address)
	{
		ADDRESS_ELEMENT.sendKeys(address);
	}
	
	public void enterCity(String city)
	{
		CITY_ELEMENT.sendKeys(city);
	}
	
	public void enterZipCode(String zipcode)
	{
		ZIP_ELEMENT.sendKeys(zipcode);
	}
	
	public void selectCountry(String country)
	{
		selectFromDropdown(COUNTRY_DROPDOWN_ELEMENT,country);
	}
	
	public void selectGroup(String group)
	{
		selectFromDropdown(GROUP_ELEMENT,group);
	}
	
	public void clickOnSave()
	{
		SAVE_BUTTON_ELEMENT.click();
	}
	
}
