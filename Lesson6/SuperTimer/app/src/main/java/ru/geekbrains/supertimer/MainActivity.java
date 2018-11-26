package ru.geekbrains.supertimer;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements PublisherGetter {

    private Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();

        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_main);
        if (fragment != null) return;

        MainTimerFragment mainFragment = new MainTimerFragment();
        TimerFragment timerFragment = new TimerFragment();

        publisher.subscribe(timerFragment);

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment_main, mainFragment);
        fragmentTransaction.add(R.id.fragment_timer1, timerFragment);
        fragmentTransaction.commit();
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}
