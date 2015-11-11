package com.njajal.tryretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.njajal.tryretrofit.POJO.Status;

import retrofit.Callback;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.http.Header;

public class MainActivity extends AppCompatActivity {
    String stat, sec;
    String url = "your url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView stat = (TextView) findViewById(R.id.txt_status);
        final TextView sec = (TextView) findViewById(R.id.txt_secure);

        //making object of RestAdapter
        RestAdapter adapter = new RestAdapter.Builder().setEndpoint(url).build();

        //Creating Rest Try
        RestTry restTry = adapter.create(RestTry.class);
        restTry.getStatus(new Callback<Status>() {
            @Override
            public void success(Status status, Response response) {
                stat.setText("Status: " + status.getStatus());
            }

            @Override
            public void failure(RetrofitError error) {
                String merror = error.getMessage();
            }
        });




    }
}
