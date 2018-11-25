package ru.geekbrains.cityinfo;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoatofarmsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoatofarmsFragment extends Fragment implements Constants {

    public CoatofarmsFragment() {
        // Required empty public constructor
    }

    public static CoatofarmsFragment newInstance(Parcel parcel) {
        CoatofarmsFragment fragment = new CoatofarmsFragment();
        Bundle args = new Bundle();
        args.putSerializable(ARG_PARCEL, parcel);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_coatofarms, container, false);
        Parcel parcel = (Parcel)getArguments().getSerializable(ARG_PARCEL);
        ImageView coatOfArms = layout.findViewById(R.id.imageView);
        // получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        TextView city = layout.findViewById(R.id.textView);
        city.setText(parcel.getCityName());
        Button info = layout.findViewById(R.id.button);
        info.setOnClickListener(infoListener);
        return layout;
    }

    View.OnClickListener infoListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fragmentManager = getActivity().
                    getSupportFragmentManager();
            FragmentTransaction ft = fragmentManager.beginTransaction();
            Parcel parcel = (Parcel)getArguments().getSerializable(ARG_PARCEL);
            InfoFragment info = InfoFragment.newInstance(parcel);
            int idForReplace = android.R.id.content;
            View view = getActivity().findViewById(R.id.coat_of_arms);
            if (view != null){
                idForReplace = R.id.coat_of_arms;
            }
            ft.addToBackStack("");
            ft.replace(idForReplace, info);  // замена фрагмента
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }
    };

}
