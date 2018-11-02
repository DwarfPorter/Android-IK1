package ru.geekbrains.changeorientation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textCounter = (TextView) findViewById(R.id.textCounter);     // Текст
        final MainPresenter presenter = MainPresenter.getInstance();      // Получить презеентер
        textCounter.setText(((Integer)presenter.getCounter()).toString());          // Выводим счетчик в поле
        Button button = (Button) findViewById(R.id.button);         // Кнопка
        button.setOnClickListener(new View.OnClickListener() {      // Обработка нажатий
            @Override
            public void onClick(View v) {
                presenter.incrementCounter();   // Увеличиваем счетчик на единицу
                textCounter.setText(((Integer)presenter.getCounter()).toString());  // Выводим счетчик в поле
            }
        });
    }
}
