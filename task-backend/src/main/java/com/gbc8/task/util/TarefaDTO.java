package com.gbc8.task.util;

import com.gbc8.task.negocio.tarefa.Tarefa;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TarefaDTO {
	@NotBlank(message = "O campo titulo deve ser diferente dos valores: null e vazio.")
	private String titulo;
	@NotBlank(message = "O campo descricao deve ser diferente dos valores: null e vazio.")
	private String descricao;
	private String status;
	private String imgPath;
	
	public TarefaDTO(Tarefa tarefa) {
		this.titulo = tarefa.getTitulo();
		this.descricao = tarefa.getDescricao();
		this.status = tarefa.getStatus();
		this.imgPath = tarefa.getImgPath();
	}
}