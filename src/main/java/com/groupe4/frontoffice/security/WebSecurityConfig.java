package com.groupe4.frontoffice.security;

import com.groupe4.frontoffice.repository.user.UserRepository;
import com.groupe4.frontoffice.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import java.util.Optional;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
    @Autowired
    UserRepository userRepository;

    public static final String[] ENDPOINTS_BlACKLIST = {
            "/auth/**",
    };

    @Bean
    UserDetailsService customUserDetailsService() {
        return new UserDetailsServiceImpl();
    }
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(passwordEncoder());
        provider.setUserDetailsService(customUserDetailsService());
        return provider;
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws  Exception {
        http.authorizeHttpRequests()
                .requestMatchers(ENDPOINTS_BlACKLIST).authenticated()
                .anyRequest().permitAll();
        http.formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password");
        http.logout()
                .permitAll()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

        return http.build();
    }
}