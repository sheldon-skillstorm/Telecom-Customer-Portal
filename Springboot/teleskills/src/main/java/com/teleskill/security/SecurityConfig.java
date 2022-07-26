package com.teleskill.security;

import java.util.Arrays;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Bean
//	AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider provider
//		                 = new DaoAuthenticationProvider();
//		provider.setUserDetailsService(userDetailsService);
//		provider.setPasswordEncoder(new BCryptPasswordEncoder());
//		return provider;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception{
//		http.authorizeRequests()
//		.antMatchers("/")
//		.permitAll()
//		.antMatchers("/plans/v1")
//		.hasAuthority("ROLE_ADMIN")
//		.anyRequest()
//		.authenticated()
//		.and()
//		.httpBasic();
//	}

	
	
	
	///---------------------------------------------------------------------
//	@Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.httpBasic();
//    }
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
//    @Override
//    public void addCorsMappings(CorsRegistry registry) {
//        registry.addMapping("/**")
//                .allowedOrigins("*")
//                .allowedMethods("*");
//    }
	
	//------------------------------------------------------------------------------------------

	 @Autowired
	    private DataSource dataSource;
	 
		@Autowired
	    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	        auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
	            .dataSource(dataSource)
	            .usersByUsernameQuery("select username, password, enabled from users where username=?")
	            .authoritiesByUsernameQuery("select username, role from users where username=?")
	        ;
	            
		}

	 @Override
	    protected void configure(HttpSecurity http) throws Exception {
	        http.authorizeRequests()
	            .anyRequest().authenticated()
	            .and()
	            .formLogin().permitAll()
	            .and()
	            .logout().permitAll();     
	    }
		
		
		
//-------------------------------------------------------------------------------------------		
		
		
		
		
		
		
//		            .mvcMatchers("/plans/**")
//		            .hasRole("Role_USER")
//		            .anyRequest()
//		            .authenticated()
//		            .and()
//		            .formLogin()
//		           .loginPage("/login")
		           
//		           .and()
//	               .cors()
//	               .and()
//	               .csrf()
//	               .disable();
	
	

	
//	@Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

//	    @Bean
//	    CorsConfigurationSource corsConfigurationSource() {
//	        CorsConfiguration configuration = new CorsConfiguration();
//	        configuration.setAllowedOrigins(Arrays.asList("*"));
//	        configuration.setAllowedMethods(Arrays.asList("*"));
//	        configuration.setAllowedHeaders(Arrays.asList("*"));
//	        configuration.setAllowCredentials(true);
//	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//	        source.registerCorsConfiguration("/**", configuration);
//	        return source;
//	    }
//	    
	   
		
		
//	
//	@Override
//	public void addCorsMappings(CorsRegistry registry) {
//		registry.addMapping("/**")
//		        .allowedOrigins("*")
//		        .allowedMethods("*");
//	}
}
