package base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Browser {
    static WebDriver driver;

    
    public static WebDriver browserInitialize(String browsername, boolean headlessMode) {
        if (browsername.equalsIgnoreCase("chrome")) {
            ChromeOptions options = new ChromeOptions();
            if (headlessMode) {
                options.addArguments("--headless");  // Enable headless mode for Chrome
                options.addArguments("--disable-gpu");
                //options.addArguments("--window-size=1920,1080");  // Set screen resolution for headless mode
            }
            driver = new ChromeDriver(options);  // Initialize Chrome with options
        } else if (browsername.equalsIgnoreCase("firefox")) {
            FirefoxOptions options = new FirefoxOptions();
            if (headlessMode) {
//                options.setHeadless(true);  // Enable headless mode for Firefox
            }
            driver = new FirefoxDriver(options);  // Initialize Firefox with options
        } else {
            System.out.println("Invalid browser name. Defaulting to Chrome.");
            ChromeOptions options = new ChromeOptions();
            if (headlessMode) {
                options.addArguments("--headless");
                options.addArguments("--disable-gpu");
//                options.addArguments("--window-size=1920,1080");
            }
            driver = new ChromeDriver(options);  // Default to Chrome if browser is not specified
        }

        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));  // Set page load timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));   // Implicit wait for element loading
        return driver;
    }
}
