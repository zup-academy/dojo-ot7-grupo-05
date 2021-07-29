package br.com.zup.edu.nossositedeviagens.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.validation.ExistsId;

public class CompanhiaForm {

	@NotBlank
	private String nome;
	
	@ExistsId(entityClass = Pais.class, fieldName = "id", message = "ID do pais não existente no banco de dados")
	@NotNull
	private Long paisId;

	public String getNome() {
		return nome;
	}

	public Long getPaisId() {
		return paisId;
	}
	
	public Companhia toModel(PaisRepository paisRepository) {
		Pais pais = paisRepository.findById(paisId).get();
		return new Companhia(this.nome, pais);
	}
}
