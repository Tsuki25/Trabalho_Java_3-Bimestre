package com.springWeb.project.model;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
public class Jogadores {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	
	@Column(nullable = false)//DIZ QUE NÃO O CAMPO NÃO PODE ESTAR VAZIO
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@ManyToOne
	@JoinColumn(name = "time_id")
	@JsonBackReference
	private Time time;
	
	
	public Jogadores() {
		
	}

	public Jogadores(Long id_user, String nome, String email, String senha, Time time) {
		this.id_user = id_user;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.time = time;
	}

	public Jogadores(String nome, String email, String senha) {
		super();
		this.nome = nome;
		this.email = email;
		this.senha = senha;
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}
	
	

	
}
