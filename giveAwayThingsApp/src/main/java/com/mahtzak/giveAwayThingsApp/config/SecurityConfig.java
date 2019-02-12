package com.mahtzak.giveAwayThingsApp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource=dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    @Override
    protected void configure (HttpSecurity http) throws Exception {
        http
                .formLogin()
                .loginPage("/login")
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/")
                .and()
                .authorizeRequests()
                .antMatchers("/register").anonymous()
                .antMatchers("/login").anonymous()
                .antMatchers("/").permitAll()
                .antMatchers("/admin").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                .csrf().disable()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        "SELECT email, password, true from users where email=?")
                .authoritiesByUsernameQuery("SELECT u.email, ur.role from users_roles ur " +
                        "join users u on u.id=ur.user_id where u.email=?");
    }
}
