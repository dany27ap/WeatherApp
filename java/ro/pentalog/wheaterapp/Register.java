package ro.pentalog.wheaterapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity implements View.OnClickListener{

    protected EditText etName, etCountry, etEmail, etPassword, etConfirmPassword;
    protected Button bRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        etName = findViewById(R.id.edName);
        etCountry = findViewById(R.id.edCountry);
        etEmail = findViewById(R.id.edEmailReg);
        etPassword = findViewById(R.id.edPasswordSet);
        etConfirmPassword = findViewById(R.id.edPasswordConfirmation);
        bRegister = findViewById(R.id.btnRegister);

        bRegister.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v.getId() == bRegister.getId()){

            String name = etName.getText().toString();
            String country = etCountry.getText().toString();
            String email = etEmail.getText().toString();
            String password = etPassword.getText().toString();
            String passwordConfirm = etConfirmPassword.getText().toString();

            if(!password.equals(passwordConfirm)){
                Toast.makeText(Register.this,"Password Not matching", Toast.LENGTH_SHORT).show();
            }


            User user = new User(name, country, email, password);

        }
    }
}
