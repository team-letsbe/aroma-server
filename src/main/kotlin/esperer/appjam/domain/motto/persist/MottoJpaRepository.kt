package esperer.appjam.domain.motto.persist

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MottoJpaRepository : CrudRepository<Motto, UUID> {
    @Query(value = "SELECT * FROM motto ORDER BY RAND() LIMIT 1", nativeQuery = true)
    fun findRandomMotto(): Motto?

}