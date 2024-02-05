package stepdefenitions;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import commonelements.Base_Methods;
import pages.Login_UI;


public class LoginScripts extends Base_Methods {

	WebDriver driver;
	String websiteurl = "https://www.itlearnner.com/";
	
	

	@Given("Data from properties file has been loaded")
	public void Data_from_properties_file_has_been_loaded() throws IOException {
		propertiesFileSetup();
	}

	@And("the browser has initiated")
	public void the_rowser_has_initiated() {
		driver = new ChromeDriver();
	}

	@Given("the user opens IT Learnner website")
	public void the_user_opens_it_learnner_website() {
		driver.get(websiteurl);
	}

	@When("the user enters valid username and password")
	public void the_user_enters_valid_username_and_password() throws InterruptedException, IOException {
		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();
		
		loginpage.clickSignupWithEmailButton();

		Base_Methods.readDataFromExcelFile(1);
		loginpage.enterUsernameField(Base_Methods.username);
		loginpage.enterPasswordField(Base_Methods.password);
		loginpage.clickSignupButton();
	}

	@Then("the user should be logged in to the application successfully")
	public void the_user_should_be_logged_in_to_the_application_successfully() {
   if (driver.getPageSource().contains("Padma")) {
			
			System.out.println("User logged in Successfully");
			
			
		} else {
			
			System.out.println("Login attempt failed");
		}
		
	}

	
	@When("the user enters  {string} and  {string}")
	public void the_user_enters_and(String username, String password) throws InterruptedException {
		
		System.out.println("username *******:" +username +password);
		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();
		
		loginpage.clickSignupWithEmailButton();

		
		driver.findElement(By.xpath(userNameFieldLocator)).sendKeys(username);
		driver.findElement(By.xpath(passwordFieldLocator)).sendKeys(password);
		loginpage.clickSignupButton();
	}
	
	
	
	@Then("the login {string}")
	public void the_login(String string) {
		System.out.println("Login attempt failed");
	}

	@When("the user enters username  and password ")
	public void the_user_enters_username_and_password() throws InterruptedException {
		Login_UI loginpage = new Login_UI(driver);

		loginpage.clickLoginButton();
		
		loginpage.clickSignupWithEmailButton();

		
		driver.findElement(By.xpath(userNameFieldLocator)).sendKeys(username);
		driver.findElement(By.xpath(passwordFieldLocator)).sendKeys(password);
		loginpage.clickSignupButton();
	}

	@Then("the login Fail")
	public void the_login_fail() {
		System.out.println("Login attempt failed");
	}
}
