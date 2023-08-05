package esperer.appjam.domain.daily.persist

import org.springframework.data.repository.CrudRepository
import java.time.LocalDateTime
import java.util.UUID

interface DailyJpaRepository : CrudRepository<Daily, UUID> {
    fun findByCreatedAt(createdAt: LocalDateTime): Daily?
}