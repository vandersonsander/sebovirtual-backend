package br.com.pi.sebovirtual.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailsService; // implementação do método está no UsuarioService

	@Autowired
	private JwtRequestFilter jwtRequestFilter;
	

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		// como fazer a autenticação e como vamos criptografar 
		auth.userDetailsService(userDetailsService)
			.passwordEncoder(passwordEncoder());
	}

	@Bean
	public PasswordEncoder passwordEncoder() { 
		// classe com a lógica da criptografia
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
				.csrf()
				.disable()
// Não cheque essas requisições
				.authorizeRequests()
					.antMatchers(HttpMethod.POST, "/usuario")
						.permitAll()
					.antMatchers(HttpMethod.POST, "/pessoafisica")
						.permitAll()
					.antMatchers(HttpMethod.POST, "/pessoajuridica")
						.permitAll()
					.antMatchers(HttpMethod.POST, "/login/**")
						.permitAll()
					.antMatchers(HttpMethod.GET, "/produto/**")
						.permitAll()
					.antMatchers(HttpMethod.GET, "/search/**")
						.permitAll()
					.antMatchers(HttpMethod.GET, "/anuncio/**")
						.permitAll()
					.antMatchers(HttpMethod.GET, "/upload/**")
						.permitAll()
// Qualquer outra requisição deve ser checada
				.anyRequest()
					.authenticated()
						.and()
				.sessionManagement()
					.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);

	}
	
	// liberação de arquivos estáticos (imagens, css, html, xml, json e outros)
    @Override 
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**")
        .antMatchers("/**.html", "/v2/api-docs", "/webjars/**", "/configuration/**", "/swagger-resources/**");
    }
}
