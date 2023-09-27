package com.featzsoft.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    //  Button login;
    ImageView imgv;
    TextView login,new_usr;
    EditText login_name, login_pass;
    LinearLayout linearLayout;

    //  Animation topAnimantion,bottomAnimation,middleAnimation;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        SharedPreferences shp;
        SharedPreferences.Editor shpEditor;

        linearLayout = findViewById(R.id.linear);

        String lo_user, lo_pass;

         login = findViewById(R.id.login);
         new_usr = findViewById(R.id.newacc);
        login_name = (EditText) findViewById(R.id.login_user);
        login_pass = (EditText) findViewById(R.id.login_pass);

        login_name.setText("");
        shp = getSharedPreferences("myPreferences", MODE_PRIVATE);

        SharedPreferences preferences = getSharedPreferences("login", Context.MODE_PRIVATE);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String value = login_name.getText().toString().trim();

                SharedPreferences sharedPref = getSharedPreferences("myKey", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putString("value", value);
                editor.apply();

                Intent i = new Intent(Login.this, MainActivity.class);
                startActivity(i);
            }
        });
        new_usr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Login.this, SignUp.class);
                startActivity(i);
            }
        });
    }



}












