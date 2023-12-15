package com.example.aula.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aula.entidades.Local;
import com.example.aula.repositories.LocalRepository;
import com.example.aula.services.LocalService;

@RestController
@RequestMapping("/local") /*http://localhost:8080*/
public class LocalController {
	List<Local> local = new ArrayList<>();
	
	@Autowired
	LocalRepository repo;
	
	@Autowired
	LocalService service;
	
	@PostMapping
	public ResponseEntity<Local> salvar(@RequestBody Local local) {
		return ResponseEntity.status(HttpStatus.CREATED).body(service.salvar(local));
	}
	
	@PutMapping("/{idlocal}")
	public ResponseEntity<Object> alterar(@PathVariable("idlocal") Long idlocal,
		@RequestBody Local local) {
		return ResponseEntity.status(HttpStatus.OK).body(service.alterar(idlocal, local));
	}
	
	@DeleteMapping("/{idlocal}")
	public ResponseEntity<?> excluir(@PathVariable("idlocal") Long idlocal) {
		service.excluir(idlocal);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
	
	@GetMapping
	public ResponseEntity<List<Local>> consultar() {
		return ResponseEntity.status(HttpStatus.OK).body(repo.findAll());
	}
	
	@GetMapping("/{idlocal}")
	public ResponseEntity<Object> consultar(@PathVariable("idlocal") Long idlocal) {
		return ResponseEntity.status(HttpStatus.OK).body(service.consultar(idlocal));
	}
}