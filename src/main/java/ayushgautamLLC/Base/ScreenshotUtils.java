package ayushgautamLLC.Base;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testCaseName) {

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String folderPath = System.getProperty("user.dir") + "/reports/screenshots/";
        String screenshotPath = folderPath + testCaseName + "_" + timestamp + ".png";

        try {
            File folder = new File(folderPath);
            if (!folder.exists())
                folder.mkdirs();

            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(source, new File(screenshotPath));

        } catch (Exception e) {
            System.out.println("❌ Screenshot failed: " + e.getMessage());
        }

        return screenshotPath;
    }
}
