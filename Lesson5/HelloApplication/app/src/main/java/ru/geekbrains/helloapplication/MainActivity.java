package ru.geekbrains.helloapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Hello";
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "onCreate: Step1");
        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        Log.d(TAG, "onCreate: currentHour = " + currentHour );
        TextView greeting = findViewById(R.id.txtGreeting);
        Log.d(TAG, "onCreate: greeting.getText() = " + greeting.getText());
        if (currentHour >= 12 && currentHour <= 15){
            Log.d(TAG, "onCreate: greeting.setText(\"Good afternoon\")");
            greeting.setText("Good afternoon");
        }
        else if (currentHour >= 16 && currentHour <= 24){
            Log.d(TAG, "onCreate: greeting.setText(\"Good evening\")");
            greeting.setText("Good evening");
        }
    }
}
