package com.springWeb.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb.project.model.Jogadores;
import com.springWeb.project.repository.jogadoresRepository;


@Service
public class jogadorService {
	@Autowired //RECEBE OS METODOS DO REPOSITORIO, POR CONTA DA INSTANCIA EM TEMPO DE EXECUÇÃO DO JPA
	private jogadoresRepository Jogador_Repository;
	
	public List<Jogadores> get_Jogadors(){
		return Jogador_Repository.findAll();
	}
	
	public Jogadores get_Jogador(long id){
        Optional<Jogadores> Jogador = Jogador_Repository.findById(id);
        return Jogador.get();
    }
	
	public Jogadores saveJogador(Jogadores jogador) {
		jogador.getTime().add_jogador(jogador);//ADICIONA A LISTA DE JOGADORES DO TIME 
		return Jogador_Repository.save(jogador);
	}
	
	public void excluir_Jogador(Long id) {
		Jogador_Repository.deleteById(id);//Apaga o Jogador do repositorio
	}
	
    public Jogadores update_Jogador(Long id, Jogadores jogador){
    	Jogadores aux = Jogador_Repository.findById(id).get();//Pega o registro do jogador
        aux.setNome(jogador.getNome());//Substitui os valores do registro pelos novos
        aux.setEmail(jogador.getEmail());
        aux.setSenha(jogador.getSenha());
        Jogador_Repository.save(aux);//salva os novos registros
        return jogador;
    }
}
