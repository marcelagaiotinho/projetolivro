package com.senai.GerenciamentoDeLivros.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LivroService {
	private final LivroRepository livrorepository;

	@Autowired
	public livroService(LivroRepository livroRepository) {
		this.livroRepository = livroRepository;
	}

	public Livro savelivro(Livro livro) {
		return livrorepository.save(livro);
	}

	public Livro getJogoByid(Long id) {
		return repository.findById(id).orElse(null);
	}

	public List<Jogo> getAlljogo(){
		return jogorepository.findAll();
	}

	public void deleteJogo(Long id) {
		jogorepository.deleteById(id);
	}
	// fazendo o update do jogo com o optional
		public Jogo updateJogo(Long id, Jogo novoJogo) {
	        Optional<Jogo> jogoOptional = jogorepository.findById(id);
	        if (jogoOptional.isPresent()) {
	        	Jogo jogoExistente = jogoOptional.get();
	           	jogoExistente.setName(novoJogo.getName());
	        	jogoExistente.setPlataform(novoJogo.getPlataform());          
	            return jogorepository.save(jogoExistente); 
	        } else {
	            return null; 
	        }
	    }
}