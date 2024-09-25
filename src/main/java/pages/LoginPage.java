package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	@FindBy(xpath = "//input[@name=\"username\"]")
	public
	WebElement loginusername;
	
	@FindBy(xpath = "//input[@name=\"password\"]")
	public
	WebElement loginpassword;
	
	@FindBy(xpath = "//button[@type=\"submit\"]")
	WebElement loginbutton;
	
	@FindBy(xpath = "//p[text() = \"Invalid credentials\"]")
	WebElement errorMessage;
	
	// Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
	// Methods to check if elements are displayed (visible)
    public boolean isUsernameVisible() {
        return loginusername.isDisplayed();
    }

    public boolean isPasswordVisible() {
        return loginpassword.isDisplayed();
    }

    public boolean isLoginButtonVisible() {
        return loginbutton.isDisplayed();
    }
    
    // Method to get the font size of an element
    public String getFontSize(WebElement element) {
        return element.getCssValue("font-size");
    }
	
    // Method to perform login action
    public void login(String username, String password) {
        loginusername.sendKeys(username);
        loginpassword.sendKeys(password);
        loginbutton.click();
    }
    
    public boolean isErrorDisplayed() {
        return errorMessage.isDisplayed();
    }

}
