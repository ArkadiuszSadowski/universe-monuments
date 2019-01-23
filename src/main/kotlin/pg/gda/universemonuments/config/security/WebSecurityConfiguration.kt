package pg.gda.universemonuments.config.security

import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter

@Configuration
@EnableWebSecurity
class WebSecurityConfiguration : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {

        val filter = RequestHeaderAuthenticationFilter()
        filter.setPrincipalRequestHeader(HttpHeaders.AUTHORIZATION)
        filter.setAuthenticationManager(authenticationManager())
        filter.setExceptionIfHeaderMissing(false)
        http.addFilter(filter)

        http.authorizeRequests()
                .antMatchers("/user/register", "/user/log-in")
                .permitAll()
                .antMatchers("/webjars/**", "/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs")
                .permitAll()
                .anyRequest()
                .authenticated()

        http.csrf().disable()
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    }
}