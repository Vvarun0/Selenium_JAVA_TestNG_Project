package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoinMarketCap {
     private final WebDriver driver;
     private final By coinsTable = By.cssSelector("table.cmc-table");

     public CoinMarketCap(WebDriver driver)
     {
         this.driver=driver;
     }
     public String getPageTitle(){
         return driver.getTitle();
     }

     public boolean isCoinsTableVisible(){
         return !driver.findElements(coinsTable).isEmpty();
     }

     public void navigateToHomeScreen(){
         driver.get("https://coinmarketcap.com/");

     }

}
