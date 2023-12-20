package com.gbc8.task.dados.tarefa;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gbc8.task.controlador.exception.NotFoundException;
import com.gbc8.task.dados.IRepositorio;
import com.gbc8.task.negocio.tarefa.Tarefa;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class RepositorioTarefa implements IRepositorio<Tarefa>{
	
	@Autowired
	private RepositorioJpaTarefa repositorioProduto;

	@Override
	public List<Tarefa> getAll() {
		return repositorioProduto.findAll();
	}

	@Override
	public Tarefa getById(Long id) throws NotFoundException {
		try {
			Optional<Tarefa> produto = repositorioProduto.findById(id);
			if(produto.isEmpty()) {
				throw new NotFoundException("Produto inexistente.");
			}
			return produto.get();
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error){
			log.error("Erro na busca do produto de id " + id + ":", error.getMessage());
			return null;
		}
	}

	@Override
	public Tarefa inserir(Tarefa item) {
		try {
			Tarefa produto = repositorioProduto.save(item);
			return produto;
		} catch(Exception error) {
			log.error("Erro na insercao de produto:", error.getMessage());
			return null;
		}
	}

	@Override
	public void delete(Long id) throws NotFoundException {
		try {
			if(getById(id) != null) {
				repositorioProduto.deleteById(id);
			}
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error) {
			log.error("Erro na remocao do produto de id " + id +  ":", error.getMessage());
		}
	}

	@Override
	public Tarefa atualizar(Tarefa item) throws NotFoundException {
		try {
			if(getById(item.getId()) != null) {
				Tarefa produto = repositorioProduto.save(item);
				return produto;
			}
		}catch(NotFoundException error) {
			throw error;
		}catch(Exception error) {
			log.error("Erro na atualizacao do produto de id " + item.getId() + ":", error.getMessage());
			return null;
		}
		return null;
	}
}