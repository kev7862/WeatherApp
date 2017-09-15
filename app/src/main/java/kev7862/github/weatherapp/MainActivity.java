package kev7862.github.weatherapp;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

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
