package esperer.appjam.domain.user.constant

import org.springframework.security.core.GrantedAuthority

enum class UserRole : GrantedAuthority{
    ROLE_USER, ROLE_ADMIN;

    override fun getAuthority(): String = name
}