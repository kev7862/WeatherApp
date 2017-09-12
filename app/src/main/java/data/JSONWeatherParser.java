package data;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Objects;

import Util.Utils;
import model.Place;
import model.Weather;

/**
 * Created by matite on 9/12/17.
 */

public class JSONWeatherParser {
    public static Weather getWeather(String data) {
        // Instatiating the Weather Class.
        Weather weather = new Weather();

        // We're Creating a JsonObject from data.
        // Here our JSON object has all our data from the Web
        try {
            JSONObject jsonObject = new JSONObject(data);

        // Creating a Place object where we can put our data
            Place place = new Place();
            //Creating a JsonObject called "coorObj" which holds our coordinates data,
            JSONObject coordObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coordObj));
            place.setLon(Utils.getFloat("lon", coordObj));

            // get the sys object
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            place.setCity(Utils.getString("name", sysObj));

            weather.place = place;

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
