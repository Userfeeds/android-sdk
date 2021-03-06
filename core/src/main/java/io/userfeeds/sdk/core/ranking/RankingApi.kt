package io.userfeeds.sdk.core.ranking

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

internal interface RankingApi {

    @GET("ranking/{recipientAddress}/{algorithm}/")
    fun call(
            @Path("recipientAddress") recipientAddress: String,
            @Path("algorithm") algorithm: String,
            @Query("asset") asset: String,
            @Query("whitelist") whitelist: String?): Single<RankingResponse>
}
