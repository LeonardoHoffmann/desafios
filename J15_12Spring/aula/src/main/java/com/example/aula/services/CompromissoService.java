package com.example.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Compromisso;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.exceptions.ValidaDadosException;
import com.example.aula.repositories.CompromissosRepository;

@Service
public class CompromissoService {

	@Autowired
	CompromissosRepository repo;
	
	public Compromisso consultar(Long idcompromisso) {
		Optional<Compromisso> opt = repo.findById(idcompromisso);
		Compromisso cm = opt.orElseThrow(() -> new RecursoNaoEncontrado("Compromisso não encontrado."));
		return cm;						
	}
	
	public void excluir(Long id) {
		Compromisso cm = consultar(id);
		repo.delete(cm);
	}
	
	public Compromisso salvar(Compromisso compromisso) {
		validaCampos(compromisso);
		return repo.save(compromisso);
	}
	
	public Compromisso alterar(Long idCompromisso, Compromisso compromisso) {
		Compromisso cm = consultar(idCompromisso);
		validaCampos(compromisso);
		cm = compromisso;
		return repo.save(cm);
	}
	
	private void validaCampos(Compromisso compromisso) {
		if(compromisso.getDescricao().equals("")) {
			throw new ValidaDadosException("A Descricao deve ser informada");
		}
		if(compromisso.getData().equals("")) {
			throw new ValidaDadosException("A Data deve ser informada");
		}
		
		if(compromisso.getHora() == null ) {
			throw new ValidaDadosException("A Hora deve ser informada");
		}
		else {
			if(compromisso.getHora().equals("")) {
				throw new ValidaDadosException("O fone deve ser informado");
			}
		}
	}
	
	
}