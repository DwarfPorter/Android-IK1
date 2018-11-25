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

    public static InfoFragment newInstance(Parcel parcel) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_info, container, false);
        Parcel parcel = (Parcel)getArguments().getSerializable(ARG_PARCEL);
        TextView city = layout.findViewById(R.id.cityInfo);
        city.setText(parcel.getCityName());
        TextView viewTemp = layout.findViewById(R.id.viewTemp);
        viewTemp.setText(Integer.toString(parcel.getTemperature()));
        TextView viewPress = layout.findViewById(R.id.viewPress);
        viewPress.setText(Integer.toString(parcel.getPressure()));
        TextView viewHum = layout.findViewById(R.id.viewHum);
        viewHum.setText(Integer.toString(parcel.getHumidity()));
        Button back = layout.findViewById(R.id.btnBack);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getActivity().
                        getSupportFragmentManager();
                fragmentManager.popBackStack();
            }
        });
        return layout;
    }
}
