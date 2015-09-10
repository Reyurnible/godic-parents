package com.hosshan.android.godecparents.util

import android.content.Context
import android.net.Uri
import retrofit.RequestInterceptor
import retrofit.RestAdapter
import retrofit.converter.GsonConverter
import timber.log.Timber
import kotlin.platform.platformStatic

/**
 * Created by a40875 on 2015/09/10.
 */
public class CodicRetrofitUtil {

    companion object {
        platformStatic fun buildRestAdapter(context: Context): RestAdapter {
            val builder: RestAdapter.Builder = RestAdapter.Builder()
            builder.setEndpoint(getEndPoint(context))
            builder.setRequestInterceptor(getRequestInterceptor(context))
            builder.setConverter(GsonUtil.getRetrofitConverter())
            builder.setLogLevel(RestAdapter.LogLevel.FULL)
            builder.setLog({
                Timber.i(it)
            })
            return builder.build()
        }

        platformStatic fun getEndPoint(context: Context): String {
            val builder: Uri.Builder = Uri.Builder()
            builder.scheme("https")
            builder.authority("api.codic.jp")
            return builder.build().toString()
        }

        platformStatic fun getRequestInterceptor(context: Context): RequestInterceptor {
            val requestInterceptor: RequestInterceptor = RequestInterceptor {
                it.addHeader("Authorization", "Bearer " + "bHEdExeRcKaUS8nnYhDbRsLPUuEN1FPV2");
            }
            return requestInterceptor
        }
    }
}