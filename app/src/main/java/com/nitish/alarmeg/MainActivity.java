package com.nitish.alarmeg;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button) findViewById(R.id.button1);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //start one alarm for next 10seccods
                AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

                //that alarm should start broadcast receiver automatically
                Intent intent = new Intent(MainActivity.this,MyReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,0,intent,0);
                alarmManager.set(AlarmManager.RTC_WAKEUP,1000,pendingIntent);

            }
        });
    }
}
