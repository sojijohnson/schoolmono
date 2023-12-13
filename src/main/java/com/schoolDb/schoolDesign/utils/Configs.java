package com.schoolDb.schoolDesign.utils;

import com.schoolDb.schoolDesign.service.SupervisorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class Configs {
@Autowired
    private SupervisorService supervisorService;
@Autowired
private CustomerUsersDetailsService customerUsersDetailsService;
    @Autowired
    private JwtRequestFilter jwtFilter;
    @Autowired

    private AuthenticationProvider authenticationProvider;
//@Bean
//    public PasswordEncoder passwordEncoder(){
//
//        return new BCryptPasswordEncoder();
//    }

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(supervisorService).passwordEncoder(passwordEncoder());
//    }
@Bean

    public SecurityFilterChain securityFilterChain(HttpSecurity http)throws Exception{
        http
                .csrf( csrf->csrf.disable())
             //   .authorizeRequests()
                //.requestMatchers("/supervisor/**").hasRole("ADMIN") // Restrict access to admin URLs
                .authorizeHttpRequests((authorize) -> authorize
                        .requestMatchers(HttpMethod.GET).permitAll()
                        .requestMatchers(HttpMethod.POST).permitAll()
                        .requestMatchers("/supervisor/**").permitAll()
                        .requestMatchers("/classroom/**").permitAll()
                        .requestMatchers("/grade/**").permitAll()
                        .anyRequest().authenticated()
                ).httpBasic(Customizer.withDefaults());
               // .requestMatchers("/supervisor/**","student/*","/supervisor/register").permitAll()
               // .requestMatchers("/supervisor/*").permitAll()// Allow public URLs
              //  .anyRequest().authenticated()
              //  .and()
             //  .sessionManagement()
             //   .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
             //   .and()
              //  .authenticationProvider(authenticationProvider)
             //   .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

//                .and()
//                .formLogin()
//                .loginPage("/login") // Customize the login page URL
//                .defaultSuccessURL("/admin/dashboard", true) // Redirect on successful login
//                .permitAll()
//                .and()
//                .logout()
//                .logoutSuccessUrl("/login")
//                .permitAll();
    }




}
