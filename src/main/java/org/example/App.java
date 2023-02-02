package org.example;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.hc.core5.net.URIBuilder;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpResponse;
public class App {

        private final static String API_URL = "https://api.spoonacular.com/recipes/4632/summary";

        public static void main(String[] args)  {
        URIBuilder uriBuilder = null;
        try {
            uriBuilder = new URIBuilder(API_URL);
            uriBuilder.addParameter("id", "4632");
            uriBuilder.addParameter("apiKey", "79fc9458e5084b30b1a87b77899253e1");
            URI uri = uriBuilder.build();
            HttpResponse<String> response = HTTPHelper.sendGet(uri);
            if (response != null) {
                System.out.println(response.body());
                FoodInfo FInfo = parsefoodResponse(response.body(), FoodInfo.class);
                System.out.println(FInfo);
            }

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

        public static FoodInfo parsefoodResponse(String responseString, Class<?> elementClass){
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            JsonNode  FoodInfoNode = objectMapper.readTree(responseString);
            FoodInfo FInfo = new FoodInfo();
            String FoodID= String.valueOf(FoodInfoNode.get("FoodID"));

            FInfo.setFoodID(FoodID);
            return FInfo;
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }
    }

