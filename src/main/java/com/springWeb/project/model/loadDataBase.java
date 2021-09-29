package com.springWeb.project.model;

import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.springWeb.project.repository.timeRepository;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;

@Configuration
public class loadDataBase {
	
	private static final Logger log = LoggerFactory.getLogger(loadDataBase.class);
	
	@Bean
	CommandLineRunner initDataBase(timeRepository repository) {
		return args->{
			
			Time time1 = new Time("String", "STR");
	        List<Jogadores> players = new ArrayList<>();
	        Jogadores jogador1 = new Jogadores("Tsuki", "tsuki.string@gmail.com","12345");
	        jogador1.setTime(time1); //necesário adicionar para sincronizar a conexão bidirecional
	        players.add(jogador1); 
	        Jogadores jogador2 = new Jogadores("fael890", "rafas.string@gmail.com","testeteste");
	        jogador2.setTime(time1); //necesário adicionar para sincronizar a conexão bidirecional
	        players.add(jogador2); 
	        time1.setJogadores(players);
	         
			log.info("Inserindo " + repository.save(time1));
		};
	}
}
