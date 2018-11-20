package ru.geekbrains.cityinfo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class CoatofarmsActivity extends AppCompatActivity implements Constants {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            // Если устройство перевернули в альбомную ориентацию, то надо это активити закрыть
            finish();
            return;
        }

        if (savedInstanceState == null) {
            // Если это активити запускается первый раз (с каждым новым гербом первый раз)
            // то перенаправим параметр фрагменту
            Bundle bundleArg = getIntent().getExtras();
            int index = bundleArg.getInt(ARG_INDEX, 0);
            CoatofarmsFragment details = CoatofarmsFragment.newInstance(index);
            // Добавим фрагмент на активити
            getSupportFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }

    }
}
