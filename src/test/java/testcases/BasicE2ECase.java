package testcases;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.Browser;
import base.Report;
import pages.LoginPage;

import com.aventstack.extentreports.ExtentTest;

public class BasicE2ECase {
	static WebDriver driver;
    static ExtentTest test;
    static LoginPage loginPage;  // Reference to the LoginPage class
    
    @BeforeMethod
    public void initialize() {
        driver = Browser.browserInitialize("chrome", false);  // Initialize browser (assume this is defined elsewhere)
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        loginPage = new LoginPage(driver);
    }

    @Test(priority = 1)
    public void TC001_verifyVisibilityOfElements() {
        // Create a test entry in the Extent Report
        test = Report.createTest("Verify visibility of username, password, and login button");
        
        try {
            // Assert that all elements are visible
            assertEquals(loginPage.isUsernameVisible(), true, "Username field is not visible");
            assertEquals(loginPage.isPasswordVisible(), true, "Password field is not visible");
            assertEquals(loginPage.isLoginButtonVisible(), true, "Login button is not visible");
            
            // Pass the test if everything is visible
            test.pass("Username, password fields, and login button are visible.");
        } catch (AssertionError e) {
            // If any assertion fails, log it as a failure in Extent Report
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow the exception to let TestNG handle it
        }
    }

    @Test(priority = 2)
    public void TC002_verifyFontSizeOfElements() {
        test = Report.createTest("Verify font size of the text elements");

        try {
            // Check font size of username and password fields
            String usernameFontSize = loginPage.getFontSize(loginPage.loginusername);
            String passwordFontSize = loginPage.getFontSize(loginPage.loginpassword);
            
            // Expected font size (replace these values with your actual expected values)
            String expectedFontSize = "12px"; // Replace with the actual expected size

            // Perform assertions to verify the font sizes
            assertEquals(usernameFontSize, expectedFontSize, "Username font size is incorrect.");
            assertEquals(passwordFontSize, expectedFontSize, "Password font size is incorrect.");
            
            // If the assertions pass, log the success message
            test.pass("Font size validation passed successfully for username and password fields.");
        } catch (AssertionError e) {
            // If any assertion fails, log it as a failure in Extent Report and rethrow the error
            test.fail("Font size validation failed: " + e.getMessage());
            throw e;
        }
    }


    @Test(priority = 3)
    public void TC003_verifyLoginLogout() {
        test = Report.createTest("Verify login logout button functionality");

        try {
            // Test with valid credentials
            String validUsername = "Admin"; // Replace with a valid username
            String validPassword = "admin123"; // Replace with a valid password
            String expectedPageTitle = "OrangeHRM"; // The expected page title after successful login

            // Perform login with valid credentials
            loginPage.login(validUsername, validPassword);
            
            // Validate that the page title is correct after login
            assertEquals(driver.getTitle(), expectedPageTitle, "Page title is incorrect after valid login.");
            
            // Logout
            driver.findElement(By.className("oxd-userdropdown-tab")).click();
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
            
            // Test with invalid credentials
            String invalidUsername = "Admin"; // Using the same valid username
            String invalidPassword = "wrongpassword"; // Replace with an invalid password
            
            // Perform login with invalid credentials
            loginPage.login(invalidUsername, invalidPassword);

            // Assuming there's a method in LoginPage to check for an error message after a failed login
            boolean isErrorDisplayed = loginPage.isErrorDisplayed(); // Implement this method in LoginPage
            assertEquals(isErrorDisplayed, true, "Error message was not displayed for invalid login.");
            
            // Log test as passed if all assertions are correct
            test.pass("Login and Logout button functionality validation passed successfully.");
        } catch (AssertionError e) {
            // If any assertion fails, log it as a failure in Extent Report
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow the assertion error to ensure TestNG marks the test as failed
        } catch (Exception e) {
            // Log any other exceptions that occur during the test
            test.fail("An unexpected error occurred: " + e.getMessage());
            throw e; // Rethrow to let TestNG know the test encountered an issue
        }
    }

//    @Test(priority = 4)
//    public void TC004() {
//        test = Report.createTest("Verify the application on different resolutions/devices");
//        test.pass("Application responsiveness validation passed successfully.");
//    }

