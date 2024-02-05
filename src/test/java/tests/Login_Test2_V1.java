package tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commonelements.Base_Methods;
import pages.Login_UI;

public class Login_Test2_V1 extends Base_Methods {

	WebDriver driver;
	static Properties testdata;
	static String invalidloginError = "Double check your email and try again";
	static String EmptyloginError = "Email cannot be blank";
	
	
	@Parameters("browser")
	@BeforeSuite

	public void initiateDriver(String browser) throws IOException {

		
		switch (browser) {
		case "Chrome":
			driver = new ChromeDriver();
			break;
		case "Firefox":
			driver = new FirefoxDriver();
			break;
		case "Safari":
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		propertiesFileSetup();
	}

	@AfterSuite
	public void quitDriver() {

		driver.quit();

	}

	@Parameters("websiteurl")
	@Test(priority = 3, groups = "Login")
	public void signUpTestWithEmptyCredentials(String websiteurl) throws InterruptedException, IOException {

		driver.get(websiteurl);

		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();

		loginpage.clickSignupWithEmailButton();

		Base_Methods.readDataFromExcelFile(3);
		loginpage.enterUsernameField(Base_Methods.username);
		loginpage.enterPasswordField(Base_Methods.password);
		loginpage.clickSignupButton();
		
		if (driver.getPageSource().contains(EmptyloginError)) {
			
			writeintoExcelFile(3,"Pass");
			takeScreenShot(driver);
			
		} else {
			writeintoExcelFile(3,"Fail");
		}
		
		
	
	}

	@Parameters("websiteurl")
	@Test(priority = 2, groups = "Login")
	public void signUpTestWithValidCredentials(String websiteurl) throws InterruptedException, IOException {

		driver.get(websiteurl);
		

		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();

		loginpage.clickSignupWithEmailButton();
		
		Base_Methods.readDataFromExcelFile(2);
		loginpage.enterUsernameField(Base_Methods.username);
		loginpage.enterPasswordField(Base_Methods.password);
		loginpage.clickSignupButton();
		
		if (driver.getPageSource().contains("Padma")) {
			
			writeintoExcelFile(2,"Pass");
			takeScreenShot(driver);
			
		} else {
			writeintoExcelFile(2,"Fail");
		}
		
		
	}

	@Parameters("websiteurl")
	@Test(priority = 1, groups = "Login")
	public void signUpTestWithInvalidCredentials(String websiteurl) throws InterruptedException, IOException {

		driver.get(websiteurl);

		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();

		loginpage.clickSignupWithEmailButton();

		Base_Methods.readDataFromExcelFile(1);
		loginpage.enterUsernameField(Base_Methods.username);
		loginpage.enterPasswordField(Base_Methods.password);
		loginpage.clickSignupButton();
		
         if (driver.getPageSource().contains(invalidloginError)) {
        	
        	writeintoExcelFile(1,"Pass");
			Base_Methods.takeScreenShot(driver);
			
		} else {
			writeintoExcelFile(1,"Fail");
		}
		 

	}

}
