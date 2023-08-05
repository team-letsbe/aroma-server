package esperer.appjam.domain.daily.persist

import esperer.appjam.domain.daily.constant.Emotion
import esperer.appjam.domain.user.persist.User
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.*

@Entity
class Daily(

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(columnDefinition = "BINARY(16)", nullable = false)
    val id: UUID,

    @Column(nullable = false)
    val content: String,

    @Column(nullable = false, updatable = false, columnDefinition = "DATETIME(6)")
    val createdAt: LocalDateTime = LocalDateTime.now(),

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    val emotion: Emotion,

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: User
)