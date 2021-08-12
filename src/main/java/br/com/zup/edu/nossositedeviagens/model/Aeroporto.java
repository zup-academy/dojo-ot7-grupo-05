package br.com.zup.edu.nossositedeviagens.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Aeroporto {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank
    @Column(unique=true)
    private String nome;
    
    private LocalDateTime instanteCriacao = LocalDateTime.now();
    
    @ManyToOne
    @NotNull
    private Pais pais;
    
    public Aeroporto() {
    	
    }

	public Aeroporto(@NotBlank String nome, @NotNull Pais pais) {
		super();
		this.nome = nome;
		this.pais = pais;
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public LocalDateTime getInstanteCriacao() {
		return instanteCriacao;
	}

	public Pais getPais() {
		return pais;
	}
     
}
