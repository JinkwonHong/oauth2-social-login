package com.toyproject.oauthsociallogin.domain.socialmember.service

import com.toyproject.oauthsociallogin.client.oauth2.OAuth2LoginUserInfo
import com.toyproject.oauthsociallogin.domain.socialmember.model.SocialMember
import com.toyproject.oauthsociallogin.domain.socialmember.repository.SocialMemberRepository
import org.springframework.stereotype.Service


@Service
class SocialMemberService(
    private val socialMemberRepository: SocialMemberRepository
) {

    fun registerIfAbsent(userInfo: OAuth2LoginUserInfo): SocialMember {
        return socialMemberRepository.findByProviderAndProviderId(userInfo.provider, userInfo.id) ?: run {
            val socialMember = SocialMember(
                provider = userInfo.provider, providerId = userInfo.id, nickname = userInfo.nickname
            )
            socialMemberRepository.save(socialMember)
        }
    }
}