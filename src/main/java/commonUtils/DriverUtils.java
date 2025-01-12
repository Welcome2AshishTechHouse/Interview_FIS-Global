package commonUtils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import java.util.Set;

public class DriverUtils {

    public static WebDriver driver;

    public static void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
        }
    }

    public static void windowHandler(WebDriver driver) {
        String parentWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        for (String window : windows) {
            if (!parentWindow.equalsIgnoreCase(window)) {
                driver.switchTo().window(window);
            }
        }
    }
}
