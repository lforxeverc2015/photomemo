package com.irady.util;

import com.android.volley.AuthFailureError;
import com.android.volley.Request.Method;
import com.android.volley.RequestQueue;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.irady.PhotoMemoApp;

import java.util.HashMap;
import java.util.Map;

public abstract class HttpUtil {
    private Map<String, String> mParams=new HashMap<String, String>();
    static RequestQueue mQueue;
    private StringRequest mStrReq;
    private Listener<String> mListance;
    private ErrorListener mErrorListener;
    private CalBack mCalBack;
    private String mUrl;
    private String mTag;
    private int METHOD=Method.POST;
    
    
    static{
        mQueue=Volley.newRequestQueue(PhotoMemoApp.instance);
    }
    
    public HttpUtil(String url){
    	mTag=null;
        mUrl=url;
        init(null);
    }
    
    public HttpUtil(String url,CalBack calback,String taskTag){
    	mTag=taskTag;
        mUrl=url;
        init(calback);
    }
    
    private void init(CalBack calback) {
        initCalback(calback);
        initListener();
    }
    private void initCalback(CalBack calback) {
        mCalBack=calback;
        
    }
    private void initListener() {
        mListance=new Listener<String>() {
            
            @Override
            public void onResponse(String response) {
                if(mCalBack != null){
                mCalBack.onSuccess(response,mTag);
                }
            }
        };
        mErrorListener=new ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                if(mCalBack != null){
                mCalBack.onError(error,mTag);
                }
            }
        };
    }
    
    public HttpUtil setCalback(CalBack calBack){
        initCalback(calBack);
        return HttpUtil.this;
    }
    
    
    public Map<String, String> setParams(Map<String, String> mParams){
        this.mParams=mParams;
        return this.mParams;
    }
    
    public void post(){
        METHOD=Method.POST;
        initRequest();
        mQueue.add(mStrReq);
        
    }
    
    public void get(){
        METHOD=Method.GET;
        initRequest();
        mQueue.add(mStrReq);
        
    }
    
    private void initRequest() {
        mStrReq=new StringRequest(METHOD,mUrl, mListance, mErrorListener){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                addParams(mParams);
                return mParams;
            }
        };
    }
    
    public HttpUtil setUrl(String mUrl) {
        this.mUrl = mUrl;
        return HttpUtil.this;
    }
    public HttpUtil setListance(Listener<String> mListance) {
        this.mListance = mListance;
        return HttpUtil.this;
    }
    public HttpUtil setCalBack(CalBack mCalBack) {
        this.mCalBack = mCalBack;
        return HttpUtil.this;
    }
     
    public interface CalBack {
         public void onSuccess(String responce,String tag);
         public void onError(VolleyError error,String tag);
     }
    
    public abstract void addParams(Map<String, String> params);
    
}
