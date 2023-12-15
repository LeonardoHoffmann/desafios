package com.example.aula.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.aula.entidades.Local;
import com.example.aula.exceptions.RecursoNaoEncontrado;
import com.example.aula.exceptions.ValidaDadosException;
import com.example.aula.repositories.LocalRepository;

@Service
public class LocalService {

	@Autowired
	LocalRepository repo;
	
	public Local consultar(Long idlocal) {
		Optional<Local> opt = repo.findById(idlocal);
		Local lc = opt.orElseThrow(() -> new RecursoNaoEncontrado("Local não encontrado."));
		return lc;					
	}
	
	public void excluir(Long id) {
		Local lc = consultar(id);
		repo.delete(lc);
	}
	
	public Local salvar(Local local) {
		/*fazer validações*/
		validaCampos(local);
		return repo.save(local);
	}
	
	public Local alterar(Long idLocal, Local local) {
		Local lc = consultar(idLocal);
		validaCampos(local);
		lc = local;
		return repo.save(lc);
	}
	
	private void validaCampos(Local local) {
		if(local.getNome().equals("")) {
			throw new ValidaDadosException("O nome deve ser informado");
		}
		if(local.getRua().equals("")) {
			throw new ValidaDadosException("A Rua deve ser informada");
		}
		if(local.getBairro().equals("")) {
			throw new ValidaDadosException("O Bairro deve ser informado");
		}
		if(local.getCidade().equals("")) {
			throw new ValidaDadosException("A Cidade deve ser informada");
		}
		if(local.getEstado().equals("")) {
			throw new ValidaDadosException("O Estado deve ser informado");
		}
		if(local.getCep().equals("")) {
			throw new ValidaDadosException("O CEP deve ser informado");
		}
		
		if (local.getNumero() <= 0) {
	        throw new ValidaDadosException("O Numero deve ser informado");
	    }
	}
}