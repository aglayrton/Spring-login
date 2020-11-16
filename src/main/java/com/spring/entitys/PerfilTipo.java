package com.spring.entitys;

public enum PerfilTipo {
	
	//CRIADO O ENUM COM CHAVE E VALOR
	ADMIN(1, "ADMIN"), PROFESSOR(2, "PROFESSOR"), ALUNO(3, "ALUNO");
	
	//O CONSTRUTOR VAI RECEBER A CHAVE E VALOR JÁ DE INICIO, EXEMPLO: 1, ADMIN
	PerfilTipo(int i, String string) {
		
		this.codigo = i;
		this.descricao = string;
	
	}
	
	private long codigo;
	private String descricao;
	
	// SERÃO SOMENTE GETTERS PARA PASSARMOS ESSES ENUMS PARA A ENTIDADE USUARIOS
	
	public long getCodigo() {
		return codigo;
	}
	public String getDescricao() {
		return descricao;
	}

	
}
