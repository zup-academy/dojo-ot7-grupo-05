package br.com.zup.edu.nossositedeviagens.controller.form;

import model.Pais;

import javax.validation.constraints.NotBlank;

public class PaisForm {
    @NotBlank
    private String nome;

    public Pais toModel() {
        return new Pais(this.nome);
    }
}
