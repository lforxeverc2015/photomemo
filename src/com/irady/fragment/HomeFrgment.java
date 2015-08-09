package com.irady.fragment;

import java.util.ArrayList;
import java.util.List;

import com.irady.adapter.HomeAdapter;
import com.irady.model.HomeData;
import com.irady.photomemo.R;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class HomeFrgment extends Fragment {
	private Context mContext;
	private List<HomeData> datas;
	private ListView lv;
	public HomeFrgment() {
		super();
	}
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		mContext=activity;
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fm_home, container,false);
		lv=(ListView) v.findViewById(R.id.lv_home);
		datas=new ArrayList<HomeData>();
		HomeData d1=new HomeData();
		d1.setComment("̩ɽ�ϣ�һ����ɽС��");
		d1.setName("��Ұ������");
		d1.setTime("2015-6-17");
		d1.setIcon("http://y1.ifengimg.com/84114d70eae58e7a/2013/0424/rdn_5177e4831ce88.jpg");
		datas.add(d1);
		HomeData d2=new HomeData();
		d2.setComment("��ɽ���ɹ�ʯ��");
		d2.setName("ľľ��ľ��");
		d2.setTime("2015-6-15");
		d2.setIcon("http://www.ctps.cn/PhotoNet/Profiles2011/20110612/20116121218504082.jpg");
		datas.add(d2);
		HomeData d3=new HomeData();
		d3.setComment("��ɽ�꣡");
		d3.setName("˼��ĳ�");
		d3.setTime("2015-6-14");
		d3.setIcon("http://upload.17u.net/uploadpicbase/2015/3/20/aa/201503200248333729.jpg");
		datas.add(d3);
		HomeData d4=new HomeData();
		d4.setComment("��Դ��÷�ᣬ�޷�������������");
		d4.setName("ɽ���˼�");
		d4.setTime("2015-6-1");
		d4.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d4);
		HomeData d5=new HomeData();
		d5.setComment("Զ�е��ˣ�");
		d5.setName("��˵�е���ظ�ԭ����ӽ����õĵط�");
		d5.setTime("2015-5-1");
		d5.setIcon("http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1408/31/c0/38071781_38071781_1409446422843.jpg");
		
		datas.add(d5);
		
		HomeData d6=new HomeData();
		d6.setComment("�Ϻ�����");
		d6.setName("��һ�");
		d6.setTime("2015-4-23");
		d6.setIcon("http://images.quanjing.com/chineseview009/high/251-0069.jpg");
		
		datas.add(d6);
		
		
		HomeData d7=new HomeData();
		d7.setComment("��Դ��÷�ᣬ�޷�������������");
		d7.setName("ɽ���˼�");
		d7.setTime("2015-6-1");
		d7.setIcon("http://p0.55tuanimg.com/static/goods/ckeditor/2012/08/30/20/ckeditor_1346331387_1979_wm.jpg");
		
		datas.add(d7);
		
		
		HomeData d8=new HomeData();
		d8.setComment("��Դ��÷�ᣬ�޷�������������");
		d8.setName("ɽ���˼�");
		d8.setTime("2015-6-1");
		d8.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d8);
		
		
		HomeData d9=new HomeData();
		d9.setComment("��");
		d9.setName("ɽ���˼�");
		d9.setTime("2015-6-1");
		d9.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d9);
		lv.setAdapter(new HomeAdapter(mContext, datas));
		return v;
	}
}
