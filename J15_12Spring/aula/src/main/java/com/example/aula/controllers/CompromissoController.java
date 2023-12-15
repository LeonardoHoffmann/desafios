package com.example.aula.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.entidades.Compromisso;
import com.example.aula.entidades.Contato;
import com.example.aula.entidades.Local;
import com.example.aula.repositories.CompromissosRepository;
import com.example.aula.services.CompromissoService;
import com.example.aula.services.ContatoService;
import com.example.aula.services.LocalService;

@RestController
@RequestMapping("/compromissos") /*http://localhost:8080*/
public class CompromissoController {
	List<Compromisso> compromissos = new ArrayList<>();
	
	@Autowired
	CompromissosRepository repo;
	
	@Autowired
	CompromissoService service;
	
	@Autowired
    ContatoService serviceContato;
	
	@Autowired
	LocalService serviceLocal;
	
	@PostMapping
	public ResponseEntity<Compromisso> salvar(@RequestBody Compromisso compromisso) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(compromisso));
	}
	
	@PutMapping("/{idcompromisso}")
	public ResponseEntity<Object> alterar(@PathVariable("idcompromisso") Long idcompromisso,
		@RequestBody Compromisso compromisso) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idcompromisso, compromisso));
	}
	
	@DeleteMapping("/{idcompromisso}")
	public ResponseEntity<?> excluir(@PathVariable("idcompromisso") Long idcompromisso) {
		service.excluir(idcompromisso);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping
    public ResponseEntity<List<Compromisso>> getAll(){
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
    }
    
    @GetMapping("/contato")
    public ResponseEntity<List<Compromisso>> getAllByContato(@RequestParam("idcontato") Long id){
    	Contato contato = serviceContato.consultar(id);
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAllByContato(contato));
    }
	
    @GetMapping("/local")
    public ResponseEntity<List<Compromisso>> getAllByLocal(@RequestParam("idlocal") Long id){
    	Local local = serviceLocal.consultar(id);
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAllByLocal(local));
    }
	
	/*@GetMapping("/{idcompromisso}")
	public ResponseEntity<Object> consultar(@PathVariable("idcompromisso") Long idcompromisso) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idcompromisso));
	}*/
    
    @GetMapping("/data")
    public ResponseEntity<List<Compromisso>> getAllByData(@RequestParam("data")
    @DateTimeFormat(pattern = "dd-MM-yyyy") Date data){
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAllByData(data));
    }
    
    @GetMapping("/intervalo-data")
    public ResponseEntity<List<Compromisso>> getAllByIntervaloData(
    		@RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataInicio,
            @RequestParam  @DateTimeFormat(pattern = "dd-MM-yyyy") Date dataFim){
    	return ResponseEntity.status(HttpStatus.OK).body(repo.findAllByEntreDatas(dataInicio, dataFim));
    }
}