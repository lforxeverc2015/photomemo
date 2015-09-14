package com.irady.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.widget.ImageView;

import com.irady.photomemo.R;

public class UploadActivity extends Activity {
	
	ImageView iv;
	private final static String KEY_DATA = "img_path";
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_upload);
			iv = (ImageView) findViewById(R.id.iv_data);
			String path = getIntent().getStringExtra(KEY_DATA);
			if (path != null && path.length() > 0){
				Bitmap bm = BitmapFactory.decodeFile(path);
				Matrix mt = new Matrix();
				mt.postRotate(90);
				bm = Bitmap.createBitmap(bm, 0, 0, bm.getWidth(), bm.getHeight(), mt, true);
				iv.setImageBitmap(bm);
				
				
			}
		}
		
		public static  void start(Context c,String path){
			Intent i = new Intent(c,UploadActivity.class);
			i.putExtra(KEY_DATA, path);
			c.startActivity(i);
			
			
		}
}
