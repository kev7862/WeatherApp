package data;

import org.json.JSONException;
import org.json.JSONObject;

import model.Weather;

/**
 * Created by matite on 9/12/17.
 */

public class JSONWeatherParser {
    public static Weather getWeather(String data) {

        // We're Creating a JsonObject from data.
        try {
            JSONObject jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
