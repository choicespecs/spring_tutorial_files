package com.example.springsecurity.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class ProjectConfig extends WebSecurityConfigurerAdapter {

    /*
    UserDetails
    UserDetailsService -> UserDetailsManager
    PasswordEncoder
     */

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();

        UserDetails user_one = User.withUsername("bill")
                .password("12345")
                .roles("ADMIN")
                .authorities("write")
                .build();

        UserDetails user_two = User.withUsername("john")
                .password("12345")
                .roles("MANAGER")
                .authorities("read")
                .build();

        manager.createUser(user_one);
        manager.createUser(user_two);

        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
//        http.authorizeRequests()
//               .anyRequest().authenticated();

//        http.authorizeRequests()
//                .antMatchers(HttpMethod.GET).access("hasAnyRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.POST).access("hasAnyRole('ROLE_MANAGER')")
//                .anyRequest().permitAll();

        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/hello")
                .access("hasRole('ADMIN')")
                .anyRequest().permitAll();
    }
}
