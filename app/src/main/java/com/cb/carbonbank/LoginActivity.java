package com.cb.carbonbank;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private Button btnSignIn;
    private ImageView imageViewLogo;
    private TextView textViewCreateAcc;
    long animateDuration = 4000; //milliseconds
    long animateLogoDuration = 2000;
    private int countForLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
        imageViewLogo = findViewById(R.id.imgLogo);
        textViewCreateAcc = findViewById(R.id.textView);

        countForLogo = 1;

        btnSignIn = findViewById(R.id.btnSignIn);


        //Animation for Logo
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewLogo,View.ALPHA,0.0f,1.0f);
        animator.setDuration(animateDuration);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(animator);
        animatorSet.start();

    }

    public void logoAnimate(View view){
        //Animation for Logo
        countForLogo++;
        if(countForLogo %2 ==0){
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewLogo,"rotation",0f,360f);
            animator.setDuration(animateLogoDuration);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(animator);
            animatorSet.start();
        }else{
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViewLogo,"rotation",360f,0f);
            animator.setDuration(animateLogoDuration);

            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.play(animator);
            animatorSet.start();
        }

    }

    public void toCreateAccount(View view){
        Intent intent = new Intent(this,RegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void toCreateCompanyAccount(View view){
        Intent intent = new Intent(this,CompanyRegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }


    private boolean validateUser(){

        String usernameInput = null;
        if(textInputUsername.getEditText().getText().toString().trim() != null){
            usernameInput = textInputUsername.getEditText().getText().toString().trim();
        }

        if(usernameInput.isEmpty()){
            textInputUsername.setError("Username can't be empty");
            return false;
        }else if(!usernameInput.equals("chunbird")){
            textInputUsername.setError("Invalid Username");
            return false;
        }else{
            textInputUsername.setError(null);
            textInputUsername.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword(){

        String passwordInput = null;
        if(textInputPassword.getEditText().getText().toString().trim() != null){
            passwordInput = textInputPassword.getEditText().getText().toString().trim();
        }

        if(passwordInput.isEmpty()){
            textInputPassword.setError("Password can't be empty");
            return false;
        }else if(!passwordInput.equals("123qwe")){
            textInputPassword.setError("Invalid Password");
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
