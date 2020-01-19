package com.example.flickr_mvvm_architectural_component.view.adapter;

import android.view.View;

import androidx.databinding.BindingAdapter;

public class BindingAdapters {
    @BindingAdapter("visibleGone")
    public static void showHide(View view, boolean show) {
        view.setVisibility(show ? View.VISIBLE : View.GONE);
    }
}
