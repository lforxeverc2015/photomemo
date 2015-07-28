
package com.irady.adapter;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.irady.photomemo.R;
import com.irady.util.ImageUtil;

public class StaggeredCityAdapter extends
        RecyclerView.Adapter<StaggeredCityAdapter.MyViewHolder>
{

    private String[] mDatas={"广州","北京","上海","南京","东京","西安","重庆","大理","梅州","新化","郑州","南昌","武汉","江西","南阳","肇庆"};
    private String[] urls = {
            "http://www.chinadaily.com.cn/dfpd/2011szdyh/image/attachement/jpg/site1/20110620/0013729ed1480f69816208.jpg",
            "http://img3.3lian.com/2006/013/02/015.jpg",
            "http://pic13.nipic.com/20110405/499308_103217509356_2.jpg",
            "http://pic34.nipic.com/20131017/8821914_143524470156_2.jpg",
            "http://pic1.nipic.com/20090324/271246_131817042_2.jpg",
            "http://pic49.nipic.com/file/20140923/19270006_155133649001_2.jpg",
            "http://img2.imgtn.bdimg.com/it/u=2262668481,4088355789&fm=21&gp=0.jpg",
            "http://news.folkw.com/Fuke_Files/BeyondPic/2007-7/31/1597928.jpg"
    };
    private LayoutInflater mInflater;

    private List<Integer> mHeights;

    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;
    private Context context;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    public StaggeredCityAdapter(){}
    public StaggeredCityAdapter(Context context, List<String> datas)
    {
        mInflater = LayoutInflater.from(context);
        this.context = context;
        mHeights = new ArrayList<Integer>();
        // for (int i = 0; i < mDatas.size(); i++)
        // {
        // mHeights.add( (int) (100 + Math.random() * 800));
        // }
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        MyViewHolder holder = new MyViewHolder(mInflater.inflate(
                R.layout.city_item, parent, false));
        return holder;
    }

    @Override
	public void onBindViewHolder(final MyViewHolder holder, final int position)
	{
//		LayoutParams lp = holder.tv.getLayoutParams();
//		lp.height = mHeights.get(position);
//		holder.tv.setLayoutParams(lp);
		holder.tv.setText(mDatas[position]);
//		ImageUtil.instance.setImage(holder.iv,"http://avatar.csdn.net/8/B/B/1_sinyu890807.jpg");
//		holder.iv;测试
		ImageUtil.setImage(holder.iv,urls[position%urls.length]);
		if (mOnItemClickLitener != null)
		{
			holder.itemView.setOnClickListener(new OnClickListener()
			{
				@Override
				public void onClick(View v)
				{
					mOnItemClickLitener.onItemClick(holder.itemView, position);
				}
			});

			holder.itemView.setOnLongClickListener(new OnLongClickListener()
			{
				@Override
				public boolean onLongClick(View v)
				{
					mOnItemClickLitener.onItemLongClick(holder.itemView, position);
					removeData(position);
					return false;
				}
			});
		}
	}

    @Override
    public int getItemCount()
    {
        return mDatas.length;
    }

    public void addData(int position)
    {
//        mDatas.add(position, "Insert One");
        mHeights.add((int) (100 + Math.random() * 800));
        notifyItemInserted(position);
    }

    public void removeData(int position)
    {
        notifyItemRemoved(position);
    }

    class MyViewHolder extends ViewHolder
    {

        TextView tv;
        ImageView iv;

        public MyViewHolder(View view)
        {
            super(view);
            tv = (TextView) view.findViewById(R.id.tv_city);
            iv = (ImageView) view.findViewById(R.id.iv);

        }
    }
}
