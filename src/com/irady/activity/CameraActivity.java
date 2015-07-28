package com.irady.activity;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.irady.photomemo.R;

import android.app.Activity;
import android.graphics.PixelFormat;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.Size;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CameraActivity extends Activity implements OnClickListener{
	private Camera mCamera;
	private SurfaceView sv;
	private SurfaceHolder sh;
	private Button mBtn;
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
				mCamera.cancelAutoFocus();;
			} catch (IOException e) {
				e.printStackTrace();
			}
			mCamera.startPreview();
			mCamera.autoFocus(null);			
		
		};
	};
		@Override
		protected void onCreate(Bundle savedInstanceState) {
			super.onCreate(savedInstanceState);
			setContentView(R.layout.activity_camera);
			sv=(SurfaceView) findViewById(R.id.sv);
			mBtn=(Button) findViewById(R.id.btn_take_photo);
			mBtn.setOnClickListener(this);
			sh=sv.getHolder();
			sh.setType(SurfaceHolder.SURFACE_TYPE_PUSH_BUFFERS);
			mHandler.sendEmptyMessageDelayed(1, 200);
			
			
			
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
				File f=new File(Environment.getExternalStorageDirectory()+File.separator+"test.jpg");
				try {
					FileOutputStream fos=new FileOutputStream(f);
					fos.write(arg0);
					fos.flush();
					fos.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
	
}
