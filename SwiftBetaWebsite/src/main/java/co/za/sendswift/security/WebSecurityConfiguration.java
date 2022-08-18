package co.za.sendswift.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{
	
@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
		//super.configure(auth);
		.withUser("dizadennis@outlook.com")
		.password("Password176")
		.roles("USER"); 
		
		
	}	
@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.anyRequest().hasRole("USER").and()
		.formLogin()
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.logoutUrl("/logout")
		.permitAll();
		
		
	
	}
}
