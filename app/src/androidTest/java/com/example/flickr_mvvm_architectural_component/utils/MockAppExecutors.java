package com.example.flickr_mvvm_architectural_component.utils;

import java.util.concurrent.Executor;

import android.os.Handler;
import android.os.Looper;

import androidx.annotation.NonNull;

public class MockAppExecutors extends AppExecutors {

	public MockAppExecutors(Executor diskIO, Executor networkIO, Executor mainThread) {
		super(diskIO, networkIO, mainThread);
	}

	public static MockAppExecutors build() {
		Executor e = new MainThreadExecutor();
		return new MockAppExecutors(e, e, e);
	}


	private static class MainThreadExecutor implements Executor {
		private Handler mainThreadHandler = new Handler(Looper.getMainLooper());

		@Override
		public void execute(@NonNull Runnable command) {
			mainThreadHandler.post(command);
		}
	}
}
