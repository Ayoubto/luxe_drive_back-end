package com.example.test_project.configuration;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {





    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/getreservation/{id}","/getallreservations","/deletereservation/{id}","/updatereservation/{id}","/addreservation","/addvisitor","/getvisitor/{id}","/getallvisitors","/deletevisitor/{id}","/updatevisitor/{id}","/addlisting","/updatelisting/{id}","/deletelisting/{id}","/getalllistings","/getlisting/{id}","/gethoster/{id}","/getallhosters","/deletehoster/{id}","/updatehoster/{id}","/addhoster","/getalladmins","/getadmin/{id}","/deleteadmin/{id}","/updateadmin/{id}","/addadmin").permitAll() // Endpoints to register/signup and signin
                .anyRequest().authenticated()
                .and().httpBasic();

    }

//    @Override
//    @Bean
//    public AuthenticationManager authenticationManagerBean() throws Exception {
//        return super.authenticationManagerBean();
//    }

}


