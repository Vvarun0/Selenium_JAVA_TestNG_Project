package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class GoogleSearchPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators
    private final By searchInputField = By.name("q");

    // Constructor
    public GoogleSearchPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }


    public void navigateTo(String url) {
        System.out.println("Navigating to: " + url);
        driver.get(url);
    }

    public void enterSearchTerm(String searchTerm) {
        System.out.println("Entering search term: " + searchTerm);
        // Wait until the search input field is visible and clickable
        WebElement searchBox = wait.until(ExpectedConditions.visibilityOfElementLocated(searchInputField));
        searchBox.sendKeys(searchTerm);
        searchBox.sendKeys(Keys.ENTER);
    }


    public String getPageTitle() {
        return driver.getTitle();
    }
}

