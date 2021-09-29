package com.springWeb.project.model;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Time {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "time_id")
	private Long time_id;
	
	@Column(nullable = false)//DIZ QUE NÃO O CAMPO NÃO PODE ESTAR VAZIO
	private String nome;
	
	@Column(nullable = false)
	private String tag;
	
	@JsonIgnoreProperties("time")//EMPEDE QUE O BANCO FIQUE EM UM LOOP INFINITO, IGNORANDO A INFORMAÇÃO QUE ENCONTRAR DE NOVO
	@OneToMany (mappedBy = "time", cascade = CascadeType.ALL)
	private List<Jogadores> jogadores;

	
	public void add_jogador(Jogadores jogador) {
		jogadores.add(jogador);
	}
	
	public Time(String nome, String tag) {
		this.nome=nome;
		this.tag =tag;
	}

	public Time(Long time_id, String nome, String tag, List<Jogadores> jogadores) {
		this.time_id = time_id;
		this.nome = nome;
		this.tag = tag;
		this.jogadores = jogadores;
	}

	public Time() {
	}

	public Long getTime_id() {
		return time_id;
	}

	public void setTime_id(Long time_id) {
		this.time_id = time_id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<Jogadores> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogadores> jogadores) {
		this.jogadores = jogadores;
	}
	
	
	
	

}
