package com.gbc8.task.controlador;

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
	
	private final static String STATUS_CONCLUIDA = "Concluída";
	
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
	public ResponseEntity<Tarefa> inserirTarefa(@RequestBody @Valid TarefaDTO tarefa){
		tarefa.setStatus("Pendente");
		return ResponseEntity.ok().body(fachada.inserir(tarefa));
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Tarefa> concluirTarefa(@PathVariable Long id) throws NotFoundException{
		TarefaDTO tarefa = new TarefaDTO(fachada.getById(id));
		tarefa.setStatus(STATUS_CONCLUIDA);
		return ResponseEntity.ok().body(fachada.atualizar(tarefa, id));
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> deletarTarefa(@PathVariable Long id) throws NotFoundException{
		fachada.delete(id);
		return ResponseEntity.noContent().build();
	}

}