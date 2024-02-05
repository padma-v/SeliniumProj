package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commonelements.Base_Methods;

public class Login_UI extends Base_Methods {

	WebDriver driver;

	// Constructor
	public Login_UI(WebDriver driver) {
		this.driver = driver;

	}

	/**
	 * getLoginButton - This method finds the loginbutton Element using xpath
	 * Locator
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */
	private WebElement getLoginButton() throws InterruptedException {

		Thread.sleep(7000);
		WebElement loginButtonElement = driver.findElement(By.xpath(loginButtonLocator));
		// WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		// waiting.until(ExpectedConditions.elementToBeClickable(loginButtonElement));

		return loginButtonElement;

	}

	/**
	 * clickLoginButton - This method clicks on the login Button Element
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	public void clickLoginButton() throws InterruptedException {

		WebElement loginButton = getLoginButton();

		loginButton.click();

	}

	/**
	 * clickSignupWithEmailButton - This method clicks on the SignupwithEmail Button
	 * Element
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	public void clickSignupWithEmailButton() throws InterruptedException {

		
		WebElement signupWithEmailButton = getSignupWithEmailButton();

		signupWithEmailButton.click();

	}

	/**
	 * getSignupWithEmailButton - This method finds the SignupWithEmail button
	 * Element using xpath Locator
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	private WebElement getSignupWithEmailButton() throws InterruptedException {
		// WebDriverWait waiting = new WebDriverWait(driver, Duration.ofSeconds(10));
		// WebElement signupWithEmailButtonElement = waiting
		// .until(ExpectedConditions.presenceOfElementLocated(signupWithEmailButtonLocator));
		Thread.sleep(7000);
		
		WebElement signupWithEmailButtonElement = driver.findElement(By.xpath("//*[@id=\"switchToEmailLink_SM_ROOT_COMP786\"]/button"));
		return signupWithEmailButtonElement;
	}

	/**
	 * enterUsernameField - This method identifies and enter text in the username
	 * field
	 * 
	 * @param username from testdata Excel file (String username)
	 * @author Padma
	 * 
	 */
	public void enterUsernameField(String username) {

		driver.findElement(By.xpath("//*[@id=\"input_input_emailInput_SM_ROOT_COMP786\"]")).sendKeys(username);

	}

	/**
	 * enterPasswordField - This method identifies and enter text in the password
	 * field
	 * 
	 * @param password from testdata Excel file (String password)
	 * @author Padma
	 * 
	 */

	public void enterPasswordField(String password) {

		driver.findElement(By.xpath("//*[@id=\"input_input_passwordInput_SM_ROOT_COMP786\"]")).sendKeys(password);

	}

	/**
	 * clickSignupButton - This method clicks on the Signup Button Element
	 * 
	 * @param Does not include any parameter
	 * @author Padma
	 * 
	 */

	public void clickSignupButton() {
		driver.findElement(By.xpath(signupButtonLocator)).click();

	}

}
