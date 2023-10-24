package com.projetojpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.projetojpa.entities.Livros;
import com.projetojpa.repository.LivrosRepository;

@Service
public class LivrosService {
    private final LivrosRepository livrosRepository;

    @Autowired
    public LivrosService(LivrosRepository livrosRepository) {
        this.livrosRepository = livrosRepository;
    }
    public List<Livros> buscaTodosLivros() {
        return livrosRepository.findAll();
    }
    public Livros buscaLivrosId(Long id) {
    	Optional <Livros> Livros = livrosRepository.findById(id);
        return Livros.orElse(null);
    }
    public Livros salvaLivros (Livros livros) {
        return livrosRepository.save(livros);
    }
    public Livros alterarLivros (Long id, Livros alterar) {
		Optional <Livros> existeLivros = livrosRepository.findById(id);
    	if (existeLivros.isPresent()) {
    		alterar.setId(id);
    		return livrosRepository.save(alterar);
    	}
    	return null;
    }
    public boolean apagarLivros(Long id) {
    	Optional <Livros> existeLivros = livrosRepository.findById(id);
    	if (existeLivros.isPresent()) {
    		livrosRepository.deleteById(id);
    		return true;
    	}
    	return false;
    }
}