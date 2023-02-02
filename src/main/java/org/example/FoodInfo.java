package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class FoodInfo {
    public String getFoodID(String FoodID) {
        return FoodID;
    }
    public String setFoodID(String FoodID) {
        return FoodID;
    }
    private String FoodID;

    @SuppressWarnings("unchecked")
    @JsonProperty("main")
    private void unpackNested(Map<String,Object> main) {
        this.FoodID = (String) main.get("FoodID");

    }

    @Override
    public String toString() {
        return "FoodInfo" ;
    }
}
