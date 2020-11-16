package com.spring.login.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.login.entitys.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("select u from Usuario u where u.email like :email")
	public Usuario findByEmail(String email);
	
	
}
