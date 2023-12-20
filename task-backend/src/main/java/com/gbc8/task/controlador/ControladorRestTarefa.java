package com.gbc8.task.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gbc8.task.controlador.exception.NotFoundException;
import com.gbc8.task.negocio.IFachada;
import com.gbc8.task.negocio.tarefa.Tarefa;
import com.gbc8.task.util.TarefaDTO;

import jakarta.validation.Valid;

@CrossOrigin()
@RestController
@RequestMapping("/api/tarefa")
public class ControladorRestTarefa {
	
	private IFachada fachada;
	
	@Autowired
	public ControladorRestTarefa(IFachada fachada) {
		this.fachada = fachada;
	}
	
	@GetMapping("")
	public ResponseEntity<List<Tarefa>> getAll() {
		return ResponseEntity.ok().body(fachada.getAll());
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Tarefa> getById(@PathVariable Long id) throws NotFoundException {
		return ResponseEntity.ok().body(fachada.getById(id));
	}
	
	@PostMapping("")
	public ResponseEntity<Tarefa> inserirTarefa(@RequestBody @Valid TarefaDTO produto){
		return ResponseEntity.ok().body(fachada.inserir(produto));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Tarefa> atualizarTarefa(@RequestBody @Valid TarefaDTO tarefaDTO, @PathVariable Long id) throws NotFoundException{
		return ResponseEntity.ok().body(fachada.atualizar(tarefaDTO, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) throws NotFoundException{
		fachada.delete(id);
		return ResponseEntity.noContent().build();
	}

}