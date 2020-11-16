package com.spring.login.entitys;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfis")
public class Perfil extends AbstractEntity{
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String desc;

	public Perfil(Long id) {
		super.setId(id);
	}

	public Perfil() {
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
