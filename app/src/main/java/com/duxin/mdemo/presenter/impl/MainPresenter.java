package com.duxin.mdemo.presenter.impl;

import com.duxin.mdemo.api.ApiManager;
import com.duxin.mdemo.model.VideoBean;
import com.duxin.mdemo.presenter.BasePresenter;
import com.duxin.mdemo.presenter.IMainPresenter;
import com.duxin.mdemo.view.IMainView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

import okhttp3.ResponseBody;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * company : 青苗
 * Created by 杜新 on 2017/5/31.
 */

public class MainPresenter extends BasePresenter implements IMainPresenter {

    private IMainView iMainView;
    private final ArrayList<VideoBean> videoBeens;

    public MainPresenter(IMainView iMainView) {
        this.iMainView = iMainView;
        videoBeens = new ArrayList<>();
    }

    @Override
    public void getVideoData(int page) {
        iMainView.showProgressDialog();
        Subscription subscribe = ApiManager.getInstence().getVideoService().getVideoData(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<ResponseBody>() {
                    @Override
                    public void call(ResponseBody responseBody) {
                        try {
                            Document document = Jsoup.parse(responseBody.string());
                            Elements elements = document.getElementsByClass("j-r-list-c");
                            videoBeens.clear();
                            for (Element element : elements) {
                                VideoBean videoBean = new VideoBean();
                                String title = element.select("a[href]").first().text();
                                Element videoElement = element.getElementsByClass(" j-video").first();
                                String videoUrl = videoElement.attr("data-mp4");
                                String imageUrl = videoElement.attr("data-poster");
                                videoBean.setImagrUrl(imageUrl);
                                videoBean.setTitle(title);
                                videoBean.setVideoUrl(videoUrl);
                                videoBeens.add(videoBean);
                            }
                            iMainView.updataVideo(videoBeens);
                            iMainView.hideProgressDialog();
                        } catch (IOException e) {
                            e.printStackTrace();
                            iMainView.hideProgressDialog();
                        }
                    }
                });
        addSubscription(subscribe);
    }
}
