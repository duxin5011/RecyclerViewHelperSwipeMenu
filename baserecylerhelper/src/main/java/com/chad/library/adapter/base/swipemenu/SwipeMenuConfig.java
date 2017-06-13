package com.chad.library.adapter.base.swipemenu;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.StringRes;

/**
 * @author duxin
 * @date 2017-6-12
 */
public class SwipeMenuConfig {

    private int id;
    private Context mContext;
    private String title;
    private Drawable icon;
    private int background;
    private int titleColor;
    private int titleSize;
    private int width;
    private int gravity;

    public int getGravity() {
        return gravity;
    }

    public void setGravity(int gravity) {
        this.gravity = gravity;
    }

    public SwipeMenuConfig(Context context) {
        mContext = context;
    }

    public Context getContext() {
        return mContext;
    }

    public int getIndex() {
        return id;
    }

    public void setIndex(int id) {
        this.id = id;
    }

    public int getTitleColor() {
        return titleColor;
    }

    public int getTitleSize() {
        return titleSize;
    }

    public void setTitleSize(int titleSize) {
        this.titleSize = titleSize;
    }

    public void setTitleColor(int titleColor) {
        this.titleColor = titleColor;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setTitle(@StringRes int resId) {
        setTitle(mContext.getString(resId));
    }

    public Drawable getIcon() {
        return icon;
    }

    public void setIcon(Drawable icon) {
        this.icon = icon;
    }

    public void setIcon(int resId) {
        this.icon = mContext.getResources().getDrawable(resId);
    }

    public int getBackground() {
        return background;
    }

    public void setBackgroundColor(int background) {
        this.background = background;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

}
