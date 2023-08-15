package com.example.databindinginadapterrecyclerviewwithmvvm;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import com.example.databindinginadapterrecyclerviewwithmvvm.databinding.FragmemtMyBinding;

public class MyFragment extends Fragment {
    private FragmemtMyBinding mFragmentMyBinding;
    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // way1:
//        mFragmentMyBinding = FragmemtMyBinding.inflate(inflater, container, false);
//        MyFragmentViewModel myFragmentViewModel = new MyFragmentViewModel("DataBinding Fragment MVVM");
//        mFragmentMyBinding.setMyFragmentViewModel(myFragmentViewModel);

        // way2:
        mFragmentMyBinding = DataBindingUtil.inflate(inflater, R.layout.fragmemt_my, container, false);
        MyFragmentViewModel myFragmentViewModel = new MyFragmentViewModel("DataBinding Fragment MVVM");
        mFragmentMyBinding.setMyFragmentViewModel(myFragmentViewModel);

        view = mFragmentMyBinding.getRoot();
        return view;
    }
}
