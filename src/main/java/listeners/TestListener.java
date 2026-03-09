package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.*;

import base.DriverFactory;
import reports.ExtentManager;
import utils.ScreenshotUtil;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getReport();
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
    	String browser = result.getTestContext().getCurrentXmlTest().getParameter("browser");
    	if(browser == null || browser.isEmpty()){
    	    browser = "Chrome"; // default
    	}

        ExtentTest extentTest = extent.createTest(
                result.getName() + " - " + browser,
                "Verify end-to-end flight booking functionality");

        extentTest.assignAuthor("Kumar Prakhar");
        extentTest.assignCategory("Flight Booking Test");
        extentTest.info("Browser: " + browser);
        extentTest.info("Test Started");

        test.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
        test.get().pass("Test Passed").addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String screenshotPath = ScreenshotUtil.captureScreenshot(DriverFactory.getDriver(), result.getName());
        test.get().fail(result.getThrowable()).addScreenCaptureFromPath(screenshotPath);
    }

    @Override
    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}