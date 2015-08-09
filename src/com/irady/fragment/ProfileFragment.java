package com.irady.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.irady.photomemo.R;

public class ProfileFragment extends Fragment {
	Context mContext;

	public ProfileFragment() {
		super();
	}
//	public ProfileFragment(Context context) {
//		mContext = context;
//	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view=inflater.inflate(R.layout.fm_profile, container, false);
		

		Button btnButton =(Button) view.findViewById(R.id.btn_regist);
		btnButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
//				new Regist("http://www.iradytech.com:8088/potomemo-server/user/register", ProfileFragment.this).post();
			}
		});
		Button btna=(Button) view.findViewById(R.id.btn_login);
		btna.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				new Login("http://www.i?radytech.com:8088/potomemo-server/user/login", ProfileFragment.this).post();
			}
		});
		return view;
	}
	
}
