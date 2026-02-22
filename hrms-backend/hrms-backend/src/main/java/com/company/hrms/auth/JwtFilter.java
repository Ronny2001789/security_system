package com.company.hrms.auth;

import com.company.hrms.user.User;
import com.company.hrms.user.UserRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
@Component
// Custom JWT filter that runs once per request
// Responsible for validating JWT and setting authentication context
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        // Extract Authorization header from incoming request
        String authHeader = request.getHeader("Authorization");

        // Check if header contains a valid Bearer token
        if (authHeader != null && authHeader.startsWith("Bearer ")) {

            // Remove "Bearer " prefix to get raw token
            String token = authHeader.substring(7);

            // Extract username from JWT
            String username = jwtUtil.extractUsername(token);

            // Load user from database and set authentication in SecurityContext
            userRepository.findByUsername(username).ifPresent(user -> {

                // Convert role enum to Spring Security authority format (ROLE_*)
                UsernamePasswordAuthenticationToken auth =
                        new UsernamePasswordAuthenticationToken(
                                user,
                                null,
                                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()))
                        );

                // Set authenticated user in SecurityContext
                SecurityContextHolder.getContext().setAuthentication(auth);
            });
        }

        // Continue the filter chain
        filterChain.doFilter(request, response);
    }
}

