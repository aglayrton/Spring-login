package com.spring.entitys;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "perfis")
public class Perfil implements Serializable{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "descricao", nullable = false, unique = true)
	private String desc;

	public Perfil(Long id) {
		this.id = id;
	}

	public Perfil() {
	}

	public Long getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
	
	
	
	
}
