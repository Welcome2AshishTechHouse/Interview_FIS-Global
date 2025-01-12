package webPages;

import commonUtils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eBayHomePage {

    private WebDriver driver;

    @FindBy(id = "gh-ac")
    private WebElement searchBox;

    @FindBy(id = "gh-btn")
    private WebElement searchButton;

    @FindBy(xpath = "//ul//li[@data-view='mi:1686|iid:1']//span[@aria-level='3']")
    private WebElement firstResult;


    public eBayHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchForBook(String query) {
        searchBox.sendKeys(query);
        searchButton.click();
    }

    public void selectFirstResult() {
        firstResult.click();
    }
}
