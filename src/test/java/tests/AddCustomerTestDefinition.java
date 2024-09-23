package tests;

import java.io.FileNotFoundException;
import java.io.FileReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import pages.AddCustomerPage;
import pages.DashBoardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class AddCustomerTestDefinition {
	
	WebDriver driver;
	JsonParser jsonParser;
	JsonElement jsonElement;
	DashBoardPage dashBoardPage;
	LoginPage loginPage;
	AddCustomerPage addCustomerPage;
	
	@BeforeMethod(alwaysRun = true)
	public void readJson()
	{
		try {
			FileReader reader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			jsonParser = new JsonParser();
			jsonElement= jsonParser.parse(reader);
			
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		}
	}
	
	@Test
	public void enterCustomerDetails() {
		
		driver = BrowserFactory.init();
		loginPage= PageFactory.initElements(driver, LoginPage.class);
		loginPage.userName(jsonElement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.passwordDetails(jsonElement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSignIn();
		dashBoardPage=PageFactory.initElements(driver, DashBoardPage.class);
		
		Assert.assertEquals(dashBoardPage.validateDashBoard(),jsonElement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("ValidationTextLogin").getAsString(), "DashBoard Page not found");
		dashBoardPage.clickOnCustomers();
		dashBoardPage.clickOnAddCustomer();
		
		addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		
		Assert.assertEquals(addCustomerPage.validateAddCustomerPage(),jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("ValidationTextAddCustomer").getAsString(),"Add Customer Page not Found");
		
		addCustomerPage.enterCustomerName(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("FullName").getAsString());
		addCustomerPage.selectCompanyName(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Company").getAsString());
		addCustomerPage.enterEmail(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Email").getAsString());
		addCustomerPage.enterPhone(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Phone").getAsString());
		
		addCustomerPage.enterAddress(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Street").getAsString());
		addCustomerPage.enterCity(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("City").getAsString());
		addCustomerPage.enterZipCode(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Zip").getAsString());
		addCustomerPage.selectCountry(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Address").getAsJsonArray().get(0).getAsJsonObject().get("Country").getAsString());
		addCustomerPage.selectGroup(jsonElement.getAsJsonObject().get("AddContact").getAsJsonObject().get("Group").getAsString());
		addCustomerPage.clickOnSave();
	}

}
