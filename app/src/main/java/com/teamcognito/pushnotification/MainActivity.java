package com.teamcognito.pushnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.teamcognito.pushnotification.APIInterface.ApiClient;
import com.teamcognito.pushnotification.APIInterface.ApiResponse;
import com.teamcognito.pushnotification.APIInterface.ApiService;
import com.teamcognito.pushnotification.model.UpdateFBTokenParameter;

import okhttp3.ResponseBody;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements ApiResponse {

    TextView userName;
    String refreshedToken="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=(TextView)findViewById(R.id.userName);

        refreshedToken = FirebaseInstanceId.getInstance().getToken();
        Log.d("fb_token", "Refreshed token: " + refreshedToken);

        updateFirebaseToken();
    }

        private void updateFirebaseToken() {
        ApiService<ResponseBody> service = new ApiService<>();
        UpdateFBTokenParameter updateFBTokenParameter=new UpdateFBTokenParameter();
        updateFBTokenParameter.setName("");
        updateFBTokenParameter.setActive(false);
        updateFBTokenParameter.setDeviceId(refreshedToken);
        updateFBTokenParameter.setRegistrationId("");
        updateFBTokenParameter.setType("null");
        updateFBTokenParameter.setUser("null");
        service.get( this, ApiClient.getApiInterface().update(updateFBTokenParameter), "tokenUpdate");
        Log.e("DATALOG","check1=> "+updateFBTokenParameter);

    }


    @Override
    public void onResponse(Response response, String key) {
        switch (key)
        {
            case "tokenUpdate":
           try {
            Log.d("DATALOG",response.body().toString());
            ResponseBody passwordResponse = (ResponseBody) response.body();

              }
                catch(Exception e) {
            e.printStackTrace();
        }
        break;

        }
    }

    @Override
    public void onError(Throwable t, String key) {

    }
}