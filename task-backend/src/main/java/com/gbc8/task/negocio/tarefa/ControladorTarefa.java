package com.gbc8.task.negocio.tarefa;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.task.controlador.exception.NotFoundException;
import com.gbc8.task.dados.IRepositorio;

@Component
public class ControladorTarefa {
	
	private IRepositorio<Tarefa> repositorioProduto;
	
	@Autowired
	public ControladorTarefa(IRepositorio<Tarefa> repositorioProduto) {
		this.repositorioProduto = repositorioProduto;
	}

	public List<Tarefa> getAll() {
		List<Tarefa> produtos = repositorioProduto.getAll();
		return produtos;
	}
	
	public Tarefa getById(Long id) throws NotFoundException {
		Tarefa produto = (Tarefa) repositorioProduto.getById(id);
		return produto;
	}

	public Tarefa inserir(Tarefa produto) {
		Tarefa novoProduto = (Tarefa) repositorioProduto.inserir(produto);
		return novoProduto;
	}

	public void delete(Long id) throws NotFoundException {
		repositorioProduto.delete(id);
	}

	public Tarefa atualizar(Tarefa produto) throws NotFoundException {
		Tarefa novoProduto = (Tarefa) repositorioProduto.atualizar(produto);
		return novoProduto;
	}
}
