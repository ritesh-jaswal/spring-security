package com.example.Spring_Security_Client.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig
{
//    private static final String[] WHITE_LIST_URLS = {"/hello","/register"};

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(cors -> cors.disable())  // Explicitly disable CORS
                .csrf(csrf -> csrf.disable())  // Disable CSRF protection
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/hello").permitAll()
                        .requestMatchers("/verifyRegistration**").permitAll()
                        .requestMatchers("/resendVerifyToken**").permitAll()
                        .requestMatchers("/resetPassword**").permitAll()
                        .requestMatchers("/savePassword**").permitAll()
                        .requestMatchers("/changePassword").permitAll()
                        .requestMatchers("/register").permitAll() // Permit all requests to white-listed URLs
                        .requestMatchers("/api/**").authenticated() // Require authentication for requests
                )
                .oauth2Login(oauth2Login -> oauth2Login
                        .loginPage("/oauth2/authorization/api-client-oidc")
                )
                .oauth2Client(Customizer.withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder()
    {
        return new BCryptPasswordEncoder(11);
    }
}
