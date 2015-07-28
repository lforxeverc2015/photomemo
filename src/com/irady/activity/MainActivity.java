package com.irady.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;

import com.irady.fragment.CitiesFragment;
import com.irady.fragment.HomeFrgment;
import com.irady.manager.RequestManger;
import com.irady.photomemo.R;

public class MainActivity extends FragmentActivity implements OnClickListener,
		OnCheckedChangeListener {
	TextView tvHome, tvFind, tvMsg, tvAccount;
	ImageView ivCamera;
	RadioGroup rgTop;
	Animator selectedAnim;
	FragmentManager fm;
	HomeFrgment hm;
	CitiesFragment cm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		fm = getSupportFragmentManager();
		hm = new HomeFrgment(this);
		cm = new CitiesFragment(this);
		findViews();
		RequestManger.init(this);

	}

	private void initAnim(View v) {
		v.setSelected(true);
		selectedAnim = ObjectAnimator.ofFloat(v, "scaleX", 1.0f, 1.5f);
		Animator scaleY = ObjectAnimator.ofFloat(v, "scaleY", 1.0f, 1.5f);
		scaleY.setDuration(200);
		selectedAnim.setDuration(200);
		AnimatorSet set = new AnimatorSet();
		set.play(selectedAnim).with(scaleY);
		set.setDuration(200);
		set.start();
	}

	private void setViewType(View v) {
		v.setSelected(true);
	}

	private void findViews() {
		rgTop = (RadioGroup) findViewById(R.id.rg_tab);
		tvHome = (TextView) findViewById(R.id.tv_home);
		tvFind = (TextView) findViewById(R.id.tv_find);
		ivCamera=(ImageView) findViewById(R.id.iv_camera);
		tvMsg = (TextView) findViewById(R.id.tv_msg);
		tvAccount = (TextView) findViewById(R.id.tv_account);
		rgTop.setOnCheckedChangeListener(this);
		tvHome.setOnClickListener(this);
		tvFind.setOnClickListener(this);
		tvMsg.setOnClickListener(this);
		tvAccount.setOnClickListener(this);
		ivCamera.setOnClickListener(this);
		tvHome.performClick();

	}

	@Override
	public void onClick(View v) {
		// initAnim(v);
		switch (v.getId()) {
		case R.id.tv_home:
			FragmentTransaction ft = fm.beginTransaction();
			ft.replace(R.id.container, hm);
			ft.commit();
			break;

		case R.id.tv_find:
			FragmentTransaction ft1 = fm.beginTransaction();
			ft1.replace(R.id.container, cm);
			ft1.commit();
			break;
		case R.id.iv_camera:
			Toast.makeText(this, "dianji", Toast.LENGTH_SHORT).show();
			Intent i=new Intent(MainActivity.this,CameraActivity.class);
			startActivity(i);
			break;

		case R.id.tv_msg:

			break;
		case R.id.tv_account:

			break;
		default:
			break;
		}
	}

	@Override
	public void onCheckedChanged(RadioGroup arg0, int id) {
		switch (id) {
		case R.id.rb_tab_hot:

			break;

		case R.id.rb_tab_me:

			break;
		}
	}
}
