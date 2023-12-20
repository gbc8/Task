package com.gbc8.task.dados.tarefa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gbc8.task.negocio.tarefa.Tarefa;

public interface RepositorioJpaTarefa extends JpaRepository<Tarefa, Long>{

}
 