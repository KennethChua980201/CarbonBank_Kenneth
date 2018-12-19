package com.cb.carbonbank;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
        btnSignIn = findViewById(R.id.btnSignIn);
    }

    private boolean validateUser(){
        String usernameInput = textInputUsername.getEditText().getText().toString().trim();

        if(usernameInput.isEmpty()){
            textInputUsername.setError("Username can't be empty");
            return false;
        }else{
            textInputUsername.setError(null);
            textInputUsername.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){
        String passwordInput = textInputPassword.getEditText().getText().toString().trim();

        if(passwordInput.isEmpty()){
            textInputPassword.setError("Password can't be empty");
            return false;
        }else{
            textInputPassword.setError(null);
            textInputPassword.setErrorEnabled(false);
            return true;
        }
    }

    public void confirmInput(View view){
        if(!validateUser() | !validatePassword()){
            return;
        }
        String result = "Success";

        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }
}
