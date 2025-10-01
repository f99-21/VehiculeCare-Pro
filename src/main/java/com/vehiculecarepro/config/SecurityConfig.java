package com.vehiculecarepro.config;

import com.vehiculecarepro.service.JpaUserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final JpaUserDetailsService jpaUserDetailsService;

    public SecurityConfig(JpaUserDetailsService jpaUserDetailsService) {
        this.jpaUserDetailsService = jpaUserDetailsService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        // Permitimos el acceso a los archivos estáticos (CSS, JS) sin autenticación
                        .requestMatchers("/css/**", "/js/**").permitAll()
                        // Todas las demás peticiones requieren autenticación
                        .anyRequest().authenticated()
                )
                .userDetailsService(jpaUserDetailsService)
                // Configuramos nuestro formulario de login personalizado
                .formLogin(form -> form
                        .loginPage("/login") // La URL de nuestra página de login
                        .defaultSuccessUrl("/dashboard", true) // A dónde ir después de un login exitoso
                        .permitAll() // Permitimos el acceso a la página de login a todos
                )
                // Configuramos la funcionalidad de logout
                .logout(logout -> logout
                        .logoutSuccessUrl("/login?logout") // A dónde ir después de un logout exitoso
                        .permitAll()
                );

        return http.build();
    }
}