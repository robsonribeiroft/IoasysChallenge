package com.rrdev.data_remote.mapper

import com.rrdev.data.model.SessionCredentials
import com.rrdev.data_remote.model.LogInResponse
import com.rrdev.domain.model.Investor
import com.rrdev.domain.model.Portfolio
import okhttp3.Headers
import com.rrdev.data_remote.model.Portfolio as PortfolioDataRemote

object AuthenticationMapper {

    fun toSessionCredentials(headers: Headers) = SessionCredentials(
        accessToken = headers[ACCESS_TOKEN_KEY]!!,
        client = headers[CLIENT_KEY]!!,
        uid = headers[UID_KEY]!!
    )

    fun toDomainInvestor(logInResponse: LogInResponse) = Investor(
        balance = logInResponse.investor?.balance ?: 0.0,
        city = logInResponse.investor?.city ?: "",
        country = logInResponse.investor?.country ?: "",
        email = logInResponse.investor?.email ?: "",
        firstAccess = logInResponse.investor?.firstAccess ?: false,
        id = logInResponse.investor?.id ?: 0,
        investorName = logInResponse.investor?.investorName ?: "",
        photo = logInResponse.investor?.photo ?: "",
        portfolio = toDomainPortfolio(logInResponse.investor?.portfolio),
        portfolioValue = logInResponse.investor?.portfolioValue ?: 0.0,
        superAngel = logInResponse.investor?.superAngel ?: false
    )

    private fun toDomainPortfolio(portfolio: PortfolioDataRemote?) = Portfolio(
        enterprisesNumber = portfolio?.enterprisesNumber ?: 0
    )

    private const val ACCESS_TOKEN_KEY = "accessToken"
    private const val CLIENT_KEY = "accessToken"
    private const val UID_KEY = "accessToken"
}