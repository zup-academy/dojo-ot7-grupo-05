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

import br.com.zup.edu.nossositedeviagens.controller.dto.PaisDto;
import br.com.zup.edu.nossositedeviagens.controller.form.PaisForm;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

@RestController
@RequestMapping("/paises")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Valid PaisForm form){
        Pais pais = form.toModel();
        paisRepository.save(pais);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisDto(pais));
    }
}
