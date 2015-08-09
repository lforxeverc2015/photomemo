package com.irady.activity;

import java.util.Map;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.VolleyError;
import com.irady.define.API;
import com.irady.photomemo.R;
import com.irady.util.HttpUtil;
import com.irady.util.HttpUtil.CalBack;

public class RegistLoginActivity extends BaseActivity implements OnClickListener ,CalBack{
	EditText etAccount,etPsw,etRePsw;
	Button btnClose,btnSubmit;
	public static final String TAG_LOGIN="1";
	public static final String TAG_REGIST="2";
	public static String OPEN_TAG="OPEN_TAG";
	private String account,psw,rpsw;
	private String MY_TAG=null;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_regist_login);
		initViews();
		
	}
	private void initViews() {
		etAccount=(EditText) findViewById(R.id.et_account);
		etPsw=(EditText) findViewById(R.id.et_psw);
		etRePsw=(EditText) findViewById(R.id.et_confirm_psw);
		btnClose=(Button) findViewById(R.id.btn_close);
		btnSubmit=(Button) findViewById(R.id.btn_submit);
		btnClose.setOnClickListener(this);
		btnSubmit.setOnClickListener(this);
		Intent intent=getIntent();
		MY_TAG=intent.getStringExtra(OPEN_TAG);
		if(null != MY_TAG && MY_TAG.equals(TAG_LOGIN)){
			etRePsw.setVisibility(View.GONE);
			btnSubmit.setText(R.string.login);
		}
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btn_close:
			finish();
			break;

		case R.id.btn_submit:
			if(!vertify()){
				return;
			}
			if(MY_TAG.equals(TAG_REGIST)){
				new Regist(API.REGIST, RegistLoginActivity.this,MY_TAG).post();
			}
			else{
				new Login(API.LOGIN, RegistLoginActivity.this,MY_TAG).post();
			}
			break;
		}
	}
	
	@Override
	public void onSuccess(String responce,String tag) {
		switch (MY_TAG) {
		case TAG_LOGIN:
			Toast.makeText(this, "Login successful!", Toast.LENGTH_SHORT).show();
			Intent intent=new Intent(RegistLoginActivity.this,MainActivity.class);
			startActivity(intent);
			removeAll();
			break;

		case TAG_REGIST:
			Toast.makeText(this, "Regist successful,Loging automatically~", Toast.LENGTH_SHORT).show();
			MY_TAG=TAG_LOGIN;
			new Login(API.LOGIN, RegistLoginActivity.this,MY_TAG).post();
			break;
		}
		
	}
	@Override
	public void onError(VolleyError error,String tag) {
		Toast.makeText(this, "error="+error.getMessage(), Toast.LENGTH_SHORT).show();
		
	}
	
	public static void open(Context c,String openTag){
		Intent intent=new Intent(c,RegistLoginActivity.class);
		intent.putExtra(OPEN_TAG, openTag);
		c.startActivity(intent);
	}
	class Regist extends HttpUtil{

		public Regist(String url, CalBack calback,String tag) {
			super(url, calback,tag);
		}

		@Override
		public void addParams(Map<String, String> params) {
			params.put("phone", account);
			params.put("password", psw);
		}
		
	}
	
	class Login extends HttpUtil{

		public Login(String url, CalBack calback,String tag) {
			super(url, calback,tag);
		}

		@Override
		public void addParams(Map<String, String> params) {
			params.put("phone", account);
			params.put("password", psw);
		}
		
	}
	
	private boolean vertify(){
		if( null != MY_TAG){
			account=etAccount.getText().toString().trim();
			psw=etPsw.getText().toString().trim();
			rpsw=etRePsw.getText().toString().trim();
			if(account ==null || psw == null){
				Toast.makeText(this, "account or password is empty!", Toast.LENGTH_SHORT).show();
				return false;
			}
			else if(MY_TAG.equals(TAG_REGIST) && (rpsw == null || !rpsw.equals(psw))){
				Toast.makeText(this, "the confirm password is not matched!", Toast.LENGTH_SHORT).show();
				return false;
			}
		}else{
			Toast.makeText(this, "my tag is empty!", Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

}
