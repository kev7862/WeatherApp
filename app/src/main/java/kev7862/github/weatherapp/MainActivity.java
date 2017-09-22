package kev7862.github.weatherapp;

import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import data.JSONWeatherParser;
import data.WeatherHttpClient;
import model.Weather;

public class MainActivity extends AppCompatActivity {

    // Created instant variables from our api to be displayed in the UI
    private TextView cityName;
    private TextView temp;
    private ImageView iconView;
    private TextView description;
    private TextView humidity;
    private TextView pressure;
    private TextView wind;
    private TextView sunrise;
    private TextView sunset;
    private TextView updated;

    Weather weather = new Weather();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Fetching the views by id from the activity_main.xml
        cityName = (TextView) findViewById(R.id.cityText);
        iconView = (ImageView) findViewById(R.id.thumbnailIcon);
        temp = (TextView) findViewById(R.id.tempText);
        description = (TextView) findViewById(R.id.cloudText);
        humidity = (TextView) findViewById(R.id.humidityText);
        pressure = (TextView) findViewById(R.id.pressureText);
        wind = (TextView) findViewById(R.id.windText);
        sunrise = (TextView) findViewById(R.id.riseText);
        sunset = (TextView) findViewById(R.id.setText);
        updated = (TextView) findViewById(R.id.updateText);

        renderWeatherData("Spokane,US");
    }

    //Created a method that is going to fetch all our info from the web.
    public void renderWeatherData ( String city) {
        WeatherTask weatherTask = new WeatherTask();
        weatherTask.execute(new String[] {city + "&units=metric"});

    }
    // Were creating a new class that is going to store all our information that's going to be running on the background,
    // allowing our UI run faster
    private class WeatherTask extends AsyncTask<String, Void, Weather> {
        @Override
        // this is where we populate the data that will then be shown to the user.
        protected void onPostExecute(Weather weather) {
            super.onPostExecute(weather);
        }
        @Override
        protected Weather doInBackground(String... params) {
            String data = ( (new WeatherHttpClient()).getWeatherData(params[0]));
           weather = JSONWeatherParser.getWeather(data);
           Log.v("Data: ", weather.currentCondition.getDescription());

            return weather;
        }
    }

  @Override
    public boolean onCreateOptionsMenu(Menu menu) {
      //inflate the menu: This adds items to the action bar if they are present.
      getMenuInflater().inflate(R.menu.menu_main, menu);
      return true;
  }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //handle action bar item clicks. the action bar will automatically handle clicks on the home up button,
        // so long as you specify a parent activity in the androidManifest.xml

        int id = item.getItemId();

        if (id == R.id.change_city) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
