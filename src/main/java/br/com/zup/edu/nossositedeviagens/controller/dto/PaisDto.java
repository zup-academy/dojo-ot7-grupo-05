package br.com.zup.edu.nossositedeviagens.controller.dto;

import br.com.zup.edu.nossositedeviagens.model.Pais;

public class PaisDto {

    private String nome;

    public PaisDto(Pais pais){
        this.nome = pais.getNome();
    }
}
