package com.mariia.syne.taxi_service.config;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.session.HttpSessionEventPublisher;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
@PropertySource("classpath:user.properties")
@PropertySource("classpath:admin.properties")
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Value("${user.login}")
    private String userLogin;

    @Value("${user.password}")
    private String userPassword;

    @Value("${admin.login}")
    private String adminLogin;

    @Value("${admin.password}")
    private String adminPassword;


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .inMemoryAuthentication()
                .withUser(adminLogin)
                .password(passwordEncoder().encode(adminPassword))
                .roles("ADMIN")
                .and()
                .withUser(userLogin)
                .password(passwordEncoder().encode(userPassword))
                .roles("USER");

//        auth
//                .inMemoryAuthentication()
//                .withUser("user1").password(passwordEncoder().encode("user1Pass")).roles("USER")
//                .and()
//                .withUser("user2").password(passwordEncoder().encode("user2Pass")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("adminPass")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/index").permitAll()
//                .antMatchers("/users/create","/orders/**").hasAnyRole("ADMIN","USER")
                .antMatchers("/autos/**","/ui/autos/**").hasAnyRole("ADMIN")
//                .antMatchers("/users/**","/projects/**","/tasks/**","/mvc-users/**","/mvc-projects/**","/mvc-tasks/**").hasAnyRole("ADMIN","MANAGER","QA","DEVELOPER","USER")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .deleteCookies("JSESSIONID")
                .permitAll();

        //-----------session configuration
        http
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED);

        //enable the scenario which allows multiple concurrent sessions
        //for the same user
        http
                .sessionManagement().maximumSessions(2);

        //on authentication a new HTTP Session is created,
        //the old one is invalidated and
        //(migrateSession) the attributes from the old session are copied over
        //(newSession) the attributes from the old session are NOT copied over
        http
                .sessionManagement().sessionFixation().newSession();
    }


    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //for the enabling the concurrent session-control support we add listener
    //to make sure that the Spring Security session registry is notified
    //when the session is destroyed
    @Bean
    public HttpSessionEventPublisher httpSessionEventPublisher() {
        return new HttpSessionEventPublisher();
    }

}