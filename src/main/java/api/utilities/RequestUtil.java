package api.utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
public class RequestUtil {

    private static final Logger LOGGER = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    public static Response commonGETRequest(String pathParamName, String pathParamData, String URI) {
        LOGGER.info("GET Request Initiated .....");
        Response response = given()
                .pathParam(pathParamName, pathParamData)
                .when()
                .get(URI);
        System.out.println("URL:" + URI.replace("{" + pathParamName + "}", pathParamData));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        response.then().log().all();

        return response;
    }


    public static Response commonPOSTRequest(Object payload, String URI) {
        LOGGER.info("POST Request Initiated .....");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(URI);
        System.out.println("URL:" + URI);
        List<Object> obj = new ArrayList<>();
        obj.add(payload);
        System.out.println("Request Body:" + CommonUtils.convertPojoToJson(obj));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        response.then().log().all();

        return response;
    }


    public static Response commonPUTRequest(String pathParamName, String pathParamData, Object payload, String URI) {
        LOGGER.info("PUT Request Initiated .....");
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam(pathParamName, pathParamData)
                .body(payload)
                .when()
                .put(URI);
        System.out.println("URL:" + URI.replace("{" + pathParamName + "}", pathParamData));
        List<Object> obj = new ArrayList<>();
        obj.add(payload);
        System.out.println("Request Body:" + CommonUtils.convertPojoToJson(obj));
        System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
        response.then().log().all();

        return response;
    }


}
