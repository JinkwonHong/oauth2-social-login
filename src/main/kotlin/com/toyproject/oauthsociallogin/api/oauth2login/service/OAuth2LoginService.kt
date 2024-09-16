package com.toyproject.oauthsociallogin.api.oauth2login.service

import com.toyproject.oauthsociallogin.client.oauth2.OAuth2ClientService
import com.toyproject.oauthsociallogin.common.JwtHelper
import com.toyproject.oauthsociallogin.common.type.OAuth2Provider
import com.toyproject.oauthsociallogin.domain.socialmember.service.SocialMemberService
import org.springframework.stereotype.Service

@Service
class OAuth2LoginService(
    private val oAuth2ClientService: OAuth2ClientService,
    private val socialMemberService: SocialMemberService,
    private val jwtHelper: JwtHelper
) {

    fun login(provider: OAuth2Provider, authorizationCode: String): String {
        return oAuth2ClientService.login(provider, authorizationCode)
            .let { socialMemberService.registerIfAbsent(it) }
            .let { jwtHelper.generateAccessToken(it.id!!) }
    }
}