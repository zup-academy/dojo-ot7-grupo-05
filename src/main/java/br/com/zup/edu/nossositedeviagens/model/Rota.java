package br.com.zup.edu.nossositedeviagens.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;

@Entity
public class Rota {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @NotNull
    @ManyToOne
    private Aeroporto aeroportoOrigem;

    @NotNull
    @ManyToOne
    private Aeroporto aeroportoDestino;

    /**
     * Duracao em minutos
     */
    @NotNull
    @Positive
    private Duration duracao;

    public Rota(String nome, Aeroporto aeroportoOrigem, Aeroporto aeroportoDestino, Duration duracao) {
        this.nome = nome;
        this.aeroportoOrigem = aeroportoOrigem;
        this.aeroportoDestino = aeroportoDestino;
        this.duracao = duracao;
    }

    public Long getId() {
        return id;
    }
}
