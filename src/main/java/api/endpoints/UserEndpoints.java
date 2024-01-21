package api.endpoints;

import api.payloads.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
public class UserEndpoints {

    private static final Logger LOGGER = Logger.getLogger(
            Thread.currentThread().getStackTrace()[0].getClassName());

    public static Response creteUser(User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(payload)
                .when()
                .post(Routes.createUser);

        return response;
    }

    public static Response getUser(String userName) {
        Response response = given()
                .pathParam("userName", userName)
                .when()
                .get(Routes.getUser);

        return response;
    }

    public static Response updateUser(String userName, User payload) {
        Response response = given()
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .pathParam("userName", userName)
                .body(payload)
                .when()
                .put(Routes.updateUser);

        return response;
    }

    public static Response deleteUser(String userName) {
        Response response = given()
                .pathParam("userName", userName)
                .when()
                .delete(Routes.deleteUser);

        return response;
    }


}
