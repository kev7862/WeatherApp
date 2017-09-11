package data;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import Util.Utils;

/**
 * Created by matite on 9/11/17.
 */

// This is the Heart of Application,because we're parsing/getting the JSONObject here.
public class WeatherHttpClient {

    public String getWeatherData(String place) {
        HttpURLConnection connection = null;
        InputStream inputStream = null;

        // We're parsing the BASE_URL that we created in Utils class.
        try {
            connection = (HttpURLConnection) (new URL(Utils.BASE_URL + place)).openConnection();
            connection.setRequestMethod("GET");
            connection.setDoInput(true);
            connection.setDoInput(true);
            connection.connect();
        }
    }

}
