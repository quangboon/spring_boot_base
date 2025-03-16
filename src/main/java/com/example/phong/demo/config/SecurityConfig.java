// filepath: /Users/quang/develop/spring-boot-demo/spring_boot_base/src/main/java/com/example/phong/config/SecurityConfig.java
package com.example.phong.demo.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    List<String> arrApiAllowString = Arrays.asList("/swagger-ui/**",
     "/v3/api-docs/**", "/swagger-ui.html", "/swagger-ui/index.html", "/v1/api/echo");

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests ->
                authorizeRequests
                    .requestMatchers(arrApiAllowString.toArray(new String[0])).permitAll() // Allow access to Swagger UI and API docs
                    .anyRequest().authenticated()
            )
            .formLogin(formLogin ->
                formLogin.permitAll() // Allow form login
            )
            .logout(logout ->
                logout.permitAll() // Allow logout
            )
            .httpBasic();

        return http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
            arrApiAllowString.toArray(new String[0])
        );
    }
}