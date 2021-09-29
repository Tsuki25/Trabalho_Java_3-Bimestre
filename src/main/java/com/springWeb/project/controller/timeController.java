package com.springWeb.project.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.springWeb.project.model.Jogadores;
import com.springWeb.project.model.Time;
import com.springWeb.project.service.jogadorService;
import com.springWeb.project.service.timeService;


@RestController
public class timeController {
	
	private static final Logger log = LoggerFactory.getLogger(timeController.class);
	
	@Autowired //RECEBE OS METODOS DO REPOSITORIO, POR CONTA DA INSTANCIA EM TEMPO DE EXECUÇÃO DO JPA
	private timeService Time_Service;
	
	@Autowired
	private jogadorService Jogador_Service;
	
	@GetMapping("/time") //END-POINT 01 -> GET -> Retorna todos os times existentes -> FUNCIONANDO
	public List<Time> listar(){
		return Time_Service.get_times();
	}
	
	@PostMapping("/time/criar") //END-POINT 02 -> POST -> Criar um novo time -> FUNCIONANDO
	@ResponseStatus(HttpStatus.CREATED)//Faz com que o codigo http retornado seja o 201(ok e objeto criado) e não o 200(ok)
	public Time addTime(@RequestBody Time time) {
		return Time_Service.addTime(time);
	}
	
	@DeleteMapping("/time/excluir_time/{id_time}") //END-POINT 03 -> DELETE -> Apaga um time pelo id -> FUNCIONANDO
	public Time excluir_time(@PathVariable Long id) {
		if(Time_Service.get_time(id) == null){//Se não existir registro com esse id, return null
            return null;
        }
		Time aux = Time_Service.get_time(id);
		Time_Service.excluir_time(id);
        return aux;//EXIBE O TIME QUE ACABOU DE SER DELETADO
	}
	
    @PutMapping("/time/update_time/{id_time}") //END-POINT 04 -> PUT -> Altera os valores de um time pelo id -> FUNCIONANDO
    public Time update_time(@PathVariable Long id,@RequestBody Time time){
    	if(Time_Service.get_time(id) == null){//Se não existir registro com esse id, return null
            return null;
       }
    	return Time_Service.update_time(id, time);//Se existir atualize os dados
    }
    
    
    // -------------------------------------- FUNÇÕES PARA OS JOGADORES ---------------------------------------------------
    
    
    @GetMapping("/time/listar_jogadores/{id_time}") //END-POINT 05 -> GET -> Lista os usuários pertencentes ao time -> FUNCIONANDO
    public List<Jogadores> listar_jogadores(@PathVariable Long id){
    	if(Time_Service.get_time(id) == null) {
    		return null;
    	}else {
    		return Time_Service.get_time(id).getJogadores();
    	}
    }   
    
    @PostMapping("/time/{id_time}/add_jogador") //END-POINT 06 -> POST -> Cria um novo jogador e o adiciona ao time -> FUNCIONANDO
    @ResponseStatus(HttpStatus.CREATED)//Faz com que o codigo http retornado seja o 201(ok e objeto criado) e não o 200(ok)
    public Jogadores add_jogador(@PathVariable Long id, @RequestBody Jogadores jogador) {
    	if(Time_Service.get_time(id) == null) {// Se não existir registro com esse id, return null
    		return null;
    	}
    	Time aux = Time_Service.get_time(id);
    	jogador.setTime(aux);
    	jogador = Jogador_Service.saveJogador(jogador);
    	return jogador;
    }
    
    @DeleteMapping("/time/{id_jogador}/remove_jogador")//END-POINT 07 -> DELETE -> Apaga um registro de jogador do time de id = {id}
    public Jogadores deleteJogador(@PathVariable Long id){
        if(Jogador_Service.get_Jogador(id) == null){//Se não existir registro com esse id, return null
            return null;
        }
        Jogadores aux = Jogador_Service.get_Jogador(id);
        Jogador_Service.excluir_Jogador(id);
        return aux;//EXIBE O JOGADOR QUE ACABOU DE SER DELETADO
    }
    
    @PutMapping("/time/{id_jogador}/alterar_jogador")//END-POINT 08 -> PUT -> Atualiza os dados de um jogador pertencente ao time de id = {id}
    public Jogadores putJogador(@PathVariable Long id, @RequestBody Jogadores jogador){
        if(Jogador_Service.get_Jogador(id) == null){//Se não existir registro com esse id, return null
             return null;
        }
        return Jogador_Service.update_Jogador(id, jogador);
    }    
}
