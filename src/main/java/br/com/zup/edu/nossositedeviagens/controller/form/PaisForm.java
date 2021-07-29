package br.com.zup.edu.nossositedeviagens.controller.form;

import br.com.zup.edu.nossositedeviagens.model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    private String nome;

    public String getNome() {
		return nome;
	}

	public Pais toModel() {
        return new Pais(this.nome);
    }
    
    
}
