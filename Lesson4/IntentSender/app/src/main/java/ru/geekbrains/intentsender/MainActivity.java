package ru.geekbrains.intentsender;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button intentBtn = findViewById(R.id.button);
        intentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("ru.geekbrains.intentobserver.MAIN");
                Intent chooser = Intent.createChooser(intent, "Выбор приложения");
                if (intent.resolveActivity(getPackageManager()) != null){
                    startActivity(chooser);
                }
            }
        });
    }
}
