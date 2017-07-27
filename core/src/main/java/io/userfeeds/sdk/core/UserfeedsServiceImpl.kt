package io.userfeeds.sdk.core

import io.userfeeds.sdk.core.algorithm.Algorithm
import io.userfeeds.sdk.core.algorithm.getAlgorithmsImpl
import io.userfeeds.sdk.core.ranking.getRankingImpl
import io.userfeeds.sdk.core.storage.Claim
import io.userfeeds.sdk.core.storage.Signature
import io.userfeeds.sdk.core.storage.putClaimImpl

internal object UserfeedsServiceImpl : UserfeedsService {

    override fun getAlgorithms(context: RankingContext)
            = getAlgorithmsImpl(context)

    override fun getRanking(context: RankingContext, algorithm: Algorithm, whitelist: String?)
            = getRankingImpl(context, algorithm, whitelist)

    override fun putClaim(context: RankingContext, type: List<String>, claim: Claim, signature: Signature, client: String)
            = putClaimImpl(context, type, claim, signature, client)
}
