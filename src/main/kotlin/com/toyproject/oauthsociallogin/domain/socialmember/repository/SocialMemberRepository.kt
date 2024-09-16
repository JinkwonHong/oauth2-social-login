package com.toyproject.oauthsociallogin.domain.socialmember.repository

import com.toyproject.oauthsociallogin.common.type.OAuth2Provider
import com.toyproject.oauthsociallogin.domain.socialmember.model.SocialMember
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface SocialMemberRepository : CrudRepository<SocialMember, Long> {
    fun findByProviderAndProviderId(kakao: OAuth2Provider, id: String): SocialMember?
}