package io.userfeeds.sdk.core.infrastructure.retrofit

import com.squareup.moshi.Moshi
import io.reactivex.schedulers.Schedulers
import io.userfeeds.sdk.core.UserfeedsSdk
import io.userfeeds.sdk.core.infrastructure.Provider
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level.BODY
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.math.BigDecimal

internal object RetrofitProvider : Provider<Retrofit>({
    Retrofit.Builder()
            .baseUrl("https://api.userfeeds.io/")
            .client(OkHttpClient.Builder()
                    .apply { if (UserfeedsSdk.debug) addInterceptor(HttpLoggingInterceptor().setLevel(BODY)) }
                    .build())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .addConverterFactory(MoshiConverterFactory.create(Moshi.Builder()
                    .add(BigDecimal::class.java, BigDecimalJsonAdapter())
                    .build()))
            .build()
})
