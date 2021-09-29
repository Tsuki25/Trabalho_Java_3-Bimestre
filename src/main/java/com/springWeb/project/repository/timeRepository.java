package com.springWeb.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springWeb.project.model.Time;

@Repository //REPONSAVEL POR INTERAGIS COM O BANCO
public interface timeRepository extends JpaRepository<Time, Long>{
	//OS METODOS SÃO GERADOS EM TEMPO DE EXECUÇÃO, ENTÃO NÃO É NECESSÁRIO IMPLEMENTA-LO AQUI
}
