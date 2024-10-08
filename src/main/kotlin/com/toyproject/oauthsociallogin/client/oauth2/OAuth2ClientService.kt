package com.toyproject.oauthsociallogin.client.oauth2

import com.toyproject.oauthsociallogin.common.type.OAuth2Provider
import jakarta.transaction.NotSupportedException
import org.springframework.stereotype.Service

@Service
class OAuth2ClientService(
    private val clients: List<OAuth2Client>
) {

    fun generateLoginPageUrl(provider: OAuth2Provider): String {
        val client = this.selectClient(provider)
        return client.generateLoginPageUrl()
    }

    fun login(provider: OAuth2Provider, authorizationCode: String): OAuth2LoginUserInfo {
        val client = this.selectClient(provider)
        return client.getAccessToken(authorizationCode)
            .let { client.retrieveUserInfo(it) }
    }

    private fun selectClient(provider: OAuth2Provider): OAuth2Client {
        return clients.find { it.supports(provider) }
            ?: throw NotSupportedException("지원하지 않는 OAuth Provider 입니다.")
    }
}