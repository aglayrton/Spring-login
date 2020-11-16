package com.spring.entitys;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "usuarios", indexes = {@Index(name = "idx_usuario_email", columnList="email")}) //criamos uma index além do id
public class Usuario extends AbstractEntity{
	
	//============Construtores para a coluna ID do AbstractyEntity======================//
	public Usuario() {
		super();
	}

	public Usuario(Long id) {
		super.setId(id);
	}
	
	public Usuario(String email) {
		this.email = email;
	}
	//===============================CAMPOS DA TABELA=============================================//
	@Column(name = "email", unique=true, nullable=false)
	private String email;
	
	@JsonIgnore
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "ativo", nullable = false, columnDefinition = "TINYINT(1)") //boleano
	private boolean ativo;
	
	@Column(name = "codigo_verificador", length = 6)
	private String codigoVerificador;
	
	//===========================TABELA CRIADA A PARTIR DE DUAS COLUNAS DAS TABELAS===========================
	
	@ManyToMany //1 usuario pode ter vários perfis e 1 perfil pode ter vários usuáio
	@JoinTable(//cria uma tabela
		name = "usuarios_tem_perfis",
		joinColumns = { @JoinColumn(name = "usuario_id", referencedColumnName = "id", table = "usuarios")},
		inverseJoinColumns = {@JoinColumn(name = "perfil_id", referencedColumnName = "id", table = "perfis")}
	)
	private List<Perfil> perfis;

	//MÉTODO PARA ADICIONAR PERFIS A LISTA
	public void addPerfil(PerfilTipo tipo) { 
		
		//pois se usarmos o set vai gravar uma lista de perfil, daí esse metodo grava somente 1 tipo de perfil
		
		if(this.perfis == null) {
			this.perfis = new ArrayList<>();
		}
		
		this.perfis.add(new Perfil(tipo.getCodigo())); //passamos o codigo do enum que neste 
		
	}
	
	//==================================GETTERS E SETTERS=============================================
	
	public String getEmail() {
		return email;
	}

	public String getSenha() {
		return senha;
	}

	public boolean isAtivo() {
		return ativo;
	}

	public String getCodigoVerificador() {
		return codigoVerificador;
	}

	public List<Perfil> getPerfis() {
		return perfis;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}

	public void setCodigoVerificador(String codigoVerificador) {
		this.codigoVerificador = codigoVerificador;
	}

	public void setPerfis(List<Perfil> perfis) {
		this.perfis = perfis;
	}
	
}
