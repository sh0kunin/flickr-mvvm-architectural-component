package com.example.flickr_mvvm_architectural_component.data.model;

import androidx.annotation.Nullable;

import static com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus.ERROR;
import static com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus.SUCCESS;
import static com.example.flickr_mvvm_architectural_component.data.model.LoadingStatus.LOADING;

/**
 * /**
 *  * A generic class that holds a value with its loading status.
 *
 *  Code Reference : https://github.com/android/architecture-components-samples/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/vo/Resource.kt
 */
public class Resource<T> {

    private final LoadingStatus mLoadingStatus;

    @Nullable
    private final T mData;

    @Nullable
    private final String mErrorMessage;

    private Resource(LoadingStatus loadingStatus, @Nullable T data, @Nullable String errorMessage) {
        this.mLoadingStatus = loadingStatus;
        this.mData = data;
        this.mErrorMessage = errorMessage;
    }

    public static <T> Resource<T> success(T data) {
        return new Resource<>(SUCCESS, data, null);
    }

    public static <T> Resource<T> error(String errorMessage, @Nullable T data) {
        return new Resource<>(ERROR, data, errorMessage);
    }

    public static <T> Resource<T> loading(@Nullable T data) {
        return new Resource<>(LOADING, data, null);
    }

    public LoadingStatus getLoadingStatus() {
        return mLoadingStatus;
    }

    @Nullable
    public T getData() {
        return mData;
    }

    @Nullable
    public String getErrorMessage() {
        return mErrorMessage;
    }
}