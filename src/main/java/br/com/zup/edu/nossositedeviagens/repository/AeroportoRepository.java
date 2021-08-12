package br.com.zup.edu.nossositedeviagens.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.edu.nossositedeviagens.model.Aeroporto;

public interface AeroportoRepository extends JpaRepository<Aeroporto, Long> {
}
