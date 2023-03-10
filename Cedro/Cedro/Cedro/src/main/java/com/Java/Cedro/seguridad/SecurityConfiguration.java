package com.Java.Cedro.seguridad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.Java.Cedro.Servicio.UsuarioServicio;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioServicio usuarioServicio;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioServicio);
		auth.setPasswordEncoder(passwordEncoder());
		return auth;
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				"/registro**",
				"/index**",
				"/js/**",
				"/img/**",
				"/IMG/**",
				"/CSS/**",
				"/login**",
				"/LogIn/**",
				"/Videos/**",
				"/Recuperar**",
				"/message**",
				"/telas**",
				"/forgot_password**",
				"/reset_password**",
				"/reset_password_form**",
				"/prueba/upload",
				"/prueba/subir",
				"/prueba/cargar").permitAll()
		.antMatchers().hasRole("Cliente")
		.antMatchers("/cotizaciones/nuevo**").hasAuthority("Administrador")
		.antMatchers("/administradores/**").hasAuthority("Administrador")
		.antMatchers("/dashboardP/**").hasAuthority("Jefe de produccion")
		.antMatchers("/dashboardV/**").hasAuthority("Vendedor")
		
		.anyRequest().authenticated()
		.and()
		.formLogin()
	
		.loginPage("/login")
		.permitAll()
		.and()
		.logout()
		.invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/login?logout")
		.permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error");
		
	}

}
