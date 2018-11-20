package ru.geekbrains.cityinfo;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CoatofarmsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CoatofarmsFragment extends Fragment implements Constants {

    private int index;

    public CoatofarmsFragment() {
        // Required empty public constructor
    }

    public static CoatofarmsFragment newInstance(int index) {
        CoatofarmsFragment fragment = new CoatofarmsFragment();
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
// определить какой герб надо показать, и показать его
        ImageView coatOfArms = new ImageView(getActivity());

        // получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(index, -1));
        return coatOfArms; // Вместо макета используем сразу картинку
    }

}
