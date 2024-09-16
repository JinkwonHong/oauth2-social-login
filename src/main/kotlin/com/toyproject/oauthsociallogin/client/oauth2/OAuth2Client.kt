package com.toyproject.oauthsociallogin.client.oauth2

import com.toyproject.oauthsociallogin.common.type.OAuth2Provider

interface OAuth2Client {
    fun generateLoginPageUrl(): String
    fun getAccessToken(authorizationCode: String): String
    fun retrieveUserInfo(accessToken: String): OAuth2LoginUserInfo
    fun supports(provider: OAuth2Provider): Boolean
}