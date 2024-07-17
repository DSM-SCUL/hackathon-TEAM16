package scul.projectscul.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.RequiredArgsConstructor
import scul.projectscul.global.security.jwt.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*

@EnableWebSecurity
@RequiredArgsConstructor
@Configuration
class SecurityConfig(
        private val jwtTokenProvider: JwtTokenProvider,
        private val objectMapper: ObjectMapper
) {

    @Bean
    @Throws(Exception::class)
    protected fun configure(httpSecurity: HttpSecurity): SecurityFilterChain {
        return httpSecurity
                .csrf().disable()
                .cors().and()
                .exceptionHandling()
                .and()
                .headers()
                .frameOptions().sameOrigin()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/auth").permitAll()
                .antMatchers("/survey/**", "/survey-comment/**").hasRole("ADMIN")
                .antMatchers("/feed/**", "/comment/**", "/user/**", "/survey-storage/**", "/co-comment/**", "/like/**", "/comment-like/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .apply(FilterConfig(jwtTokenProvider, objectMapper))
                .and()
                .build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("*") // 모든 도메인 허용
        configuration.allowedMethods = Arrays.asList("OPTIONS", "GET", "POST", "PUT", "PATCH", "DELETE") // HTTP 메서드 허용
        configuration.allowCredentials = false
        configuration.addAllowedHeader("*") // 모든 헤더 허용

        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration) // 모든 경로에 대해 위에서 설정한 CORS 설정 적용
        return source
    }
}
