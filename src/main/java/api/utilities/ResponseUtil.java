package api.utilities;

import io.restassured.response.Response;
import org.json.JSONObject;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
public class ResponseUtil {

    public static String getValueFromResponse(Response response, String indexName) {
        JSONObject responseJSONObject = new JSONObject(response.getBody().asString());
        return responseJSONObject.get(indexName).toString();
    }

    public static String getResponseCode(Response response) {
        return String.valueOf(response.getStatusCode());

    }
}
