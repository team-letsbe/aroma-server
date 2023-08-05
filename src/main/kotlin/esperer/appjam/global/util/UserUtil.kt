package esperer.appjam.global.util

import esperer.appjam.domain.user.exception.UserNotFoundException
import esperer.appjam.domain.user.persist.User
import esperer.appjam.domain.user.persist.UserJpaRepository
import esperer.appjam.global.security.auth.AuthDetails
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserUtil(
    private val userRepository: UserJpaRepository
) {

    fun getCurrentUser(): User {
        val principal = SecurityContextHolder.getContext().authentication.principal
        val userId = if (principal is UserDetails) {
            (principal as AuthDetails).username
        } else {
            principal.toString()
        }
        return userRepository.findByIdOrNull(UUID.fromString(userId))
            ?: throw UserNotFoundException()
    }

}