package ru.geekbrains.cityinfo;


import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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
        View layout = inflater.inflate(R.layout.fragment_coatofarms, container, false);
        return layout;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // определить какой герб надо показать, и показать его
        ImageView coatOfArms = getActivity().findViewById(R.id.imageView);
        if (coatOfArms == null) return;
        // получить из ресурсов массив указателей на изображения гербов
        TypedArray imgs = getResources().obtainTypedArray(R.array.coatofarms_imgs);
        // выбрать по индексу подходящий
        coatOfArms.setImageResource(imgs.getResourceId(index, -1));
        TextView city = getActivity().findViewById(R.id.textView);
        String[] names = getResources().getStringArray(R.array.Cities);
        city.setText(names[index]);
    }

}
