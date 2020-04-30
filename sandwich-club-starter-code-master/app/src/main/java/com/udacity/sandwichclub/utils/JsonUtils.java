package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    public static Sandwich parseSandwichJson(String json) {
        Sandwich sandwich = null;

        JSONObject jsonObject;
        try {
            jsonObject = new JSONObject(json);
            JSONObject name = jsonObject.getJSONObject("name");

            String mainName = name.getString("mainName");
            JSONArray alsoKnownAs = name.getJSONArray("alsoKnownAs");
            String placeOfOrigin = jsonObject.getString("placeOfOrigin");
            String description = jsonObject.getString("description");
            String image = jsonObject.getString("image");
            JSONArray ingredients = jsonObject.getJSONArray("ingredients");

            List<String> aka = new ArrayList<>();
            List<String> ing = new ArrayList<>();

            for (int i = 0; i < alsoKnownAs.length(); i++) {
                aka.add(alsoKnownAs.getString(i));
            }

            for (int i = 0; i < ingredients.length(); i++) {
                ing.add(ingredients.getString(i));
            }

            sandwich = new Sandwich(
                    mainName,
                    aka,
                    placeOfOrigin,
                    description,
                    image,
                    ing
            );

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return sandwich;
    }
}