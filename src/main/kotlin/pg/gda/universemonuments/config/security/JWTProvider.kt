package pg.gda.universemonuments.config.security

import io.jsonwebtoken.Claims
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import pg.gda.universemonuments.user.model.entity.User
import java.time.LocalDateTime
import java.time.ZoneId
import java.util.*
import javax.crypto.spec.SecretKeySpec
import javax.xml.bind.DatatypeConverter


@Component
class JWTProvider(
        @Value("\${token.key.secret}") private val secret: String,
        @Value("\${token.key.expiration}") private val expiration: Long,
        @Value("\${spring.application.name}") private val applicationName: String
) {
    private val signingKey: SecretKeySpec

    init {
        val apiKeySecretBytes = DatatypeConverter.parseBase64Binary(secret)
        signingKey = SecretKeySpec(apiKeySecretBytes, SignatureAlgorithm.HS256.jcaName)
    }

    fun issue(user: User): String {
        return Jwts.builder()
                .setIssuer(applicationName)
                .setSubject(user.login)
                .setIssuedAt(generateIssuedAtTime())
                .setExpiration(generateExpirationTime())
                .addClaims(createClaims(user))
                .signWith(SignatureAlgorithm.HS512, signingKey)
                .compact()
    }

    fun from(token: String?): JsonWebToken {
        return try {
            val claims = Jwts.parser().setSigningKey(signingKey).parseClaimsJws(token).body
            JsonWebToken(
                    userType = JsonWebToken.Type.USER,
                    userId = claims["userId"] as Int,
                    userLogin = claims["userLogin"] as String
            )
        } catch (exception: Exception) {
            JsonWebToken.invalid
        }
    }

    private fun createClaims(user: User): Claims {
        return Jwts.claims().apply {
            put("userId", user.id)
            put("userLogin", user.login)
        }
    }

    private fun generateIssuedAtTime(): Date {
        return Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant());
    }

    private fun generateExpirationTime(): Date {
        return Date.from(LocalDateTime.now().plusHours(expiration).atZone(ZoneId.systemDefault()).toInstant())
    }

}