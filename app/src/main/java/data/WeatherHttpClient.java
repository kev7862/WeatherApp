package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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

            // Reading the Response that we are getting from the URL.
            // We're Creating a bucket where we'll put all our data that we're getting from the Internet.
            //BufferedReader is the only Object that can read this input string we're getting from the internet.
            StringBuffer stringBuffer = new StringBuffer();
            inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = null;

            // BufferReader is trying to read each data line by line.
            while ((line = bufferedReader.readLine()) !=null) {
                stringBuffer.append(line + "\r\n");

                        inputStream.close();
                connection.disconnect();
                return stringBuffer.toString();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
