package com.example.aeonz.simpledialog;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Build;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.nio.channels.Channel;

public class MainActivity extends AppCompatActivity {
public static final String ChannelID = "simpleChannel";
private  NotificationManagerCompat notificationManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel1 = new NotificationChannel(ChannelID, "Simple_Notification", NotificationManager.IMPORTANCE_DEFAULT);
            channel1.setDescription("Simple notification description");
            channel1.canShowBadge();
            channel1.setShowBadge(true);

            NotificationManager NM = getSystemService(NotificationManager.class);
            NM.createNotificationChannel(channel1);
        }

        notificationManager = NotificationManagerCompat.from(this);

      /*  Button dialogButton = (Button) findViewById(R.id.btnDialog);
        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            openDialog();
          //  NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
         //   nm.notify();


            }
        });*/
    }

    void openDialog() {
        simpleDialog simpleDialog = new simpleDialog();
        simpleDialog.show(getSupportFragmentManager() , "Simple Dialog");
    }

    void openCustom(){
        CustomDialog customDialog = new CustomDialog();
        customDialog.show(getSupportFragmentManager() , "Custom Dialog");
    }

    public void btnNotification(View view){
        Notification notification = new NotificationCompat.Builder(this, ChannelID)
                .setTicker("Testing Simple notification")
                .setSmallIcon(android.R.drawable.ic_menu_report_image)
                .setContentText("Testing simple notification")
                .setContentTitle("Simple Notification")
                .setAutoCancel(true)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .build();
                notificationManager.notify(1 , notification);
                openDialog();
    }

    public void  btnCustom (View view){
        openCustom();
    }

}
