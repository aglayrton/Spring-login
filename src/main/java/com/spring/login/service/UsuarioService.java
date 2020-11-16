package com.spring.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.login.entitys.Perfil;
import com.spring.login.entitys.Usuario;
import com.spring.login.repositorys.UsuarioRepository;

@Service
public class UsuarioService implements UserDetailsService{
	
	@Autowired
	UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = buscarPorEmail(username);	
		return new User(
				usuario.getEmail(),
				usuario.getSenha(),
				AuthorityUtils.createAuthorityList(getAuthorites(usuario.getPerfis())) //aguarda um vetor de arrays
		);
	}
	
	//conveter no vetor de strings
	private String[] getAuthorites(List<Perfil> perfis) {
		String[] authorites = new String[perfis.size()];
		for(int i = 0; i < perfis.size(); i++) {
			authorites[i] = perfis.get(i).getDesc();
		}
		return authorites;		
	}
}
