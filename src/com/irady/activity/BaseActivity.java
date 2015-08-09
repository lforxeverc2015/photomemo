package com.irady.activity;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;

public class BaseActivity extends Activity {
	protected static List<Activity> acts=new ArrayList<Activity>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		acts.add(this);
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		acts.remove(this);
	}
	protected void removeAll(){
		for(Activity act:acts){
			if(act != null){
				act.finish();
			}
		}
	}

}
