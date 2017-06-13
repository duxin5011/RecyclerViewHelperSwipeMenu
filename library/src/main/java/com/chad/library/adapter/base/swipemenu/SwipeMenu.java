package com.chad.library.adapter.base.swipemenu;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author baoyz
 * @date 2014-8-23
 * 
 */
public class SwipeMenu {

	private Context mContext;
	private ArrayList<SwipeMenuConfig> mItems;
	private int mViewType;

	public SwipeMenu(Context context) {
		mContext = context;
		mItems = new ArrayList<SwipeMenuConfig>();
	}

	public Context getContext() {
		return mContext;
	}

	public void addMenuConfig(SwipeMenuConfig item) {
		mItems.add(item);
	}

	public void removeMenuItem(SwipeMenuConfig item) {
		mItems.remove(item);
	}

	public List<SwipeMenuConfig> getMenuItems() {
		return mItems;
	}

	public SwipeMenuConfig getMenuItem(int index) {
		return mItems.get(index);
	}

	public int getViewType() {
		return mViewType;
	}

	public void setViewType(int viewType) {
		this.mViewType = viewType;
	}

}
