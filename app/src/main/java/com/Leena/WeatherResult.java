package com.Leena;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WeatherResult extends AppCompatActivity {



ImageView WeatherImageValue;
TextView RcityName,description,temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_result);
        WeatherImageValue = (ImageView) findViewById(R.id.weatherImage);
        RcityName = (TextView) findViewById(R.id.RcityName);
        description = (TextView) findViewById(R.id.iddescription);
        temp = (TextView) findViewById(R.id.idtemp) ;

        RcityName.setText(WeatherController.mCityName);
        description.setText(WeatherController.mDescription);
        int roundedValue = (int) Math.rint(WeatherController.mTemp);

        temp.setText("Temperature :- "+roundedValue);
        int getImageName = updateWeatherIcon(WeatherController.mCondition);

    WeatherImageValue.setImageResource(getImageName);


    }

    // Get the weather image name from OpenWeatherMap's condition (marked by a number code)
    private static int updateWeatherIcon(int condition) {


         if (condition == 800) {

            return  R.drawable.sunny;

        } else if (condition >= 801 && condition <= 804) {
            return R.drawable.winter;

        }

        return R.drawable.none;
    }
}