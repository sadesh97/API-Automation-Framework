import api.endpoints.Routes;
import api.payloads.User;
import api.utilities.RequestUtil;
import api.utilities.ResponseUtil;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
public class FirstTest {


    @Test
    public static void testUser() throws InterruptedException {
        SoftAssert softAssert = new SoftAssert();

        User user = new User();
        user.setId(1);
        user.setUsername("sadeshM");
        user.setFirstName("Sade");
        user.setLastName("Mana");

        //create
        Response response = RequestUtil.commonPOSTRequest(user, Routes.createUser);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response), "200", "Invalid response code");

        //read
        Response response1 = RequestUtil.commonGETRequest("userName", user.getUsername(), Routes.getUser);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response1), "200", "Invalid response code");
        softAssert.assertEquals(ResponseUtil.getValueFromResponse(response1, "username"), user.getUsername(), "Invalid UserName");

        //update
        User user1 = new User();
        user1.setFirstName("Oshi");

        Response response2 = RequestUtil.commonPUTRequest("userName", user.getUsername(), user1, Routes.updateUser);
        softAssert.assertEquals(ResponseUtil.getResponseCode(response2), "200", "Invalid response code");


        //delete


        softAssert.assertAll();


    }
}
