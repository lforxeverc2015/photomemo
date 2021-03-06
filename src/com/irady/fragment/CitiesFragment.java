package com.irady.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.irady.adapter.StaggeredCityAdapter;
import com.irady.photomemo.R;

public class CitiesFragment extends Fragment {
	Context mContext;
	RecyclerView rvCities;
	public CitiesFragment() {
		super();
	}
	
	public CitiesFragment(Context c) {
		super();
		mContext=c;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v=inflater.inflate(R.layout.fm_citys, container,false);
		rvCities=(RecyclerView) v.findViewById(R.id.rv_city);
		rvCities.setLayoutManager(new StaggeredGridLayoutManager(3,LinearLayout.VERTICAL));
		rvCities.setAdapter(new StaggeredCityAdapter(mContext, null));
		rvCities.setItemAnimator(new DefaultItemAnimator());
		return v;
	}

}
