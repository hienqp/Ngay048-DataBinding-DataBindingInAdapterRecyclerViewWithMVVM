package com.example.databindinginadapterrecyclerviewwithmvvm;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databindinginadapterrecyclerviewwithmvvm.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        MainViewModel mainViewModel = new MainViewModel("DataBinding MainViewModel In MainActivity");

        // way1: same ViewBinding way
//        mActivityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());
//        mActivityMainBinding.setMainViewModel(mainViewModel);

        // way2:
        mActivityMainBinding = DataBindingUtil.setContentView(MainActivity.this, R.layout.activity_main);
        mActivityMainBinding.setMainViewModel(mainViewModel);

        displayRecyclerView();

        setContentView(mActivityMainBinding.getRoot());
    }

    private void displayRecyclerView() {
        UserAdapter userAdapter = new UserAdapter(createListUser());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this);
        RecyclerView rcvUser = mActivityMainBinding.rcvItems;
        rcvUser.setLayoutManager(linearLayoutManager);

        // đường phân cách trang trí giữa các item
        DividerItemDecoration itemDecoration = new DividerItemDecoration(MainActivity.this, DividerItemDecoration.VERTICAL);
        rcvUser.addItemDecoration(itemDecoration);

        rcvUser.setAdapter(userAdapter);
    }

    private List<UserViewModel> createListUser() {
        List<UserViewModel> list = new ArrayList<>();

        list.add(new UserViewModel("User 1", "Hoan Kiem, Ha Noi, Viet Nam"));
        list.add(new UserViewModel("User 2", "Hoan Kiem, Ha Noi, Viet Nam"));
        list.add(new UserViewModel("User 3", "Hoan Kiem, Ha Noi, Viet Nam"));
        list.add(new UserViewModel("User 4", "Hoan Kiem, Ha Noi, Viet Nam"));
        list.add(new UserViewModel("User 5", "Hoan Kiem, Ha Noi, Viet Nam"));

        return list;
    }
}