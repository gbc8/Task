package com.gbc8.task.negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.task.controlador.exception.NotFoundException;
import com.gbc8.task.negocio.tarefa.ControladorTarefa;
import com.gbc8.task.negocio.tarefa.Tarefa;
import com.gbc8.task.util.TarefaDTO;

@Component
public class Fachada implements IFachada {
	
	private ControladorTarefa controladorProduto;
	
	@Autowired
	public Fachada(ControladorTarefa controladorProduto) {
		this.controladorProduto = controladorProduto;
	}

	@Override
	public List<Tarefa> getAll() {
		List<Tarefa> produtos = controladorProduto.getAll();
		return produtos;
	}

	@Override
	public Tarefa getById(Long id) throws NotFoundException {
		Tarefa produto = (Tarefa) controladorProduto.getById(id);
		return produto;
	}

	@Override
	public Tarefa inserir(TarefaDTO item) {
		Tarefa novoProduto = new Tarefa(null, item);
		Tarefa produto = (Tarefa) controladorProduto.inserir(novoProduto);
		return produto;
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		controladorProduto.delete(id);
	}

	@Override
	public Tarefa atualizar(TarefaDTO item, Long id) throws NotFoundException {
		Tarefa novoProduto = new Tarefa(id, item);
		Tarefa produto = (Tarefa) controladorProduto.atualizar(novoProduto);
		return produto;
	}

}
