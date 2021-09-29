package com.springWeb.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.springWeb.project.model.Jogadores;
import com.springWeb.project.service.jogadorService;

@RestController
public class jogadorController {
	@Autowired //RECEBE OS METODOS DO REPOSITORIO, POR CONTA DA INSTANCIA EM TEMPO DE EXECUÇÃO DO JPA
	private jogadorService Jogador_Service;
	
	@GetMapping("/Jogador") //END-POINT 01 -> GET -> Retorna todos os Jogadors existentes -> FUNCIONANDO
	public List<Jogadores> listar(){
		return Jogador_Service.get_Jogadors();
	}
	
	@PostMapping("/Jogador/criar") //END-POINT 02 -> POST -> Criar um novo Jogador -> FUNCIONANDO
	@ResponseStatus(HttpStatus.CREATED)//Faz com que o codigo http retornado seja o 201(ok e objeto criado) e não o 200(ok)
	public Jogadores addJogador(@RequestBody Jogadores Jogador) {
		return Jogador_Service.saveJogador(Jogador);
	}
	
	@DeleteMapping("/Jogador/excluir_Jogador/{id}") //END-POINT 03 -> DELETE -> Apaga um Jogador pelo id -> FUNCIONANDO
	public void excluir_Jogador(@PathVariable Long id) {
		Jogador_Service.excluir_Jogador(id);
	}
	
    @PutMapping("/Jogador/update_Jogador/{id}") //END-POINT 04 -> PUT -> Altera os valores de um Jogador pelo id -> FUNCIONANDO
    public Jogadores update_Jogador(@PathVariable Long id,@RequestBody Jogadores Jogador){
    	return Jogador_Service.update_Jogador(id, Jogador);
    }
}