    @Test(priority = 4)
    public void TC005_verifyLoginWithValidCredentials() {
        test = Report.createTest("Verify login with valid credentials");
        
        try {
            // Test with valid credentials
            String validUsername = "Admin"; // Replace with a valid username
            String validPassword = "admin123"; // Replace with a valid password
            String expectedPageTitle = "OrangeHRM"; // The expected page title after successful login

            // Perform login with valid credentials
            loginPage.login(validUsername, validPassword);
            
            // Validate that the page title is correct after login
            assertEquals(driver.getTitle(), expectedPageTitle, "Page title is incorrect after valid login.");
            
            // Log success if everything is as expected
            test.pass("Login with valid credentials validation passed successfully.");

            // Logout after successful login
            driver.findElement(By.className("oxd-userdropdown-tab")).click();
            driver.findElement(By.xpath("//a[text()='Logout']")).click();
            
            test.pass("User logged out successfully.");
        } catch (AssertionError e) {
            // Log assertion errors
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow the assertion error to fail the test
        } catch (Exception e) {
            // Log any other exceptions
            test.fail("An unexpected error occurred: " + e.getMessage());
            throw e; // Rethrow to ensure TestNG marks the test as failed
        }
    }


    @Test(priority = 5)
    public void TC006_verifyLoginWithInvalidCredentials() {
        test = Report.createTest("Verify login with valid username and invalid password");
        
        try {
            // Test with invalid credentials
            String invalidUsername = "Admin"; // Using the same valid username
            String invalidPassword = "wrongpassword"; // Replace with an invalid password
            
            
            // Perform login with invalid credentials
            loginPage.login(invalidUsername, invalidPassword);

            // Check for the error message or indication that login failed
            boolean isErrorDisplayed = loginPage.isErrorDisplayed(); // Implement this method in LoginPage
            assertEquals(isErrorDisplayed, true , "Error message was not displayed for invalid login.");

            
            // Log success in the report
            test.pass("Login with valid username and invalid password validation passed successfully.");
            
        } catch (AssertionError e) {
            // Log assertion errors
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow the assertion error to fail the test
        } catch (Exception e) {
            // Log any other exceptions
            test.fail("An unexpected error occurred: " + e.getMessage());
            throw e; // Rethrow to ensure TestNG marks the test as failed
        }
    }


//    @Test(priority = 7)
//    public void TC007() {
//        test = Report.createTest("Verify that username and password can be filled using copy and paste");
//        test.pass("Username and password copy-paste validation passed successfully.");
//    }

//    @Test(priority = 7)
//    public void TC008() {
//        test = Report.createTest("Verify the login button is clickable for login");
//        test.pass("Login button click validation passed successfully.");
//    }

//    @Test(priority = 9)
//    public void TC009() {
//        test = Report.createTest("Verify the Enter key can be used for login");
//        test.pass("Login using the Enter key validation passed successfully.");
//    }

    @Test(priority = 6)
    public void TC010_verifyLoginWithUsernameOnly() {
        test = Report.createTest("Verify login attempt with username only");
        
        try {
            String validUsername = "Admin"; // Replace with a valid username
            String emptyPassword = ""; // Leave password field empty

            // Perform login with only username
            loginPage.login(validUsername, emptyPassword);

            // Check for an error message or some indication that login failed
            boolean isErrorDisplayed = loginPage.isErrorDisplayed(); // Ensure this method is implemented
            assertEquals(isErrorDisplayed, true, "Error message was not displayed for empty password.");

            // Log success in the report
            test.pass("Validation passed for login attempt with only username.");
            
        } catch (AssertionError e) {
            // Log assertion errors
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow to ensure the test fails
        } catch (Exception e) {
            // Log any unexpected errors
            test.fail("An unexpected error occurred: " + e.getMessage());
            throw e; // Rethrow for proper test failure
        }
    }

    @Test(priority = 7)
    public void TC011_verifyLoginWithPasswordOnly() {
        test = Report.createTest("Verify login attempt with password only");
        
        try {
            String emptyUsername = ""; // Leave username field empty
            String validPassword = "admin123"; // Replace with a valid password
           

            // Perform login with only password
            loginPage.login(emptyUsername, validPassword);

            // Check for an error message or some indication that login failed
            boolean isErrorDisplayed = loginPage.isErrorDisplayed(); // Ensure this method is implemented
            assertEquals(isErrorDisplayed, true, "Error message was not displayed for empty username.");

            

            // Log success in the report
            test.pass("Validation passed for login attempt with only password.");
            
        } catch (AssertionError e) {
            // Log assertion errors
            test.fail("Test failed due to: " + e.getMessage());
            throw e; // Rethrow to ensure the test fails
        } catch (Exception e) {
            // Log any unexpected errors
            test.fail("An unexpected error occurred: " + e.getMessage());
            throw e; // Rethrow for proper test failure
        }
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();  // Close the browser
        Report.flushReport();  // Flush the Extent report after each test
    }

}
