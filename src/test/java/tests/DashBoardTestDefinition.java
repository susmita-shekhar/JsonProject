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

import pages.DashBoardPage;
import pages.LoginPage;
import util.BrowserFactory;

public class DashBoardTestDefinition{
	
	WebDriver driver;
	DashBoardPage dashBoardPage;
	String dashBoard = "Dashboard";
	JsonParser jsonParser;
	JsonElement jsonElement;
	LoginPage loginPage;

	@SuppressWarnings("deprecation")
	@BeforeMethod(alwaysRun = true)
	public void readJson()
	{
		try {
			FileReader reader = new FileReader("src\\main\\java\\testData\\TF_TestData.json");
			jsonParser = new JsonParser();
			jsonElement = jsonParser.parse(reader);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void userShouldaBeAbleToLogIn()
	{
		driver = BrowserFactory.init();
		loginPage = PageFactory.initElements(driver,LoginPage.class);
		loginPage.userName(jsonElement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("UserName").getAsString());
		loginPage.passwordDetails(jsonElement.getAsJsonObject().get("LoginInfo").getAsJsonObject().get("Password").getAsString());
		loginPage.clickOnSignIn();
		
		dashBoardPage = PageFactory.initElements(driver,DashBoardPage.class);
		
		
		Assert.assertEquals(dashBoardPage.validateDashBoard(),dashBoard, "DashBoard Page not found");
		
		dashBoardPage.clickOnCustomers();
		dashBoardPage.clickOnAddCustomer();
	}
	
	
}
