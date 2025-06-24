package env; // Updated package

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class BaseClass {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected Properties config;

    public WebDriver getDriver() {
        return driver.get();
    }


    public BaseClass() {
        config = new Properties();
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
            config.load(fis);
            System.out.println("Configuration properties loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error loading config.properties: " + e.getMessage());
        }
    }


    @BeforeMethod
    public void setUp() {

        String browser = config.getProperty("browser", "chrome").toLowerCase();
        System.out.println("Setting up WebDriver for browser: " + browser);

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver.set(new FirefoxDriver());
                break;
            default:
                System.out.println("Invalid browser specified in config.properties. Defaulting to Chrome.");
                WebDriverManager.chromedriver().setup();
                driver.set(new ChromeDriver());
                break;
        }
        getDriver().manage().window().maximize(); // Maximize the browser window
        System.out.println("WebDriver initialized successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            System.out.println("Quitting WebDriver.");
            driver.get().quit();
            driver.remove();
            System.out.println("WebDriver quit successfully.");
        }
    }
}
