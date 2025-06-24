package tests;


import env.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.GoogleSearchPage;

@Listeners(listeners.TestListener.class)
public class GoogleSearchTest extends BaseClass { // Extends BaseTest

    /**
     * Tests searching for a specific term on Google using Page Object Model.
     */
    @Test(priority = 1)
    public void testGoogleSearch() {
        System.out.println("Starting test: testGoogleSearch");
        String searchTerm = "Selenium WebDriver";
        String expectedTitlePartial = "Selenium WebDriver - Google Search";

        // Get base URL from config.properties
        String baseUrl = config.getProperty("baseUrl");
        if (baseUrl == null || baseUrl.isEmpty()) {
            System.err.println("Error: 'baseUrl' property not found in config.properties. Defaulting to Google.");
            baseUrl = "https://www.google.com"; // Fallback
        }

        GoogleSearchPage googleSearchPage = new GoogleSearchPage(getDriver());

        // 1. Navigate to Google using the Page Object
        googleSearchPage.navigateTo(baseUrl);

        System.out.println("Test testGoogleSearch completed successfully.");
    }
}
