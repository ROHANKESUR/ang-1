package com.example.ang_1.Configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


   @Autowired
   private UserDetailsService userDetailsService;

   @Autowired
   private CorsConfigurationSource corsConfigurationSource;


   @Bean
   public SecurityFilterChain securityFilterChain ( HttpSecurity http ) throws Exception {
      http.authorizeHttpRequests( req -> req
              .requestMatchers( "/api/register", "api/login" ).permitAll()
              .anyRequest().authenticated() );
      http.sessionManagement( session -> session.sessionCreationPolicy( SessionCreationPolicy.STATELESS ) );
      http.csrf( AbstractHttpConfigurer :: disable )
              .cors( cors -> cors.configurationSource( corsConfigurationSource ) );
      http.httpBasic();


      return http.build();

   }


   @Bean
   public AuthenticationProvider authenticationProvider () {
      DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
      authenticationProvider.setPasswordEncoder( passwordEncoder() );
      authenticationProvider.setUserDetailsService( userDetailsService );
      return authenticationProvider;
   }

   @Bean
   PasswordEncoder passwordEncoder () {
      return new BCryptPasswordEncoder();
   }

   @Bean
   public AuthenticationManager authenticationManager ( AuthenticationConfiguration configuration ) throws Exception {
      return configuration.getAuthenticationManager();
   }


}
