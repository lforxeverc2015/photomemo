package com.irady.manager;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response.Listener;
import com.android.volley.toolbox.ImageRequest;
import com.android.volley.toolbox.Volley;

public class RequestManger {
	private static RequestQueue mQueue;
	private static RequestManger instance;
	private int screenWidth;
	private int screenHeight;
	public static RequestQueue getmQueue() {
		return mQueue;
	}
	public static RequestManger getInstance() {
		return instance;
	}
	private RequestManger() {
	}
	public static void init (Context c){
		instance=new RequestManger();
		mQueue=Volley.newRequestQueue(c.getApplicationContext());
	}
	
	public void setViewImage(final ImageView iv,String url){
		ImageRequest i=new ImageRequest(url, new Listener<Bitmap>() {

			@Override
			public void onResponse(Bitmap response) {
				// TODO Auto-generated method stub
				iv.setImageBitmap(response); 
			}
		}, 0,0, Config.RGB_565, null);
		mQueue.add(i);
	}
}
