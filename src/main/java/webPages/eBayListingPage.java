package webPages;

import commonUtils.DriverUtils;
import commonUtils.ScreenshotUtils;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class eBayListingPage {
    public WebDriver driver;

    @FindBy(id = "atcBtn_btn_1")
    private WebElement addToCartButton;

    @FindBy(id = "gh-cart-n")
    private WebElement cartCount;

    public eBayListingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void addToCart()  {
        addToCartButton.click();
    }

    public String getCartCount() {
        return cartCount.getText();
    }

}

