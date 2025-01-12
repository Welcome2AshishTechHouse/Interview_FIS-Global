package stepDefs.api;

import commonUtils.ApiUtils;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.path.json.JsonPath;
import projectManager.PropertyManager;
import projectManager.ScenarioManager;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import java.util.List;
import java.util.Map;

public class CoinDeskSteps {

    private String apiEndpoint;
    private JsonPath jsonResponse;
    private final Scenario scenario = ScenarioManager.getInstance().getScenario();

    @Given("API endpoint is {string}")
    public void theApiEndpointIs(String endpoint) {
        apiEndpoint = PropertyManager.getInstance().getProperty(endpoint);
        scenario.log("<b>EndPoint Used:</b> <pre>" + apiEndpoint + "</pre>");
    }

    @When("Sent GET request to the endpoint")
    public void aGETRequestIsSentToTheEndpoint() {
        String apiResponse = ApiUtils.getResponse(apiEndpoint);
        jsonResponse = ApiUtils.getJsonPath(apiResponse);
        scenario.log("<b>API Response Used:</b> <pre>" + apiResponse + "</pre>");
    }

    @Then("Response status code equal to {int}")
    public void theResponseStatusCodeShouldBe(int expectedStatusCode) {
        int actualStatusCode = ApiUtils.getStatusCode(apiEndpoint);
        scenario.log("<b>Status Code received from Server:</b> <pre>" + actualStatusCode + "</pre>");
        assertThat("The status code is not as expected", actualStatusCode, equalTo(expectedStatusCode));
    }

    @Then("Response should contain {int} BPIs:")
    public void theResponseShouldContainBPIs(int expectedBpiCount, List<Map<String, String>> dataTable) {
        Map<String, Object> bpis = jsonResponse.getMap("bpi");
        scenario.log("<b>Number of BPIs found:</b> <pre>" + bpis.size() + "</pre>");
        assertThat("The number of BPIs is not as expected", bpis.size(), equalTo(expectedBpiCount));
        for (Map<String, String> row : dataTable) {
            assertThat("BPI not found in response", bpis.keySet(), hasItem(row.get("BPIs")));
            scenario.log("<b>BPI found:</b> <pre>" + row.get("BPIs") + "</pre>");
        }
    }

    @Then("Validate {string} description should equal {string}")
    public void validateTheDescriptionShouldEqual(String bpi, String expectedDescription) {
        String actualDescription = jsonResponse.getString("bpi." + bpi + ".description");
        assertThat("The description is not as expected", actualDescription, equalTo(expectedDescription));
        scenario.log("<b>Description for BPI \"" + bpi + "\":</b> <pre>" + actualDescription + "</pre>");
    }
}
