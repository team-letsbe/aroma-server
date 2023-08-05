package esperer.appjam.global.security.token

import io.jsonwebtoken.security.Keys
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding
import java.nio.charset.StandardCharsets
import java.security.Key

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
class JwtProperties(
    accessSecret: String,
    refreshSecret: String,
    val accessExp: Long,
    val refreshExp: Long
) {
    val accessSecret: Key
    val refreshSecret: Key

    init {
        this.accessSecret = Keys.hmacShaKeyFor(accessSecret.toByteArray(StandardCharsets.UTF_8))
        this.refreshSecret = Keys.hmacShaKeyFor(refreshSecret.toByteArray(StandardCharsets.UTF_8))
    }
}