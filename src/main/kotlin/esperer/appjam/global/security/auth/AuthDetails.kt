package esperer.appjam.global.security.auth

import esperer.appjam.domain.user.persist.User
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.userdetails.UserDetails

class AuthDetails(
    private val user: User
) : UserDetails {

    override fun getAuthorities(): MutableCollection<out GrantedAuthority> = mutableListOf(user.role)

    override fun getPassword(): String? =
        null

    override fun getUsername(): String =
        user.id.toString()

    override fun isAccountNonExpired(): Boolean =
        true

    override fun isAccountNonLocked(): Boolean =
        true


    override fun isCredentialsNonExpired(): Boolean =
        true

    override fun isEnabled(): Boolean =
        isAccountNonExpired && isAccountNonLocked && isCredentialsNonExpired
}