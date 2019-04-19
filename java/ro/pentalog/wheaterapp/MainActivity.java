package ro.pentalog.wheaterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    protected TextView tvGoToWeatherInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvGoToWeatherInfo = findViewById(R.id.tvgoToWheterLogin);

        tvGoToWeatherInfo.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == tvGoToWeatherInfo.getId()){
            startActivity(new Intent(this, Login.class));
        }
    }
}
