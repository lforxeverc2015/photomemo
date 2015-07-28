package com.irady;

import android.app.Application;

public class PhotoMemoApp extends Application {
	public static PhotoMemoApp instance;
	@Override
	public void onCreate() {
		super.onCreate();
		instance=this;
	}
}
