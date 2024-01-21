package api.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

/*
 *1/2/2024 created by Sadesh Manaranju
 */
public class CommonUtils {

    public static String convertPojoToJson(List arr) {

        String jsonArray = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // Convert the list of objects to a JSON array
            jsonArray = objectMapper.writeValueAsString(arr);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return jsonArray;
    }
}
