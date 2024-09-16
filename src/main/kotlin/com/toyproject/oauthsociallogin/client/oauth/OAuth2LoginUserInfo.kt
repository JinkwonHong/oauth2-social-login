package com.toyproject.oauthsociallogin.client.oauth

import com.toyproject.oauthsociallogin.common.type.OAuth2Provider

open class OAuth2LoginUserInfo(
    val provider: OAuth2Provider,
    val id: String,
    val nickname: String
)