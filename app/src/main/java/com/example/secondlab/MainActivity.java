package com.example.secondlab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
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
    private static final String CHANNEL_ID = "com.mirea.asd.notification.ANDROID";
    private int IDENTIFICATE_MSG = 0;

    Button Activity;
    Button Browser;
    Button ToastTask;
    Button Noti;
    Button Dialog;


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

        Noti = findViewById(R.id.noti);
        Noti.setOnClickListener(this);

        Dialog = findViewById(R.id.dialog);
        Dialog.setOnClickListener(this);


    }

    public void onClickShowDialog(View view) {
        MyAlertDialogFragment dialogFragment = new MyAlertDialogFragment ();
         dialogFragment.show(getSupportFragmentManager(), "dialog");


    }

    public void onOkClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Иду дальше\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onCancelClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"Нет\"!",
                Toast.LENGTH_LONG).show();
    }
    public void onNeutralClicked() {
        Toast.makeText(getApplicationContext(), "Вы выбрали кнопку \"На паузе\"!",
                Toast.LENGTH_LONG).show();
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
                   toast();
            case R.id.noti:
                notification(view);
               break;
            case R.id.dialog:
                onClickShowDialog(view);
                break;
            default:

                break;
        }
    }


    public void toast(){
        Toast toast = Toast.makeText(getApplicationContext(),"Welcome to MIREA!", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM, 0, 0);
        LinearLayout toastContainer = (LinearLayout) toast.getView();
        ImageView catImageView = new ImageView(getApplicationContext());
        catImageView.setImageResource(R.drawable.ic_launcher_background);
        toastContainer.addView(catImageView, 0);
        toast.show();
    }

    public void notification(View view){
        NotificationManager notificationManager =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
// Create PendingIntent
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0, resultIntent,
                PendingIntent.FLAG_UPDATE_CURRENT);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID,
                    "My Notifications", NotificationManager.IMPORTANCE_DEFAULT);
// Configure the notification channel.
            notificationChannel.setDescription("Channel description");
            notificationChannel.enableLights(true);
            notificationChannel.setLightColor(Color.RED);
            notificationChannel.setVibrationPattern(new long[]{0, 1000, 500, 1000});
            notificationChannel.enableVibration(true);
            notificationManager.createNotificationChannel(notificationChannel);
        }
// Create Notification
        NotificationCompat.Builder builder =
                new NotificationCompat.Builder(this, CHANNEL_ID)
                        .setSmallIcon(R.mipmap.ic_launcher)
                        .setContentTitle("There are some notifications")
                        .setContentText("Notification text for MIREA")
                        .setWhen(System.currentTimeMillis())
                        .setProgress(100, 80, false)
                        .setContentIntent(resultPendingIntent);
        Notification notification = builder.build();
// Show Notification
        notificationManager.notify(IDENTIFICATE_MSG++, notification);
    }


}
