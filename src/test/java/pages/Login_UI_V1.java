package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import commonelements.Base_Methods;

public class Login_UI_V1 {

	WebDriver driver;

	// Web Elements
	private By loginButtonLocator = By.xpath("//*[@id=\'comp-lier1u7e\']/button/span");
	private By signupWithEmailButtonLocator = By.xpath("//*[@id=\'switchToEmailLink_SM_ROOT_COMP785\']");
	private By userNameFieldLocator = By.xpath("//*[@id='input_input_emailInput_SM_ROOT_COMP785']");
	private By passwordFieldLocator = By.xpath("//*[@id='input_input_passwordInput_SM_ROOT_COMP785']");
	private By signupButtonLocator = By.xpath("//*[@id='okButton_SM_ROOT_COMP785']/button");

	
	// Constructor
	public Login_UI_V1(WebDriver driver) {
		this.driver = driver;

	}

	private WebElement getLoginButton() throws InterruptedException {

     Thread.sleep(5000);
     return driver.findElement(loginButtonLocator);
	// WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
	// WebElement loginButtonElement = waiting.until(ExpectedConditions.presenceOfElementLocated(loginButtonLocator));
	//	return loginButtonElement;
	

	}

	public void clickLoginButton() throws InterruptedException {

		//WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement loginButton = waiting.until(ExpectedConditions.elementToBeClickable(getLoginButton()));
		
		
		WebElement loginButton = getLoginButton();
		
		loginButton.click();

	}

	public void clickSignupWithEmailButton() throws InterruptedException {
		//WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		//WebElement signupWithEmailButton = waiting.until(ExpectedConditions.elementToBeClickable(getSignupWithEmailButton()));
		
		WebElement signupWithEmailButton = getSignupWithEmailButton();
		signupWithEmailButton.click();
		
	//	WebElement signupWithEmailButton = getSignupWithEmailButton();
	//	signupWithEmailButton.click();

	}

	private WebElement getSignupWithEmailButton() throws InterruptedException {
		WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement signupWithEmailButtonElement = waiting.until(ExpectedConditions.presenceOfElementLocated(signupWithEmailButtonLocator));
	//	Thread.sleep(5000);
	//	return driver.findElement(signupWithEmailButtonLocator);
		return signupWithEmailButtonElement;
	}

	public void enterUsernameField(String username) {
		
		System.out.println("username : "+ username);
		
		driver.findElement(userNameFieldLocator).sendKeys(username);

	}

	public void enterPasswordField(String password) {
		
		System.out.println("password : "+ password);
		driver.findElement(passwordFieldLocator).sendKeys(password);

	}

	public void clickSignupButton() {
		driver.findElement(signupButtonLocator).click();

	}

}
