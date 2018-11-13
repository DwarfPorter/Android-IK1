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

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        Log.d(TAG, "MainActivity.onCreate: currentHour = " + currentHour );
        Greeting hello = new Greeting(currentHour);
        String strGeeting = hello.get();
        TextView greeting = findViewById(R.id.txtGreeting);
        Log.d(TAG, "MainActivity.onCreate: greeting.getText() = " + greeting.getText());
        greeting.setText(strGeeting);
    }
}
