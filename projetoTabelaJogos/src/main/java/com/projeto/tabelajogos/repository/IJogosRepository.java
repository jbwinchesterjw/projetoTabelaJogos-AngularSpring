package com.projeto.tabelajogos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projeto.tabelajogos.domain.Jogos;

@Repository
public interface IJogosRepository extends JpaRepository<Jogos, Long>{
	
	Jogos findTopByOrderByIdDesc();

}
