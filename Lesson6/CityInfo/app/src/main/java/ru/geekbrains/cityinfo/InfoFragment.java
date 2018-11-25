package ru.geekbrains.cityinfo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link InfoFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class InfoFragment extends Fragment implements Constants {

    private int index;

    public InfoFragment() {
        // Required empty public constructor
    }

    public static InfoFragment newInstance(int index) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            index = getArguments().getInt(ARG_INDEX, 0);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView city = getActivity().findViewById(R.id.cityInfo);
        if (city == null) return;
        String[] names = getResources().getStringArray(R.array.Cities);
        city.setText(names[index]);

        Random rnd = new Random();
        TextView viewTemp = getActivity().findViewById(R.id.viewTemp);
        int rndTemp = rnd.nextInt(40);
        viewTemp.setText(Integer.toString(rndTemp));
        TextView viewPress = getActivity().findViewById(R.id.viewPress);
        int rndPress = rnd.nextInt(50) + 720;
        viewPress.setText(Integer.toString(rndPress));
        TextView viewHum = getActivity().findViewById(R.id.viewHum);
        int rndHum = rnd.nextInt(100);
        viewHum.setText(Integer.toString(rndHum));

        Button back = getActivity().findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().
                        getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
    }
}
