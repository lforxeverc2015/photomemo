package com.irady.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.irady.manager.RequestManger;
import com.irady.model.HomeData;
import com.irady.photomemo.R;

public class HomeAdapter extends BaseAdapter {
	private Context mContext;
	private List<HomeData> datas;
	public HomeAdapter(Context c,List<HomeData> datas) {
		mContext=c;
		this.datas=datas;
	}

	@Override
	public int getCount() {
		return datas.size();
	}

	@Override
	public Object getItem(int arg0) {
		return arg0;
	}

	@Override
	public long getItemId(int arg0) {
		return arg0;
	}

	@Override
	public View getView(int position, View v, ViewGroup arg2) {
		Holder holder;
		if(v==null){
			v=LayoutInflater.from(mContext).inflate(R.layout.lv_home_item, arg2,false);
			holder=new Holder();
			ImageView iv=(ImageView) v.findViewById(R.id.iv_pic);
			TextView tvName=(TextView) v.findViewById(R.id.tv_name);
			TextView tvComment=(TextView) v.findViewById(R.id.tv_comment);
			TextView tvTime=(TextView) v.findViewById(R.id.tv_time);
			holder.setIvPic(iv);
			holder.setTvComment(tvComment);
			holder.setTvName(tvName);
			holder.setTvTime(tvTime);
			v.setTag(holder);
		}
		else{
			holder=(Holder) v.getTag();
		}
		HomeData data=datas.get(position);
		RequestManger.getInstance().setViewImage(holder.getIvPic(), data.getIcon());
		holder.getTvComment().setText(data.getComment());
		holder.getTvName().setText(data.getName());
		holder.getTvTime().setText(data.getTime());
		
		return v;
	}
	
	public class Holder{
		TextView tvName,tvComment,tvTime;
		ImageView ivPic;
		public TextView getTvName() {
			return tvName;
		}
		public void setTvName(TextView tvName) {
			this.tvName = tvName;
		}
		public TextView getTvComment() {
			return tvComment;
		}
		public void setTvComment(TextView tvComment) {
			this.tvComment = tvComment;
		}
		public TextView getTvTime() {
			return tvTime;
		}
		public void setTvTime(TextView tvTime) {
			this.tvTime = tvTime;
		}
		public ImageView getIvPic() {
			return ivPic;
		}
		public void setIvPic(ImageView ivPic) {
			this.ivPic = ivPic;
		}
	}


}
