package com.duxin.mdemo.view;

import com.duxin.mdemo.model.VideoBean;

import java.util.ArrayList;

/**
 * company : 青苗
 * Created by 杜新 on 2017/6/13.
 */

public interface IMainView extends IBaseView{
    void updataVideo(ArrayList<VideoBean> videoBeens);
}
