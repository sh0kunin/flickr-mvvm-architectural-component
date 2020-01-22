package com.example.flickr_mvvm_architectural_component.view.search;

import android.os.Bundle;

import com.example.flickr_mvvm_architectural_component.R;

import androidx.appcompat.app.AppCompatActivity;

/*
  Search activity just a holder for fragment.
 */
public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.search_activity);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(
                R.id.layout_container,
                SearchFragment.newInstance()
            ).commitNow();
        }
    }
}
