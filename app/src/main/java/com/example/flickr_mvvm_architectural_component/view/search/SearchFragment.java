package com.example.flickr_mvvm_architectural_component.view.search;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;

import com.example.flickr_mvvm_architectural_component.FlickrSearchImageApplication;
import com.example.flickr_mvvm_architectural_component.R;
import com.example.flickr_mvvm_architectural_component.databinding.SearchFragmentBinding;
import com.example.flickr_mvvm_architectural_component.utils.Utils;
import com.example.flickr_mvvm_architectural_component.view.adapter.SearchImageAdapter;
import com.example.flickr_mvvm_architectural_component.view.common.SpacesItemDecoration;
import com.example.flickr_mvvm_architectural_component.viewmodel.search.SearchViewModel;
import com.example.flickr_mvvm_architectural_component.viewmodel.ViewModelFactory;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;

public class SearchFragment extends Fragment {

    private SearchImageAdapter searchImageAdapter;
    private SearchFragmentBinding mainFragmentBinding;

    static SearchFragment newInstance() {
        return new SearchFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mainFragmentBinding = DataBindingUtil
			.inflate(inflater, R.layout.search_fragment, container, false);

        searchImageAdapter = new SearchImageAdapter();
        mainFragmentBinding.setLifecycleOwner(getViewLifecycleOwner());
        mainFragmentBinding.imagesGrid.setAdapter(searchImageAdapter);
        mainFragmentBinding.imagesGrid.setHasFixedSize(true);
        mainFragmentBinding.imagesGrid.addItemDecoration(new SpacesItemDecoration(
            (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 1.5f, getResources().getDisplayMetrics())
        ));

        mainFragmentBinding.imagesGrid.setLayoutManager(new GridLayoutManager(getActivity(), 3));

        return mainFragmentBinding.getRoot();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ViewModelFactory modelFactory = ((FlickrSearchImageApplication)getActivity().getApplication()).getViewModelFactory();
        final SearchViewModel mViewModel = ViewModelProviders.of(this, modelFactory).get(
            SearchViewModel.class);
        mainFragmentBinding.setSearchViewModel(mViewModel);

        Editable editable = mainFragmentBinding.query.getText();

        mainFragmentBinding.searchButton.setOnClickListener(v -> {
            if (editable != null || editable.toString().length() > 0) {
                search(mViewModel, editable);
                String query = editable.toString().toLowerCase();
                mainFragmentBinding.query.onEditorAction(EditorInfo.IME_ACTION_DONE);
                ((InputMethodManager)getActivity().getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(getView().getWindowToken(), 0);;
            }
        });


        mViewModel.getImages().observe(getViewLifecycleOwner(), images -> {
            if (images != null) {
                searchImageAdapter.submitList(images);
            }
        });
    }

    private void search(SearchViewModel mViewModel, Editable editable) {
        mViewModel.setQuery(editable.toString().toLowerCase());
        mViewModel.searchImages();
    }
}