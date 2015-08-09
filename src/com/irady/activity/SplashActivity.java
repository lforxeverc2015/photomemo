package com.irady.activity;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.irady.photomemo.R;

public class SplashActivity extends BaseActivity implements OnClickListener{
	Button btnRegist,btnLogin;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		btnLogin=(Button) findViewById(R.id.btn_login);
		btnRegist=(Button) findViewById(R.id.btn_regist);
		btnLogin.setOnClickListener(this);
		btnRegist.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_login:
			RegistLoginActivity.open(this, RegistLoginActivity.TAG_LOGIN);
			break;
		case R.id.btn_regist:
			RegistLoginActivity.open(this, RegistLoginActivity.TAG_REGIST);
			break;
		}
	}

}
