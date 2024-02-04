package com.medev.onlineexamportalbackend.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
@EnableMethodSecurity
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;
//    @Order(1)
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
//        http.csrf(csrf->csrf.ignoringRequestMatchers(("/csrf")))
//                .authenticationProvider(getAuthenticationProvider())
//                .authorizeHttpRequests((requests)->requests
//                        .requestMatchers(HttpMethod.GET,"/csrf")
//                        .permitAll().anyRequest().authenticated());
//
//
//        return http.build();
//    }
//
//    @Order(2)
//    @Bean
//    public SecurityFilterChain usersSecurityFilterChain(HttpSecurity http) throws Exception{
//        return http
//                .securityMatcher(new AntPathRequestMatcher(("/users")))
//                .authorizeHttpRequests(auth->auth.anyRequest().permitAll())
//                .build();
//    }
    // Delete this after finishing endpoints
    @Bean
    public SecurityFilterChain apiSecurityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.csrf(AbstractHttpConfigurer::disable)
                .authenticationProvider(getAuthenticationProvider())
                .authorizeHttpRequests(requests->requests
                        .anyRequest().permitAll())
                .build();
    }

    @Bean
    public PasswordEncoder providePasswordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider getAuthenticationProvider(){
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(providePasswordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        return daoAuthenticationProvider;
    }

}
