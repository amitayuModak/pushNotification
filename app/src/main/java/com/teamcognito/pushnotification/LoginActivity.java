package com.teamcognito.pushnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.teamcognito.pushnotification.APIInterface.ApiInterface;
import com.teamcognito.pushnotification.APIInterface.ApiResponse;

import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements ApiResponse {

    EditText id,password;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        id=findViewById(R.id.id);
        password=findViewById(R.id.password);
        login=findViewById(R.id.login);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginApi();
            }
        });
    }

    public void loginApi()
    {
        //pass parrmeter here
        Intent intent=new Intent(LoginActivity.this,MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onResponse(Response arg0, String key) {
        switch (key)
        {
                case "":
                //get response here
                break;
        }
    }

    @Override
    public void onError(Throwable t, String key) {

    }
}