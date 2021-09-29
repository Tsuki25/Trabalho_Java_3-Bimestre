package com.springWeb.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springWeb.project.model.Time;
import com.springWeb.project.repository.timeRepository;

@Service
public class timeService {
	@Autowired //RECEBE OS METODOS DO REPOSITORIO, POR CONTA DA INSTANCIA EM TEMPO DE EXECUÇÃO DO JPA
	private timeRepository Time_Repository;
	
	public List<Time> get_times(){
		return Time_Repository.findAll();
	}
	
	public Time get_time(long id){
        Optional<Time> time = Time_Repository.findById(id);
        return time.get();
    }
	
	public Time addTime(Time time) {
		time.getJogadores().forEach(t -> t.setTime(time));
		return Time_Repository.save(time);
	}
	
	public void excluir_time(Long id) {
		Time_Repository.deleteById(id);
	}
	
    public Time update_time(Long id, Time time){
    	Optional<Time> aux = Time_Repository.findById(id);//Pega o time antigo
    	aux.get().getJogadores().forEach(t -> t.setTime(null));// Tira os antigos jogadores do time
    	time.setTime_id(id);//Adiciona o time do json para o id no banco
    	time.getJogadores().forEach(t -> t.setTime(time));// Adiciona os novos jogadores ao time
        return Time_Repository.save(time);
    }
    
    
}
