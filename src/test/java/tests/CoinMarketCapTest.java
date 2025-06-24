package tests;

import env.BaseClass;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pages.CoinMarketCap;

@Listeners(listeners.TestListener.class)
public class CoinMarketCapTest extends BaseClass {

    @Test(priority = 2)
    public void verifyHomePgeLoads(){
        CoinMarketCap coinMarketPage = new CoinMarketCap(getDriver());
        coinMarketPage.navigateToHomeScreen();

        String title = coinMarketPage.getPageTitle();
        Assert.assertTrue(title.contains("CoinMarketCap"),"Title doesn't contain Expected Text ");

        boolean isTableVisible = coinMarketPage.isCoinsTableVisible();
        Assert.assertTrue(isTableVisible,"Coins Table not visible");
    }

}
