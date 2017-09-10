package Util;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by matite on 9/10/17.
 */


         // This is api url where all the data we're trying to fetch resides
public class Utils {
    public static final String BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q=";

    // This is where you fetch the icon for the weather.
    public static final String ICON_URL = "http://openweathermap.org/img/w/";

    //Throwing an Exception incase your app Crushes, you're making sure it crushes gracefully
    public static JSONObject getObject(String tagName, JSONObject jsonObject) throws JSONException {
        JSONObject jObj = jsonObject.getJSONObject(tagName);
        return jObj;
    }

    public static String getString(String tagName, JSONObject jsonObject)  throws JSONException {
        return jsonObject.getString(tagName);
    }

    public static float getFloat(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static double getDouble(String tagName, JSONObject jsonObject) throws JSONException {
        return (float) jsonObject.getDouble(tagName);
    }

    public static int getInt(String tagName, JSONObject jsonObject) throws JSONException {
        return (int) jsonObject.getInt(tagName);
    }
}
