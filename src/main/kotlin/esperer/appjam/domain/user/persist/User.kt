package esperer.appjam.domain.user.persist

import java.util.UUID
import javax.persistence.*

@Entity
class User(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    val id: UUID,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    val name: String,

)