package ru.geekbrains.twoactivities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

        Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult();
            }
        });
    }

    @Override
    public void onBackPressed(){
        returnResult();
    }

    private void returnResult(){
        EditText editText = findViewById(R.id.editText2);
        Intent intent = new Intent();
        intent.putExtra(getString(R.string.result), editText.getText());
        setResult(RESULT_OK, intent);
        finish();
    }
}
