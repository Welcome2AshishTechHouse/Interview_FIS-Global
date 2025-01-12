package stepDefs.ui;

import commonUtils.DriverUtils;
import commonUtils.ScreenshotUtils;
import io.cucumber.java.*;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import projectManager.PropertyManager;
import webPages.eBayHomePage;
import webPages.eBayListingPage;

public class EBaySteps {

    private WebDriver driver;
    private eBayHomePage homePage;
    private eBayListingPage listingPage;;
    private ScreenshotUtils screenshotUtils;
    private Scenario scenario;

    @Before
    public void setUp(Scenario scenario) {
        this.scenario = scenario;
        if (scenario.getSourceTagNames().toString().contains("@ui")) {
            DriverUtils.initializeDriver();
            driver = DriverUtils.driver;
            homePage = new eBayHomePage(driver);
            listingPage = new eBayListingPage(driver);
            screenshotUtils = new ScreenshotUtils(driver);
            scenario.log("<b>Driver initialized and eBay URL retrieved.</b>");
        }
    }

    @After
    public void tearDown() {
        DriverUtils.quitDriver();
    }

    @Given("Open browser navigate to {string}")
    public void openBrowserNavigateTo(String ebayUrl) {
        ebayUrl = PropertyManager.getInstance().getProperty(ebayUrl);
        driver.get(ebayUrl);
        scenario.log("<b>Browser opened and navigated to eBay URL:</b> " + ebayUrl);
        screenshotUtils.captureScreenshot("The_Browser_Is_Open");
    }

    @And("Search for {string}")
    public void searchFor(String query) {
        homePage.searchForBook(query);
        scenario.log("<b>Searched for book with query:</b> " + query);
        screenshotUtils.captureScreenshot("Search_For_Book");
    }

    @And("Click on the first book in results")
    public void clickOnTheFirstBookInResults() {
        homePage.selectFirstResult();
        scenario.log("<b>Clicked on the first book in the search results.</b>");
        screenshotUtils.captureScreenshot("Click_On_First_Book");
    }

    @And("Add the book to the cart from the item listing page")
    public void addTheBookToTheCartFromTheItemListingPage() {
        DriverUtils.windowHandler(driver);
        listingPage.addToCart();
        scenario.log("<b>Added the book to the cart.</b>");
    }

    @Then("Validate cart updated with the correct number of items")
    public void iShouldSeeTheCartUpdatedWithTheCorrectNumberOfItems() {
        String cartCount = listingPage.getCartCount();
        Assert.assertTrue(Integer.parseInt(cartCount) > 0, "Cart count should be greater than 0.");
        scenario.log("<b>Cart updated with the correct number of items:</b> " + cartCount);
        screenshotUtils.captureScreenshot("Cart_Updated_With_Correct_Items");
    }
}
