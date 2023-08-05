package esperer.appjam.domain.user.persist

import esperer.appjam.domain.user.constant.UserRole
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val role: UserRole

)