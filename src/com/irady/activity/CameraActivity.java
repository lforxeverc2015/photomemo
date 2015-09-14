package com.irady.activity;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;

import com.irady.photomemo.R;
import com.irady.util.FileUtil;

public class CameraActivity extends Activity implements OnClickListener, OnTouchListener{
	private Camera mCamera;
	private SurfaceView sv;
	private SurfaceHolder sh;
//	private Button mRecordAudioBtn;
	private Button mPhotoBtn;
	private String rootPath = Environment.getExternalStorageDirectory()+File.separator+"photoMemo";
	private Handler mHandler=new Handler(Looper.getMainLooper()){
		public void handleMessage(android.os.Message msg) {
			mCamera=Camera.open();
			try {
				mCamera.setPreviewDisplay(sh);
				Camera.Parameters params=mCamera.getParameters();
				params.setPictureFormat(PixelFormat.JPEG);
				List<Size> sizes=params.getSupportedPictureSizes();
				params.setPictureSize(sizes.get(0).width, sizes.get(0).height);
				mCamera.setParameters(params);
				mCamera.setDisplayOrientation(90);
//				mCamera.cancelAutoFocus();
				mCamera.autoFocus(new AutoFocusCallback() {
					
					@Override
					public void onAutoFocus(boolean arg0, Camera arg1) {
						// TODO Auto-generated method 
						
						
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
			mCamera.startPreview();
//			mCamera.autoFocus(null);			
		
		};
	};
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_camera);
			sv=(SurfaceView) findViewById(R.id.sv);
			mPhotoBtn=(Button) findViewById(R.id.btn_take_photo);
//			mRecordAudioBtn = (Button) findViewById(R.id.btn_record_audio);
//			mRecordAudioBtn.setOnTouchListener(this);
			mPhotoBtn.setOnClickListener(this);
			
			
			mPhotoBtn.setOnTouchListener(new OnTouchListener(){

				@Override
				public boolean onTouch(View arg0, MotionEvent arg1) {
					return false;
				}});
			
			
			
		}
		@Override
		public void onClick(View arg0) {
			if(mCamera!=null){
				mCamera.takePicture(null, null, peg);
				
			}
			/*mCamera=Camera.open();
			try {
				mCamera.setPreviewDisplay(sh);
				Camera.Parameters params=mCamera.getParameters();
				params.setPictureFormat(PixelFormat.JPEG);
				params.setPictureSize(640, 480);
				mCamera.setParameters(params);
				mCamera.setDisplayOrientation(90);
			} catch (IOException e) {
				e.printStackTrace();
			}
			mCamera.startPreview();
			mCamera.autoFocus(null);*/	
		}
		final PictureCallback peg=new PictureCallback() {
			
			@Override
			public void onPictureTaken(byte[] arg0, Camera arg1) {
				String path = FileUtil.saveFile(rootPath, getPhotoName(), arg0);
				UploadActivity.start(CameraActivity.this, path);
			}

			
		};
		@Override
		protected void onDestroy() {
			super.onDestroy();
			if (mCamera != null ){
				mCamera.release();
				
			}
		}
		@Override
		public boolean onTouch(View arg0, MotionEvent arg1) {
			switch (arg1.getAction()) {
			case MotionEvent.ACTION_DOWN:
				Log.d("btn", "btn down");
				break;
			case MotionEvent.ACTION_UP:
				Log.d("btn", "btn up");
				break;
			default:
				break;
			}
			return false;
		}
		
		private String getPhotoName() {
			Calendar mCalendar = Calendar.getInstance();
			SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmSS");
			String name = df.format(mCalendar.getTime());
			return name;
		}
		
		@Override
		protected void onResume() {
			// TODO Auto-generated method stub
			super.onResume();
			sh=sv.getHolder();
			sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			mHandler.sendEmptyMessageDelayed(1, 200);
		}
		
		@Override
		protected void onStop() {
			// TODO Auto-generated method stub
			super.onStart();
			if (mCamera != null ){
				mCamera.release();
				
			}
//			mCamera.release();
		}
	
}
