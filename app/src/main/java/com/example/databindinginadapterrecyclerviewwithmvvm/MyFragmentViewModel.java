package com.example.databindinginadapterrecyclerviewwithmvvm;

public class MyFragmentViewModel {
    private String title;

    public MyFragmentViewModel(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
