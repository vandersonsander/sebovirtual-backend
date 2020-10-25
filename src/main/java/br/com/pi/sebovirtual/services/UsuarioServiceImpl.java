package br.com.pi.sebovirtual.services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.config.JwtTokenUtil;
import br.com.pi.sebovirtual.dto.LoginDTO;
import br.com.pi.sebovirtual.entities.Usuario;
import br.com.pi.sebovirtual.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UserDetailsService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public UserDetails loadUserByUsername(String email)
			throws UsernameNotFoundException {
		Optional<Usuario> optional = usuarioRepository.findByEmail(email);
		
		if (optional.isPresent()) {
			Usuario usuario = optional.get();
			
			return new User(usuario.getEmail(), usuario.getSenha(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("Usuário não encontrado com o email: " + email);
		}
	}
	
	private void authenticate(String email, String senha) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, senha));
		} catch(DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch(BadCredentialsException e) {
			throw new Exception("Senha está incorreta", e);
		}
	}
	
	public String login(LoginDTO loginDTO) throws Exception {
		this.authenticate(loginDTO.getEmail(), loginDTO.getSenha()); // Valida email e senhha
		
		UserDetails userDetails = this.loadUserByUsername(loginDTO.getEmail());
		String token = jwtTokenUtil.generateToken(userDetails); // Gera o token
		
		return token;
	}

}
