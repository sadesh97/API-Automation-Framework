package api.endpoints;

/*
 *1/1/2024 created by Sadesh Manaranju
 */
public class Routes {

    public static String base_Url = "https://petstore.swagger.io/v2";

    //User Model
    //https://petstore.swagger.io/v2/user

    public static String createUser = base_Url + "/user";
    public static String getUser = base_Url + "/user/{userName}";
    public static String updateUser = base_Url + "/user/{userName}";
    public static String deleteUser = base_Url + "/user/{userName}";


}
