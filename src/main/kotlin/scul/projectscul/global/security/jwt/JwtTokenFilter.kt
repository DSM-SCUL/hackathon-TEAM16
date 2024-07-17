package com.study.kotlkotlin.global.security.jwt

import scul.projectscul.global.security.jwt.JwtTokenProvider
import javax.servlet.FilterChain
import javax.servlet.ServletException
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse


import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.OncePerRequestFilter
import java.io.IOException


class JwtTokenFilter(
        private val jwtTokenProvider: JwtTokenProvider
) : OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain
    ) {
        val token = jwtTokenProvider.resolveToken(request)

        token?.run {
            SecurityContextHolder.getContext().authentication = jwtTokenProvider.authentication(token)
        }

        filterChain.doFilter(request, response)
    }
}
