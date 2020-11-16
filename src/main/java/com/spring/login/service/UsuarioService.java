package com.spring.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.spring.login.entitys.Usuario;
import com.spring.login.repositorys.UsuarioRepository;

@Service
public class UsuarioService implements UserDetails{
	
	@Autowired
	UsuarioRepository repository;
	
	@Transactional(readOnly = true)
	public Usuario buscarPorEmail(String email) {
		return repository.findByEmail(email);
	}
}
