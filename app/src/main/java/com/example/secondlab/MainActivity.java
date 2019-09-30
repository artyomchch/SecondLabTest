package com.example.secondlab;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "TestTask4.0";
    Button  Activity;
    Button Browser;
    Button ToastTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Activity = findViewById(R.id.activity);
        Activity.setOnClickListener(this);

        Browser = findViewById(R.id.browser);
        Browser.setOnClickListener(this);

        ToastTask = findViewById(R.id.toast);
        ToastTask.setOnClickListener(this);

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
            case R.id.toast:
                   Toast toast = Toast.makeText(getApplicationContext(),"Welcome to MIREA!", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM, 0, 0);
                LinearLayout toastContainer = (LinearLayout) toast.getView();
                ImageView catImageView = new ImageView(getApplicationContext());
                catImageView.setImageResource(R.drawable.ic_launcher_background);
                toastContainer.addView(catImageView, 0);
                toast.show();
            default:
                break;
        }
    }
}
