package br.com.zup.edu.nossositedeviagens.controller.dto;

import br.com.zup.edu.nossositedeviagens.model.Companhia;

public class CompanhiaDto {

    private String nome;
    private String nomePais;

    public CompanhiaDto(Companhia companhia) {
        this.nome = companhia.getNome();
        this.nomePais = companhia.getPais().getNome();
    }

    public String getNome() {
        return nome;
    }

    public String getNomePais() {
        return nomePais;
    }
}
