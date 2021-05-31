package br.com.zupacademy.graziella.proposta.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests(authorizeRequests ->
			authorizeRequests
				.antMatchers(HttpMethod.GET, "/api/propostas/**").hasAuthority("SCOPE_propostas_all")
				.antMatchers(HttpMethod.POST, "/api/propostas/**").hasAuthority("SCOPE_propostas_all")
				.antMatchers(HttpMethod.POST, "/api/bloqueio/**").hasAuthority("SCOPE_propostas_all")
				.anyRequest().authenticated()
		)
		.oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
	}
}
