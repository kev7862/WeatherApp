package data;

import org.json.JSONArray;
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
            //Creating a JsonObject called "coordObj" which holds our coordinates data,
            JSONObject coordObj = Utils.getObject("coord", jsonObject);
            place.setLat(Utils.getFloat("lat", coordObj));
            place.setLon(Utils.getFloat("lon", coordObj));

            // get the sys object
            JSONObject sysObj = Utils.getObject("sys", jsonObject);
            place.setCountry(Utils.getString("country", sysObj));
            place.setLastupdate(Utils.getInt("dt", jsonObject));
            place.setSunrise(Utils.getInt("sunrise", sysObj));
            place.setSunset(Utils.getInt("sunset", sysObj));
            place.setCity(Utils.getString("name", jsonObject));

            weather.place = place;

            //get the weather info.
            JSONArray jsonArray = jsonObject.getJSONArray("weather");
            JSONObject jsonWeather = jsonArray.getJSONObject(0);
            weather.currentCondition.setWeatherId(Utils.getInt("id", jsonWeather));
            weather.currentCondition.setDescription(Utils.getString("description", jsonWeather));
            weather.currentCondition.setCondition(Utils.getString("main", jsonWeather));
            weather.currentCondition.setIcon(Utils.getString("icon", jsonWeather));

            //get the wind info.
            JSONObject windObj = Utils.getObject("wind", jsonObject);
            weather.wind.setSpeed(Utils.getFloat("speed", windObj));
            weather.wind.setDeg(Utils.getFloat("deg", windObj));

            JSONObject cloudObj = Utils.getObject("clouds", jsonObject);
            weather.clouds.setPrecipitation(Utils.getInt("all", cloudObj));

            return weather;

            



        } catch (JSONException e) {
            e.printStackTrace();

            return null;
        }
    }
}
