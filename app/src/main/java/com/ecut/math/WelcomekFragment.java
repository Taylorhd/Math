package com.ecut.math;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.navigation.Navigation;

import com.ecut.math.databinding.WelcomekFragmentBinding;

public class WelcomekFragment extends Fragment {

    private MyViewModel mViewModel;

    public static WelcomekFragment newInstance() {
        return new WelcomekFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        mViewModel = ViewModelProviders.of(getActivity()).get(MyViewModel.class);
        // TODO: Use the ViewModel
        WelcomekFragmentBinding binding  = DataBindingUtil.inflate(inflater,R.layout.welcomek_fragment,container,false);
        binding.setData(mViewModel);
        binding.buttonEnter.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_welcomekFragment_to_detailFragment));
        return binding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }

}
