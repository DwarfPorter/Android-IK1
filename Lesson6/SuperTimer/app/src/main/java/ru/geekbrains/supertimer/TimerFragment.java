package ru.geekbrains.supertimer;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimerFragment extends Fragment implements Observer {

    private TextView textHour;
    private TextView textMinute;
    private TextView textSecond;
    private TextView textDecSecond;

    public TimerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setRetainInstance(true);
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_timer, container, false);
        textHour = layout.findViewById(R.id.textHour);
        textMinute = layout.findViewById(R.id.textMinute);
        textSecond = layout.findViewById(R.id.textSecond);
        textDecSecond = layout.findViewById(R.id.textDecSecond);
        return layout;
    }

    @Override
    public void updateTimer(long hour, long minute, long second, long decsecond) {
        textHour.setText(String.format("%02d", hour));
        textMinute.setText(String.format("%02d", minute));
        textSecond.setText(String.format("%02d", second));
        textDecSecond.setText(String.format("%01d", decsecond));
    }
}
