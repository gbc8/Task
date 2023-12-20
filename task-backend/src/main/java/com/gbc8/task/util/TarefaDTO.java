package com.gbc8.task.util;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
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
	private String imgPath;
}