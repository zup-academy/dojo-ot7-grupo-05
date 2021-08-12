package br.com.zup.edu.nossositedeviagens.controller.form;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.validation.ExistsId;
import com.fasterxml.jackson.annotation.JsonCreator;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.time.Duration;

public class RotaForm {

    private final String nome;

    @NotNull
    @ExistsId(entityClass = Aeroporto.class, fieldName = "id")
    private final Long aeroportoOrigemId;

    @NotNull
    @ExistsId(entityClass = Aeroporto.class, fieldName = "id")
    private final Long aeroportoDestinoId;

    /**
     * Duracao em minutos
     */
    @NotNull
    @Positive
    private final Long duracao;

    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public RotaForm(String nome, Long aeroportoOrigemId, Long aeroportoDestinoId, Long duracao) {
        this.nome = nome;
        this.aeroportoOrigemId = aeroportoOrigemId;
        this.aeroportoDestinoId = aeroportoDestinoId;
        this.duracao = duracao;
    }

    public Rota toModel(AeroportoRepository aeroportoRepository) {

        Aeroporto origem = aeroportoRepository.findById(aeroportoOrigemId).orElseThrow();
        Aeroporto destino = aeroportoRepository.findById(aeroportoDestinoId).orElseThrow();
        String nomeRota = resolveNome(nome, origem, destino);

        return new Rota(nomeRota, origem, destino, Duration.ofMinutes(duracao));
    }

    private String resolveNome(String nome, Aeroporto origem, Aeroporto destino) {
        if (nome == null || nome.isEmpty()) {
            return origem.getNome() + "-" + destino.getNome();
        }

        return nome;
    }
}
