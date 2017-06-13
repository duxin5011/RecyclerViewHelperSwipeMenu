package com.chad.library.adapter.base.swipemenu;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SwipeMenuLayout extends LinearLayout implements View.OnClickListener {
    private OnSwipeItemClickListener onItemClickListener;
    private ArrayList<LinearLayout> linearLayouts;

    public SwipeMenuLayout(Context context) {
        super(context);
    }

    public SwipeMenuLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SwipeMenuLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setSwipeMenu(SwipeMenu menu) {
        List<SwipeMenuConfig> items = menu.getMenuItems();
        if (items.size()==0)
            throw new RuntimeException("Please set the configuration menu!");
        if (linearLayouts == null) {
            linearLayouts = new ArrayList<>();
        } else {
            linearLayouts.clear();
        }
        int id = 0;
        for (SwipeMenuConfig item : items) {
            addItem(item, id++);
        }
    }

    private void addItem(SwipeMenuConfig item, int id) {
        LayoutParams params = new LayoutParams(item.getWidth(), LayoutParams.MATCH_PARENT);
        LinearLayout parent = new LinearLayout(getContext());
        if (item.getIndex()==0){
            parent.setId(id);
        }else {
            parent.setId(item.getIndex());
        }
        parent.setGravity(Gravity.CENTER);
        parent.setOrientation(LinearLayout.VERTICAL);
        params.setMargins(1, 0, 1, 0);
        parent.setLayoutParams(params);
        parent.setBackgroundColor(item.getBackground());
        parent.setOnClickListener(this);
        addView(parent);
        if (item.getIcon() != null) {
            parent.addView(createIcon(item));
        }
        if (!TextUtils.isEmpty(item.getTitle())) {
            parent.addView(createTitle(item));
        }
        linearLayouts.add(parent);
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        if (item.getGravity() != Gravity.RIGHT && item.getGravity() != Gravity.LEFT) {
            lp.gravity = Gravity.RIGHT;
            setId(Gravity.RIGHT);
        } else {
            lp.gravity = item.getGravity();
            setId(item.getGravity());
        }
        this.setLayoutParams(lp);
    }

    public ArrayList<LinearLayout> getLinearLayouts() {
        if (linearLayouts != null) {
            return linearLayouts;
        }
        return new ArrayList<LinearLayout>();
    }

    private ImageView createIcon(SwipeMenuConfig item) {
        ImageView iv = new ImageView(getContext());
        iv.setImageDrawable(item.getIcon());
        return iv;
    }

    private TextView createTitle(SwipeMenuConfig item) {
        TextView tv = new TextView(getContext());
        tv.setText(item.getTitle());
        tv.setGravity(Gravity.CENTER);
        tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, item.getTitleSize());
        tv.setTextColor(item.getTitleColor());
        return tv;
    }

    @Override
    public void onClick(View v) {
        if (onItemClickListener != null) {
            onItemClickListener.onItemClick(v.getId());
        }
    }

    public OnSwipeItemClickListener getOnSwipeItemClickListener() {
        return onItemClickListener;
    }

    public void setOnSwipeItemClickListener(OnSwipeItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }


    public static interface OnSwipeItemClickListener {
        void onItemClick(int index);
    }
}
