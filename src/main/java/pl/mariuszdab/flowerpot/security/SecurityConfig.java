package pl.mariuszdab.flowerpot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.mariuszdab.flowerpot.user.SpringDataUserDetailService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/fruit/add").permitAll()
                .antMatchers("/fruit/listFruits").hasRole("USER")
                .antMatchers("/daily").authenticated()
                .and().formLogin().loginPage("/login")
                .and().logout().logoutSuccessUrl("/")
                .permitAll();
    }

    @Bean
    public SpringDataUserDetailService customUserDetailsService() {
        return new SpringDataUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
