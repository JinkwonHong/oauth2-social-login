package com.toyproject.oauthsociallogin.client.oauth

import com.toyproject.oauthsociallogin.common.type.OAuth2Provider
import org.springframework.stereotype.Service


@Service
class OAuth2ClientService(
) {
    fun generateLoginPageUrl(provider: OAuth2Provider): String {
        TODO()
    }
    fun login(provider: OAuth2Provider, authorizationCode: String): OAuth2LoginUserInfo {
        TODO()
    }
}