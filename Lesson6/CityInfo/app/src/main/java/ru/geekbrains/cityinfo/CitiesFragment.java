package ru.geekbrains.cityinfo;


import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitiesFragment extends ListFragment implements Constants {


    public CitiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        showCoatofarms(position);
    }

    private void showCoatofarms(int currentPosition){
        Intent intent = new Intent();
        intent.setClass(getActivity(), CoatofarmsActivity.class);
        // и передадим туда параметры
        intent.putExtra(ARG_INDEX, currentPosition);
        startActivity(intent);
    }
}
