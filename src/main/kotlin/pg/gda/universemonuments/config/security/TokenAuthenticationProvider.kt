package pg.gda.universemonuments.config.security

import org.springframework.security.authentication.AuthenticationProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken
import org.springframework.stereotype.Component

@Component
class TokenAuthenticationProvider(
        private val jwtProvider: JWTProvider
) : AuthenticationProvider {

    @Throws(AuthenticationException::class)
    override fun authenticate(authentication: Authentication?): Authentication {
        val token = jwtProvider.from(authentication?.name)

        if (token.isValid().not())
            throw BadCredentialsException("Token is not valid")

        return UsernamePasswordAuthenticationToken(token, null, null)
    }

    override fun supports(authentication: Class<*>?): Boolean {
        return PreAuthenticatedAuthenticationToken::class.java.isAssignableFrom(authentication)
    }

}