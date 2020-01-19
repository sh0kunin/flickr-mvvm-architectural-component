package com.example.flickr_mvvm_architectural_component.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

/**
 * Global executor pools for the whole application.
 * <p>
 * Grouping tasks like this avoids the effects of task starvation (e.g. disk reads don't wait behind
 * webservice requests).
 * <p>
 * Code borrowed from https://github.com/android/architecture-components-samples/blob/master/PersistenceMigrationsSample/app/src/main/java/com/example/android/persistence/migrations/AppExecutors.java
 */
public class AppExecutors {

	private final Executor mDiskIO;

	private final Executor mNetworkIO;

	private final Executor mMainThread;

	public AppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
		this.mDiskIO = diskIO;
		this.mNetworkIO = networkIO;
		this.mMainThread = mainThread;
	}

	public AppExecutors() {
		this(Executors.newSingleThreadExecutor(), Executors.newFixedThreadPool(1),
			new MainThreadExecutor());
	}

	public Executor diskIO() {
		return mDiskIO;
	}

	public Executor networkIO() {
		return mNetworkIO;
	}

	public Executor mainThread() {
		return mMainThread;
	}

	private static class MainThreadExecutor implements Executor {
		private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

		@Override
		public void execute(@NonNull Runnable command) {
			mainThreadHandler.post(command);
		}
	}
}
