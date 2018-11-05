package ru.geekbrains.twoactivities;

import android.content.Intent;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final int requestCode = 988;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button secondActivity = findViewById(R.id.button);
        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentSecondActivity = new Intent(getApplicationContext(), SecondActivity.class);
                EditText strData = findViewById(R.id.editText);
                intentSecondActivity.putExtra(getString(R.string.text), strData.getText());
                startActivityForResult(intentSecondActivity, requestCode);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == this.requestCode);
        if (resultCode != RESULT_OK) return;
        if (data == null) return;
        TextView textView = findViewById(R.id.textView);
        textView.setText(data.getCharSequenceExtra(getString(R.string.result)));
    }
}
