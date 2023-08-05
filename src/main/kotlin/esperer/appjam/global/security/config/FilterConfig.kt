package esperer.appjam.global.security.config

import esperer.appjam.global.filter.ExceptionFilter
import esperer.appjam.global.filter.JwtTokenFilter
import esperer.appjam.global.security.token.JwtTokenProvider
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val jwtTokenProvider: JwtTokenProvider,
): SecurityConfigurerAdapter<DefaultSecurityFilterChain?, HttpSecurity>() {

    override fun configure(builder: HttpSecurity) {
        val jwtTokenFilter = JwtTokenFilter(jwtTokenProvider)
        val exceptionFilter = ExceptionFilter()
        builder.addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter::class.java)
        builder.addFilterBefore(jwtTokenFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}