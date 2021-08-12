package br.com.zup.edu.nossositedeviagens.model;

import br.com.zup.edu.nossositedeviagens.util.TipoRota;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

@Entity
public class Voo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private List<RotaDeVoo> rotaDeVoo;
}
