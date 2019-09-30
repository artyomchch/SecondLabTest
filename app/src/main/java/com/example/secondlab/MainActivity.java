package com.example.secondlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TestTask4.0";
    Button  Activity;
    Button Browser;
    Button Toast;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activity = findViewById(R.id.activity);
        Activity.setOnClickListener(this);

        Browser = findViewById(R.id.browser);
        Browser.setOnClickListener(this);


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity:
                Intent intent = new Intent(this, ActivityTwo.class);
                startActivity(intent);
                break;
            case R.id.browser:
                Intent sec = new Intent(this, BrowserActivity.class);
                startActivity(sec);
                break;
            default:
                break;
        }
    }
}
