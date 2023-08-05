package esperer.appjam.domain.motto.persist

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Motto(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: UUID,

    @Column(columnDefinition = "VARCHAR(254)", nullable = false)
    val content: String,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    val createdBy: String
) {
}