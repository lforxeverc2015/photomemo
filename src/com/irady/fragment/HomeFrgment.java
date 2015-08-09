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
		d1.setComment("泰山上，一览众山小！");
		d1.setName("狂野的人生");
		d1.setTime("2015-6-17");
		d1.setIcon("http://y1.ifengimg.com/84114d70eae58e7a/2013/0424/rdn_5177e4831ce88.jpg");
		datas.add(d1);
		HomeData d2=new HomeData();
		d2.setComment("黄山奇松怪石！");
		d2.setName("木木有木有");
		d2.setTime("2015-6-15");
		d2.setIcon("http://www.ctps.cn/PhotoNet/Profiles2011/20110612/20116121218504082.jpg");
		datas.add(d2);
		HomeData d3=new HomeData();
		d3.setComment("中山陵！");
		d3.setName("思念的城");
		d3.setTime("2015-6-14");
		d3.setIcon("http://upload.17u.net/uploadpicbase/2015/3/20/aa/201503200248333729.jpg");
		datas.add(d3);
		HomeData d4=new HomeData();
		d4.setComment("婺源的梅尼，无法用语言描述！");
		d4.setName("山里人家");
		d4.setTime("2015-6-1");
		d4.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d4);
		HomeData d5=new HomeData();
		d5.setComment("远行的人！");
		d5.setName("传说中的青藏高原，最接近天堂的地方");
		d5.setTime("2015-5-1");
		d5.setIcon("http://img.pconline.com.cn/images/upload/upc/tx/photoblog/1408/31/c0/38071781_38071781_1409446422843.jpg");
		
		datas.add(d5);
		
		HomeData d6=new HomeData();
		d6.setComment("上海景象！");
		d6.setName("徐家汇");
		d6.setTime("2015-4-23");
		d6.setIcon("http://images.quanjing.com/chineseview009/high/251-0069.jpg");
		
		datas.add(d6);
		
		
		HomeData d7=new HomeData();
		d7.setComment("婺源的梅尼，无法用语言描述！");
		d7.setName("山里人家");
		d7.setTime("2015-6-1");
		d7.setIcon("http://p0.55tuanimg.com/static/goods/ckeditor/2012/08/30/20/ckeditor_1346331387_1979_wm.jpg");
		
		datas.add(d7);
		
		
		HomeData d8=new HomeData();
		d8.setComment("婺源的梅尼，无法用语言描述！");
		d8.setName("山里人家");
		d8.setTime("2015-6-1");
		d8.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d8);
		
		
		HomeData d9=new HomeData();
		d9.setComment("！");
		d9.setName("山里人家");
		d9.setTime("2015-6-1");
		d9.setIcon("http://img5q.duitang.com/uploads/item/201408/26/20140826190529_fYtWr.jpeg");
		
		datas.add(d9);
		lv.setAdapter(new HomeAdapter(mContext, datas));
		return v;
	}
}
