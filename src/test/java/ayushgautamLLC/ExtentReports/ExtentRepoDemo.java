package ayushgautamLLC.ExtentReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentRepoDemo {
	ExtentReports extent;

	@BeforeTest
	public void config() {
		// ExtentReports, ExtentSparkReporter
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Tutorial Report");
		reporter.config().setDocumentTitle("Test Reults 29Nov");

		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Ayush1.Gautam");
	}

	@Test
	public void initialDemo() {
		ExtentTest test = extent.createTest("Intial Test Demo");
		
		WebDriver driver = new ChromeDriver();
		driver.get("https://jio.com");
		driver.findElement(By.xpath("//li[1]//div[1]//a[1]")).click();
		
		System.out.println(driver.getTitle());
		driver.close();
		
		
		extent.flush();

	}
}
