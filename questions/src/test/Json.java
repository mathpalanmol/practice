package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;
 
 
public class Json {
 
    public static void main(String a[]){
         
        ObjectMapper mapperObj = new ObjectMapper();
        Map<String, String> inputMap = new HashMap<String, String>();
        inputMap.put("gCount", "20");
        inputMap.put("amount", "30000");
        // convert map to JSON String
        try {
            String jsonResp = mapperObj.writeValueAsString(inputMap);
            //jsonResp will be saved to cache
            System.out.println(jsonResp);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}