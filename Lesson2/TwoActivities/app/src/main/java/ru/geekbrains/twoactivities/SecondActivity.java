package ru.geekbrains.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        CharSequence strData = intent.getCharSequenceExtra(getString(R.string.text));
        TextView textView = findViewById(R.id.textView2);
        textView.setText(strData);
    }
}
