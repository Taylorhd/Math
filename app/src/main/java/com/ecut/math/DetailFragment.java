package com.ecut.math;


import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.ecut.math.databinding.FragmentDetailBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {
    FragmentDetailBinding binding;
    MyViewModel myViewModel;
    LiveData<String> textQus ;
    TextView textView ;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

    private static final String TAG = "DetailFragment";

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        textView = getActivity().findViewById(R.id.textView2);

        myViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail, container, false);
        binding.setData(myViewModel);
        myViewModel.innit();
        textQus = myViewModel.getShowText();
//        textQus.observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(String s) {
//                textView.setText(s);
//
//            }
//        });
        // Inflate the layout for this fragment
        return binding.getRoot();
    }

}
