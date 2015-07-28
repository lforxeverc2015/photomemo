package com.irady.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.ImageLoader.ImageCache;
import com.android.volley.toolbox.ImageLoader.ImageListener;
import com.android.volley.toolbox.Volley;
import com.irady.PhotoMemoApp;
import com.irady.photomemo.R;

public class ImageUtil {
    public static ImageUtil instance=new ImageUtil();
    public static ImageLoader mLoader;
    private BitMapCache mBitMapCache;
    private RequestQueue mQueue;
    public final int MAX=1024*1024*10;
    public ImageUtil() {
        init(PhotoMemoApp.instance);
    }

    private void init(Context c) {
        mQueue=Volley.newRequestQueue(c);
        mBitMapCache=new BitMapCache();
        mLoader=new ImageLoader(mQueue, mBitMapCache);
    }
    public static void setImage(ImageView iv,String url){
        ImageListener mImageListener;
        mImageListener=ImageLoader.getImageListener(iv, R.drawable.ic_launcher, R.drawable.bg_camera);
        mLoader.get(url, mImageListener);
    }
    class BitMapCache implements ImageCache{
       
        LruCache<String, Bitmap> bmCache=new LruCache<String, Bitmap>(MAX){
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
                
            };
        };
        @Override
        public Bitmap getBitmap(String url) {
            return bmCache.get(url);
        }

        @Override
        public void putBitmap(String url, Bitmap bitmap) {
            bmCache.put(url, bitmap);
        }
        
    }
}
