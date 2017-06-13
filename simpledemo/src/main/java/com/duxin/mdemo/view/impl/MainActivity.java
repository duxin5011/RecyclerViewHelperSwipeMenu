package com.duxin.mdemo.view.impl;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.swipemenu.SwipeMenu;
import com.chad.library.adapter.base.swipemenu.SwipeMenuConfig;
import com.chad.library.adapter.base.swipemenu.SwipeMenuCreator;
import com.chad.library.adapter.base.swipemenu.SwipeMenuRecyclerView;
import com.duxin.mdemo.R;
import com.duxin.mdemo.adapter.MyAdpter;
import com.duxin.mdemo.model.VideoBean;
import com.duxin.mdemo.presenter.impl.MainPresenter;
import com.duxin.mdemo.view.IMainView;

import java.util.ArrayList;

/**
 * company : 青苗
 * Created by 杜新 on 2017/6/13.
 */

public class MainActivity extends AppCompatActivity implements IMainView, BaseQuickAdapter.OnItemSwipeMenuListener, SwipeMenuCreator {

    private SwipeMenuRecyclerView rv;
    private MainPresenter mainPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rv = (SwipeMenuRecyclerView) findViewById(R.id.recyclerView);
        mainPresenter = new MainPresenter(this);
        mainPresenter.getVideoData(1);
    }

    @Override
    public void updataVideo(ArrayList<VideoBean> videoBeens) {
        MyAdpter myAdpter = new MyAdpter(this, videoBeens);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(myAdpter);
        myAdpter.setOnItemSwipeMenuListener(new BaseQuickAdapter.OnItemSwipeMenuListener() {
            @Override
            public void onItemSwipeMenu(int position, int index) {

            }
        });
        myAdpter.setSwipeMenuCreator(new SwipeMenuCreator() {
            @Override
            public void SwipeMenuCreat(SwipeMenu swipeMenu) {
                SwipeMenuConfig menuConfig = new SwipeMenuConfig(MainActivity.this);
                menuConfig.setBackgroundColor(Color.parseColor("#ff0000"));
                menuConfig.setIndex(0);
                menuConfig.setTitle("侧滑");
                menuConfig.setTitleColor(Color.WHITE);
                menuConfig.setTitleSize(16);
                menuConfig.setWidth(dip2px(72));
                //滑动方向 可以不设置 默认RIGHT
                menuConfig.setGravity(Gravity.RIGHT);
                //添加多个显示多个菜单  可以设置  menuConfig.setIndex()区分 不设置 默认  0开始依次相加

                swipeMenu.addMenuConfig(menuConfig);
            }
        });
        myAdpter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(MainActivity.this, "onItemClick  " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public void showProgressDialog() {

    }

    @Override
    public void hideProgressDialog() {

    }

    @Override
    public void showError(String error) {

    }

    //配置侧滑菜单
    @Override
    public void SwipeMenuCreat(SwipeMenu swipeMenu) {


    }

    /**
     * @param position
     * @param index    区分多个侧滑菜单
     */
    @Override
    public void onItemSwipeMenu(int position, int index) {

        Toast.makeText(this, "onItemSwipeMenu  " + position, Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.unsubscrible();
    }

    public int dip2px(float var1) {
        float var2 = getResources().getDisplayMetrics().density;
        return (int) (var1 * var2 + 0.5F);
    }

}
