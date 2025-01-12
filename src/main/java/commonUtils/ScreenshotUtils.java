package commonUtils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.cucumber.java.Scenario;
import projectManager.ScenarioManager;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;

public class ScreenshotUtils {

    private static final Logger logger = LoggerFactory.getLogger(ScreenshotUtils.class);
    private final WebDriver driver;

    public ScreenshotUtils(WebDriver driver) {
        this.driver = driver;
    }

    public void captureScreenshot(String screenshotName) {
        String latestFolder = getLatestFolder("./TestAutomationResults");
        if (latestFolder == null) {
            logger.error("No folders found in the TestResult directory.");
            return;
        }

        File screenshotDir = new File(latestFolder + "/screenshots");
        if (!screenshotDir.exists()) {
            screenshotDir.mkdirs();
        }

        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String destinationPath = screenshotDir.getAbsolutePath() + "/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(source, new File(destinationPath));
            logger.info("Screenshot taken: " + destinationPath);
            String base64Screenshot = convertToBase64(source);
            ScenarioManager.getInstance().getScenario().log("<b>Screenshot:</b><br><img src='data:image/png;base64," + base64Screenshot + "' height='400' width='400'/><br>");
        } catch (IOException e) {
            logger.error("Exception while taking screenshot: ", e);
        }
    }

    private static String getLatestFolder(String basePath) {
        File baseDir = new File(basePath);
        if (!baseDir.exists() || !baseDir.isDirectory()) {
            return null;
        }

        File[] directories = baseDir.listFiles(File::isDirectory);
        if (directories == null || directories.length == 0) {
            return null;
        }

        Arrays.sort(directories, Comparator.comparingLong(File::lastModified).reversed());
        return directories[0].getAbsolutePath();
    }

    private static String convertToBase64(File file) {
        try {
            byte[] fileContent = FileUtils.readFileToByteArray(file);
            return Base64.getEncoder().encodeToString(fileContent);
        } catch (IOException e) {
            logger.error("Exception while converting file to Base64: ", e);
            return null;
        }
    }
}
