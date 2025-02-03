package com.revanth.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfig {

  @Value("${admin.user}")
  private String adminUser;
  @Value("${admin.passowrd}")
  private String adminPassowrd;
  @Value("${admin.role}")
  private String adminRole;

  @Value("${user.user}")
  private String userUser;
  @Value("${user.password}")
  private String userPassowrd;
  @Value("${user.role}")
  private String userRole;

  @Bean
  public UserDetailsService userDetailsService() {
    UserDetails admin = User.withUsername(adminUser)
        .password(passwordEncoder()
            .encode(adminPassowrd))
        .roles(adminRole)
        .build();
    UserDetails user = User.withUsername(userUser)
        .password(passwordEncoder()
            .encode(userPassowrd))
        .roles(userRole)
        .build();
    return new InMemoryUserDetailsManager(admin,user);
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    http
        .csrf(csrf -> csrf.disable()) // Disable CSRF for APIs
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/greet").hasRole(userRole)
            .requestMatchers("/hello").hasRole(adminRole)
            .requestMatchers("/hi").hasRole(adminRole)
            .requestMatchers("/thanks").hasRole(adminRole)
            .anyRequest().authenticated()
        )
        .httpBasic(withDefaults());
    return http.build();
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }
}


