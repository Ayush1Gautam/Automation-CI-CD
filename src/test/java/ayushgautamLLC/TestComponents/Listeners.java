package ayushgautamLLC.TestComponents;

import java.lang.reflect.Field;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

import ayushgautamLLC.Base.BaseTest;
import ayushgautamLLC.Base.ExtentReportManager;
import ayushgautamLLC.Base.ScreenshotUtils;

public class Listeners extends BaseTest implements ITestListener {

    ExtentTest test;
    ExtentReports extent = ExtentReportManager.getReportObject();
    WebDriver driver;
    ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

    @Override
    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
    	extentTest.get().log(Status.PASS, "Test Passed!");
    }

    @Override
    public void onTestFailure(ITestResult result) {
    	extentTest.get().fail(result.getThrowable());
        
        try {
            // Fetch driver instance from the test class
            Object testClassInstance = result.getInstance();
            Field driverField = testClassInstance.getClass().getSuperclass().getDeclaredField("driver");
            driverField.setAccessible(true);
            driver = (WebDriver) driverField.get(testClassInstance);

        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            // 👇 TAKE SCREENSHOT BEFORE DRIVER IS CLOSED
            String screenshotPath = ScreenshotUtils.takeScreenshot(driver, result.getMethod().getMethodName());

           
            extentTest.get().fail("Screenshot:",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());

        } catch (Exception e) {
            System.out.println("❌ Unable to attach screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
