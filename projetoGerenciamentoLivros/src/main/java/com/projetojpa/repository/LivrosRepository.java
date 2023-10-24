package com.projetojpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetojpa.entities.Livros;

public interface LivrosRepository extends JpaRepository<Livros, Long> {

}
