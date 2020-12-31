package com.digi.unitouch.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import com.digi.unitouch.AccessDeniedHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer  {

	@Autowired
    private RequestMappingHandlerAdapter requestMappingHandlerAdapter;

	@Autowired
	AccessDeniedHandler accessDeniedHandler;
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@PostConstruct
    public void init() {
       requestMappingHandlerAdapter.setIgnoreDefaultModelOnRedirect(true);
    }
	
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		auth.authenticationProvider(authenticationProvider());
	}


	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
		authenticationProvider.setUserDetailsService(userDetailsService);
		authenticationProvider.setPasswordEncoder(passwordEncoder());
		return authenticationProvider;
	}
	
//	@Bean
//	public AuthenticationFailureHandler customAuthenticationFailureHandler() {
//		return new CustomAuthenticationFailureHandler();
//	}

	  @Override
	    public void addCorsMappings(CorsRegistry registry) {
	        registry.addMapping("/**");
	    }

	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login").permitAll() 
				.antMatchers("/createjournalApi").hasIpAddress("54.214.210.6")
				.antMatchers("/createjournalApi").permitAll()
				.antMatchers("/taskComplete").hasIpAddress("54.214.210.6")
				.antMatchers("/taskComplete").permitAll()
				.antMatchers("/createIsserSeq").permitAll()
				.antMatchers("/savejournal").hasIpAddress("54.214.210.6")
				.antMatchers("/updateCopyright").hasIpAddress("54.214.210.6")
				.antMatchers("/updateCopyright").permitAll()
				.antMatchers("/hiturl").permitAll()
				.antMatchers("/resources/**").permitAll() 
				.antMatchers("*/css/*").permitAll()
				.antMatchers("/getUserListById").permitAll()
				.antMatchers("/getUser").permitAll()	
				.antMatchers("/getTaskListById").permitAll()
				.antMatchers("/processStatus").permitAll()
				.antMatchers("/updateArticleStage").permitAll()
				.antMatchers("/forgotPassword").permitAll()
				.antMatchers("/resetPassword").permitAll()
				.antMatchers("/processStatuss").permitAll()
				.antMatchers("/forgotPasswordToken").permitAll()
				.antMatchers("/.well-known/pki-validation/ca3-d4c27c5450be46538c7ebd6e0289f9f6.txt").permitAll()
				.antMatchers("/savejournal").permitAll()
				.antMatchers("/validate").permitAll()
				.antMatchers("/download-Completedtask-file").permitAll()
				.antMatchers("**/js/**").permitAll()
				.antMatchers("**/resources/static/js/**").permitAll()
				.anyRequest().authenticated()
				.and().
				formLogin().loginPage("/login")
				//.failureHandler(customAuthenticationFailureHandler())
				.defaultSuccessUrl("/dashboard").permitAll()
				.and().logout().permitAll().logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.invalidateHttpSession(true).deleteCookies("JSESSIONID").permitAll()
				.and().exceptionHandling().accessDeniedHandler(accessDeniedHandler)
				.and().csrf().disable()
				;
	}

	
}