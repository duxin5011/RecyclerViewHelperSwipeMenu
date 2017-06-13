package com.duxin.mdemo.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.duxin.mdemo.R;
import com.duxin.mdemo.model.VideoBean;
import java.util.List;

/**
 * company : 青苗
 * Created by 杜新 on 2017/6/13.
 */
public class MyAdpter extends BaseQuickAdapter<VideoBean, BaseViewHolder> {
    private Context context;

    public MyAdpter(Context context, @Nullable List<VideoBean> data) {
        super(R.layout.item, data);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, VideoBean item) {
        Glide.with(context)
                .load(item.getImagrUrl())
                .into((ImageView) helper.getView(R.id.image));
        helper.setText(R.id.content, item.getTitle());
    }

    @Override
    public boolean isEnableSwipeMenu(int position) {
        if (position % 2 == 0) {
            return false;
        }
        return true;
    }
}