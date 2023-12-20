package com.gbc8.task.negocio;

import java.util.List;

import com.gbc8.task.controlador.exception.NotFoundException;
import com.gbc8.task.negocio.tarefa.Tarefa;
import com.gbc8.task.util.TarefaDTO;

public interface IFachada {
	public List<Tarefa> getAll();
	public Tarefa getById(Long id) throws NotFoundException;
	public Tarefa inserir(TarefaDTO item);
	public void delete(Long id) throws NotFoundException;
	public Tarefa atualizar(TarefaDTO item, Long id) throws NotFoundException;
}
