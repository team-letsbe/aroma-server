package esperer.appjam.global.security.auth

import esperer.appjam.domain.user.exception.UserNotFoundException
import esperer.appjam.domain.user.persist.UserJpaRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
@Transactional(readOnly = true)
class AuthDetailsService(
    private val userRepository: UserJpaRepository
) : UserDetailsService {

    override fun loadUserByUsername(username: String): UserDetails {
        val user = userRepository.findByIdOrNull(UUID.fromString(username))
            ?: throw UserNotFoundException()
        return AuthDetails(user)
    }

}