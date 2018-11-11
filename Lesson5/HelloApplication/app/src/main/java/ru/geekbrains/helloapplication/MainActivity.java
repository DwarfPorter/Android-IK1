package ru.geekbrains.helloapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int currentHour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
        TextView greeting = findViewById(R.id.txtGreeting);
        if (currentHour >= 12 && currentHour <= 15){
            greeting.setText("Good afternoon");
        }

    }
}
