package com.featzsoft.project2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import static javax.xml.transform.OutputKeys.VERSION;

public class Splash extends AppCompatActivity {

   // Animation topAnimantion,bottomAnimation,middleAnimation;
    TextView version;
    ImageView imgv;
    TextView t1,t2,t3,t4;
    DevicePolicyManager devicePolicyManager;

    Boolean isInternetPresent = false;

   // ComponentName deviceAdmin;
    ConnectionDetector cd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);

        // getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Handler handler;

        devicePolicyManager = (DevicePolicyManager) getSystemService(Context.DEVICE_POLICY_SERVICE);

        imgv=findViewById(R.id.imgvie);
        t1=findViewById(R.id.title1);
        t2=findViewById(R.id.title2);
      //  t3=findViewById(R.id.webadrs);
        t4=findViewById(R.id.link);
        version = findViewById(R.id.version);

       // topAnimantion = AnimationUtils.loadAnimation(this, R.anim.top_animation);
      //  bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation);
       // middleAnimation = AnimationUtils.loadAnimation(this, R.anim.middle_animation);

       // imgv.setAnimation(middleAnimation);
      //  t1.setAnimation(topAnimantion);
      //  t2.setAnimation(topAnimantion);
      //  t3.setAnimation(bottomAnimation);
      //  t4.setAnimation(bottomAnimation);


        if (Build.VERSION.SDK_INT >= 23) {

            // if (ActivityCompat.checkSelfPermission(Splash.this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            //    ActivityCompat.requestPermissions(Splash.this, new String[]{Manifest.permission.READ_PHONE_STATE}, IMEIrequest);

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent i = new Intent(Splash.this, Login.class);
                    startActivity(i);
                    finish();
                }
            }, 3000);
           version.setText(" App Version-"+"" + Build.VERSION.SDK_INT); //version.setText("CBMMS V." + VERSION);

        } else
            Toast.makeText(Splash.this, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
        version.setText("App Version-"+"" + Build.VERSION.SDK_INT);//shows version of device
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);

        cd = new ConnectionDetector(getApplicationContext());
        isInternetPresent = cd.isConnectingToInternet();


        if (Build.VERSION.SDK_INT < 23) {

                Intent i = new Intent(Splash.this, Login.class);
                startActivity(i);
                return;
            } else {

                Log.e("permission_not_granted", ", request for permission");
            }
    }
}


