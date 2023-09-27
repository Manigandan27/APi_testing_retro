package com.featzsoft.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SignUp extends AppCompatActivity {

     TextView signup1;
     EditText nameEdt, emailEdt;
     TextView responseTV;
     ProgressBar loadingPB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        nameEdt = findViewById(R.id.idEdtName);//user name
        emailEdt = findViewById(R.id.idEdtJob);//password
        signup1 =  findViewById(R.id.signup);//signin button

        responseTV = findViewById(R.id.idTVResponse);
        loadingPB = findViewById(R.id.idLoadingPB);

        signup1 =  findViewById(R.id.signup);
        signup1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                //                Toast.makeText(getBaseContext(), "Sign-Up Successful" , Toast.LENGTH_SHORT ).show();
//                Intent i = new Intent(SignUp.this, Login.class);
//                startActivity(i);
//
//            }
//        });

                if (nameEdt.getText().toString().isEmpty() && emailEdt.getText().toString().isEmpty()) {
                    Toast.makeText(SignUp.this, "Please enter both the values", Toast.LENGTH_SHORT).show();
                    return;
                }
                postData(nameEdt.getText().toString(), emailEdt.getText().toString());
            }
        });

    }

        private void postData(String name, String email) {

            loadingPB.setVisibility(View.VISIBLE);
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://reqres.in/api/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            
            RetrofitApi retrofitAPI = retrofit.create(RetrofitApi.class);
            ModelClass modal = new ModelClass(name, email);

            Call<ModelClass> call = retrofitAPI.createPost(modal);
            call.enqueue(new Callback<ModelClass>() {
                @Override
                public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                    Toast.makeText(SignUp.this, "Data added to API", Toast.LENGTH_SHORT).show();

                    loadingPB.setVisibility(View.GONE);
                    emailEdt.setText("");
                    nameEdt.setText("");
                    
                    ModelClass responseFromAPI = response.body();
                    String responseString = "Response Code : " + response.code() + "\nName : " + responseFromAPI.getName() + "\n" + "Job : " + responseFromAPI.getEmail();
                    responseTV.setText(responseString);
                }

                @Override
                public void onFailure(Call<ModelClass> call, Throwable t) {
                    responseTV.setText("Error found is : " + t.getMessage());
                }
            });
        }
    }




