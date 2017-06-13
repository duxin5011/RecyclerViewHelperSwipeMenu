# description
对 [BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper) 进行
 侧滑菜单功能添加封装  更方便大家使用
 如需使用BaseRecyclerViewAdapterHelper 可以参考 [点一下](http://www.jianshu.com/p/b343fcff51b0)
 
 ## How to use?
添加demo中library到你的项目
布局如下     如果不适用侧滑  只需要[BaseRecyclerViewAdapterHelper](https://github.com/CymChad/BaseRecyclerViewAdapterHelper)功能可以使用原生recyclerView
```
 <com.chad.library.adapter.base.swipemenu.SwipeMenuRecyclerView
        android:id="@+id/recyclerView"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
 ```
 
 
代码实现.
```
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
        myAdpter.setOnItemClickListener(this);必须添加条目点击要不swipeMenu无法获取touch事件
```
也可以在adapter中重写isEnableSwipeMenu判断item是否开启侧滑菜单
```
   @Override
    public boolean isEnableSwipeMenu(int position) {
        if (position % 2 == 0) {
            return false;
        }
        return true;
    }
 ```
