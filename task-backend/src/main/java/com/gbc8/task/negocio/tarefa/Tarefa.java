package com.gbc8.task.negocio.tarefa;

import com.gbc8.task.util.TarefaDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Tarefa")
public class Tarefa {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	@Column(name = "TITULO", nullable = false)
	private String titulo;
	@Column(name = "DESCRICAO", nullable = false)
	private String descricao;
	@Column(name = "STATUS", nullable = false)
	private String status;
	@Column(name = "img")
	private String imgPath;
	
	public Tarefa(Long id, TarefaDTO item) {
		this.id = id;
		this.titulo = item.getTitulo();
		this.descricao = item.getDescricao();
		this.status = item.getStatus();
		this.imgPath = item.getImgPath();
	}
}
