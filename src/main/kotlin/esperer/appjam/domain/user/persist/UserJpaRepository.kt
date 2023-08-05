package esperer.appjam.domain.user.persist

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface UserJpaRepository : CrudRepository<User, UUID> {
}