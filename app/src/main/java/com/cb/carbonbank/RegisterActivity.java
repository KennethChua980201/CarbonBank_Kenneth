package com.cb.carbonbank;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

public class RegisterActivity extends AppCompatActivity {

    private TextInputLayout textInputUsername;
    private TextInputLayout textInputPassword;
    private TextInputLayout textInputConfirmPassword;
    private TextInputLayout textInputEmail;
    private Button btnSignUp;
    private ImageView imageViewProfilePic;
    private TextView textForCompany;
    private Uri filePath;

    private static final int IMG_REQUEST = 3;
    private static final int STORAGE_PERMISSION_CODE = 123;
    private Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        textInputUsername = findViewById(R.id.text_input_username);
        textInputPassword = findViewById(R.id.text_input_password);
        textInputConfirmPassword = findViewById(R.id.text_input_confirm_password);
        textInputEmail = findViewById(R.id.text_input_email);
        btnSignUp = findViewById(R.id.btn_signUp);

    }

    private void browseImage(View view){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Complete action using"),IMG_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode == IMG_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null){
            filePath = data.getData();
            try{
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(),filePath);
                imageViewProfilePic.setImageBitmap(bitmap);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @Override
    public void finish(){
        super.finish();
        overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    public void permitCreateAcc(View view){
        if(!validateUser() | !validatePassword() | !validateEmail()){
            return;
        }

        String result = "Success";
        Toast.makeText(this,result,Toast.LENGTH_SHORT).show();
    }

    private boolean validateUser(){
        String usernameInput = null;
        if(textInputUsername.getEditText().getText().toString().trim() != null){
            usernameInput = textInputUsername.getEditText().getText().toString().trim();
        }

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

        boolean passwordAccept = false;
        boolean cPasswordAccept = false;
        String passwordInput = null;
        String cPasswordInput = null;

        if(textInputPassword.getEditText().getText().toString().trim() != null){
            passwordInput = textInputPassword.getEditText().getText().toString().trim();

            if(passwordInput.isEmpty()){
                textInputPassword.setError("Password can't be empty");
                passwordAccept = false;
            }else{
                textInputPassword.setError(null);
                textInputPassword.setErrorEnabled(false);
                passwordAccept = true;
            }
        }

        if(textInputConfirmPassword.getEditText().getText().toString().trim() != null){
            cPasswordInput = textInputConfirmPassword.getEditText().getText().toString().trim();
            if(cPasswordInput.isEmpty()){
                textInputConfirmPassword.setError("Confirm Password can't be empty");
                cPasswordAccept = false;
            }else{
                textInputConfirmPassword.setError(null);
                textInputConfirmPassword.setErrorEnabled(false);
                cPasswordAccept = true;
            }
        }

        if(passwordAccept && cPasswordAccept){
            if(passwordInput.equals(cPasswordInput)){
                return true;
            }else {
                textInputConfirmPassword.setError("Confirm Password is invalid. Not Equal");
                return false;
            }
        }else{
            return  false;
        }

    }

    private boolean validateEmail(){
        String emailInput = null;

        if(textInputEmail.getEditText().getText().toString().trim() != null){
            emailInput = textInputEmail.getEditText().getText().toString().trim();
        }

        if(emailInput.isEmpty()){
            textInputEmail.setError("Email can't be empty");
            return false;
        }else if(!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()){
            textInputEmail.setError("Invalid Email Format");
            return false;
        }else{
            textInputEmail.setError(null);
            textInputEmail.setErrorEnabled(false);
            return true;
        }
    }

    public void forCompanyReg(View view){
        Intent intent = new Intent(this,CompanyRegisterActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }
}
