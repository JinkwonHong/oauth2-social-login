package com.toyproject.oauthsociallogin.client.oauth2.naver.dto

import com.fasterxml.jackson.databind.PropertyNamingStrategy
import com.fasterxml.jackson.databind.annotation.JsonNaming
import com.toyproject.oauthsociallogin.client.oauth2.OAuth2LoginUserInfo
import com.toyproject.oauthsociallogin.common.type.OAuth2Provider

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy::class)
class NaverLoginUserInfoResponse(
    id: String,
    nickname: String
) : OAuth2LoginUserInfo(
    provider = OAuth2Provider.NAVER,
    id = id,
    nickname = nickname
)