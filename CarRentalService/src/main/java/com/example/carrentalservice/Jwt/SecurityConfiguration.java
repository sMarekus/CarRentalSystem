package com.example.carrentalservice.Jwt;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final JwtAuthenticationFilter jwtAuthFilter;

    /**
     * Configures the security filter chain for handling HTTP security configurations.
     *
     * @param http The HttpSecurity object to configure.
     * @return The configured SecurityFilterChain.
     * @throws Exception If an exception occurs during configuration.
     */

     @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
         return http.cors(withDefaults())
                 .csrf(AbstractHttpConfigurer::disable)
                 .authorizeHttpRequests(authorize -> authorize
                         .requestMatchers("/", "/users/authenticate").permitAll()
                         .requestMatchers(HttpMethod.POST, "/users").permitAll()
                         .requestMatchers(HttpMethod.GET, "/cars/{id}").permitAll()
                         .requestMatchers(HttpMethod.GET, "/cars").permitAll()
                         .anyRequest().authenticated())
                 .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                 .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class)
                 .build();
    }
}
