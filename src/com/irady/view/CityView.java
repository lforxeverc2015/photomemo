package com.irady.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.irady.manager.RequestManger;
import com.irady.photomemo.R;

public class CityView extends LinearLayout {
	ImageView iv;
	TextView tv;

	public CityView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	public CityView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public CityView(Context context) {
		super(context);
		init(context);
	}
	
	
	
	public void init(Context c){
		View v=View.inflate(c, R.layout.city_item, this);
		iv=(ImageView) v.findViewById(R.id.iv);
		tv=(TextView) v.findViewById(R.id.tv_city);
		
	}
	
	public void setText(String s){
		tv.setText(s);
	}
	
	public void setImg(String url){
		RequestManger.getInstance().setViewImage(iv, url);
	}

}
