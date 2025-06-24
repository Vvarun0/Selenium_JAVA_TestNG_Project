package listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import env.BaseClass;
import org.testng.ITestResult;
import utilities.ExtentManager;
import utilities.ScreenshotUtils;



public class TestListener implements ITestListener{
    ExtentReports extent;
    ExtentTest test;

    @Override
    public void onStart(ITestContext context) {
        extent = ExtentManager.getInstance();
    }

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.pass("Test passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail("Test failed: " + result.getThrowable());

        WebDriver driver = ((BaseClass) result.getInstance()).getDriver();
        String screenshotPath = ScreenshotUtils.captureScreenshot(driver, result.getMethod().getMethodName());
        test.addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }

}
