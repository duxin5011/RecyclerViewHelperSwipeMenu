package com.duxin.mdemo.presenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * company : 青苗
 * Created by 杜新 on 2017/5/25.
 */

public class BasePresenter {

    private CompositeSubscription mCompositeSubscription;

    protected void addSubscription(Subscription s) {
        if (this.mCompositeSubscription == null) {
            this.mCompositeSubscription = new CompositeSubscription();
        }
        this.mCompositeSubscription.add(s);
    }

    public void unsubscrible() {
        if (this.mCompositeSubscription != null) {
            this.mCompositeSubscription.unsubscribe();
        }
    }
}
