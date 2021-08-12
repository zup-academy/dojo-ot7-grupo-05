package br.com.zup.edu.nossositedeviagens.controller;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.edu.nossositedeviagens.controller.form.AeroportoForm;
import br.com.zup.edu.nossositedeviagens.model.Aeroporto;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

@RestController
@RequestMapping("/aeroportos")
public class AeroportoController {
	
    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid AeroportoForm form){
        Aeroporto aeroporto = form.toModel(paisRepository);
        aeroportoRepository.save(aeroporto);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(aeroporto.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }
}
