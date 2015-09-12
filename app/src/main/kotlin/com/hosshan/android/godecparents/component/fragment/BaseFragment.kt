package com.hosshan.android.godecparents.component.fragment

import android.support.v4.app.Fragment
import com.cookpad.android.rxt4a.subscriptions.AndroidCompositeSubscription

/**
 * Created by shunhosaka on 15/09/12.
 * Whats:
 * When :
 */
public open class BaseFragment : Fragment() {

    protected val compositeSubscription: AndroidCompositeSubscription = AndroidCompositeSubscription()

    override fun onPause() {
        super.onPause()
        compositeSubscription.unsubscribe();
    }

}