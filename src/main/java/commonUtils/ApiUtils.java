package commonUtils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.path.json.JsonPath;

public class ApiUtils {


    public static JsonPath getJsonPath(String response) {
        return new JsonPath(response);
    }

    public static int getStatusCode(String endpoint) {
        return RestAssured.get(endpoint).getStatusCode();
    }

    public static String getResponse(String endpoint) {
        return RestAssured.get(endpoint).asPrettyString();
    }


}
