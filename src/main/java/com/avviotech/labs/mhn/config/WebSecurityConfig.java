package com.avviotech.labs.mhn.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AccessDeniedHandler accessDeniedHandler;

	@Autowired
	private CustomAuthenticationProvider provider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.authorizeRequests()
				.antMatchers("/aboutus/**","/success/**","/book-patient/**","/book-page/**","/search/**","/","/register/**","/register-doctor/**","/index/**", "/sass/**", "/admin/**","/assets/**" ,"/css/**","/img/**","/ertabs/**", "/js/**","/home","/registerUser","/reservationconfirmation","/submitUser","/book-appointment","/patient-reservation",
						"/less/**", "/public/rest/**").permitAll()
				.antMatchers("/index/**").hasAnyRole("USER").anyRequest()
				.authenticated().and().formLogin().loginPage("/login")
				.defaultSuccessUrl("/dashboard",true)
				.usernameParameter("username").passwordParameter("password")
				.permitAll().and().logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout")).logoutSuccessUrl("/loginAction").and()
				.exceptionHandling().accessDeniedHandler(accessDeniedHandler);
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		 auth.authenticationProvider(provider);
	}

	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.inMemoryAuthentication().withUser("USER").password("PASSWORD")
				.roles("USER");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
}