package ru.geekbrains.changeorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;    // Счетчик
    private TextView textCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textCounter = (TextView) findViewById(R.id.textCounter);    // Поле
        textCounter.setText(((Integer)counter).toString());         // Выводим счетчик в поле
        Button button = (Button) findViewById(R.id.button);         // Кнопка
        button.setOnClickListener(new View.OnClickListener() {      // Обработка нажатий
            @Override
            public void onClick(View v) {
                counter++;
                textCounter.setText(((Integer)counter).toString());
            }
        });
    }
}
