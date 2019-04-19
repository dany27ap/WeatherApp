package ro.pentalog.wheaterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherActivity extends AppCompatActivity {

    TextView tvCountryName;
    TextView tvResult;
    Button btSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
    }

    public void search(View view){

        tvCountryName = findViewById(R.id.edCountryName);
        tvResult = findViewById(R.id.result);
        btSubmit = findViewById(R.id.btSubmit);


        String cName = tvCountryName.getText().toString();

        String content;
        Weather weather = new Weather();
        try{
            content = weather.execute("http://openweathermap.org/data/2.5/weather?q=" + cName + "&appid=b6907d289e10d714a6e88b30761fae22").get();

            JSONObject jsonObject = new JSONObject(content);
            String weatherInfo = jsonObject.getString("weather");
            String mainTemperature = jsonObject.getString("main");

            JSONArray array = new JSONArray(weatherInfo);

            String main = "";
            String description = "";


            for (int i = 0; i < array.length(); i++) {
                JSONObject weatherPart = array.getJSONObject(i);
                main = weatherPart.getString("main");
                description = weatherPart.getString("description");
            }

            JSONObject mainPart = new JSONObject(mainTemperature);
            String temp = mainPart.getString("temp");
            String pressure = mainPart.getString("pressure");
            String humidity = mainPart.getString("humidity");

            String resultMeteo = "Main : " + main + "\nDescription : " + description + "\nTemp : " + temp + " grade" + "\nPressure : " + pressure + " Pa" + "\nHumidity : " + humidity;


            tvResult.setText(resultMeteo);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
