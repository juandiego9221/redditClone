package pe.com.jdmm21.reddit.app.redditclone.security;

import org.springframework.boot.actuate.autoconfigure.security.servlet.EndpointRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter{

    private UserDetailsServiceImpl userDetailsServiceImpl;

    public SecurityConfiguration(UserDetailsServiceImpl userDetailsServiceImpl){
        this.userDetailsServiceImpl = userDetailsServiceImpl;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
        .requestMatchers(EndpointRequest.to("info")).permitAll()
        .requestMatchers(EndpointRequest.toAnyEndpoint()).hasRole("ADMIN")
        .antMatchers("/actuator/").hasRole("ADMIN")
        .antMatchers("/").permitAll()
        .antMatchers("/link/submit").hasRole("ADMIN")
        .and()
        .formLogin()
        .loginPage("/login").permitAll().usernameParameter("email")
        .and().logout()
        .and().rememberMe();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsServiceImpl);
    }
    
}