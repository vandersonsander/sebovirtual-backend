package br.com.pi.sebovirtual.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.pi.sebovirtual.services.UsuarioServiceImpl;
import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {
	@Autowired
	private UsuarioServiceImpl jwtUserDetails;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request,
			HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// Pega o token que foi passado pelo header
		// Ele vem no formato de string "Bearer ..."
		final String requestTokenHeader = request.getHeader("Authorization");
		
		String email = null;
		String token = null;
		
		if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
			// Tira a palabra Bearer e o espaço e deixa apenas o token
			token = requestTokenHeader.substring(7);
			try {
				email = jwtTokenUtil.getUsernameFromToken(token);
			} catch (IllegalArgumentException e) {
				System.out.println("Não foi possível decifrar o token");
			} catch (ExpiredJwtException e) {
				System.out.println("Token expirado");
			}
		}
		
		// Com o token faça a validação do email
		if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			UserDetails userDetails = this.jwtUserDetails.loadUserByUsername(email);
			
			if (jwtTokenUtil.validateToken(token, userDetails)) {
				UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken =
						new UsernamePasswordAuthenticationToken(
								userDetails, null, userDetails.getAuthorities());
				usernamePasswordAuthenticationToken
					.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			}
		}
		filterChain.doFilter(request, response);
	}
	
}
