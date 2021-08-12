package br.com.zup.edu.nossositedeviagens.model;

import br.com.zup.edu.nossositedeviagens.util.TipoRota;

import javax.validation.constraints.NotNull;

public class RotaDeVoo {
    @NotNull
    private Rota rota;

    @NotNull
    private TipoRota tipo;

    private Long tempoParada;
}
