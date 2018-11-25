package ru.geekbrains.cityinfo;


import android.support.v4.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class CitiesFragment extends ListFragment implements Constants {

    boolean isExistCoatofarms;  // Можно ли расположить рядом фрагмент с гербом


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

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.coat_of_arms);
        // getActivity - получить контекст активити, где расположен фрагмент
        isExistCoatofarms = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistCoatofarms){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showCoatofarms(constructParcel(0));
        }


    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Parcel parcel = constructParcel(position);
        showCoatofarms(parcel);
    }

    private void showCoatofarms(Parcel parcel){
        if (isExistCoatofarms) {
            // Выделим текущий элемент списка
            getListView().setItemChecked(parcel.getImageIndex(), true);

            FragmentManager fragmentManager = ((AppCompatActivity)getActivity()).
                    getSupportFragmentManager();
            // если есть необходимость, то выведем герб
            // Создаем новый фрагмент, с текущей позицией, для вывода герба
            CoatofarmsFragment detail = CoatofarmsFragment.newInstance(parcel);

            // Выполняем транзакцию по замене фрагмента
            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.replace(R.id.coat_of_arms, detail);  // замена фрашмента
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();

        }
        else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), CoatofarmsActivity.class);
            // и передадим туда параметры
            intent.putExtra(ARG_PARCEL, parcel);
            startActivity(intent);
        }
    }

    private Parcel constructParcel(int position){
        String[] cityNames = getResources().getStringArray(R.array.Cities);
        Random rnd = new Random();
        int rndTemp = rnd.nextInt(40);
        int rndPress = rnd.nextInt(50) + 720;
        int rndHum = rnd.nextInt(100);
        return new Parcel(position, cityNames[position], rndTemp, rndPress , rndHum);
    }
}
