package ro.pentalog.wheaterapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener{

    protected Button bLogin;
    protected EditText etEmail, etPassword;
    protected TextView tvRegisterLink;
    protected UserLocalStore userLocalStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.edEmail);
        tvRegisterLink = findViewById(R.id.tvRegister);
        etPassword = findViewById(R.id.edPassword);

        bLogin.setOnClickListener(this);
        tvRegisterLink.setOnClickListener(this);

        userLocalStore = new UserLocalStore(this);

    }

    @Override
    public void onClick(View v) {

        if(v.getId() == bLogin.getId()){

            User user = new User(null, null);

            userLocalStore.storeUserData(user);
            userLocalStore.setUserLoggedIn(true);

            startActivity(new Intent(this, WeatherActivity.class));
        }

        if(v.getId() == tvRegisterLink.getId()){
            startActivity(new Intent(this, Register.class));
        }

    }
}
