package esperer.appjam.domain.motto.persist

import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MottoJpaRepository : CrudRepository<Motto, UUID> {
}