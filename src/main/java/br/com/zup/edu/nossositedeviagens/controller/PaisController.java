package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.form.PaisForm;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;
import br.com.zup.edu.nossositedeviagens.model.Pais;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/pais")
public class PaisController {
    @Autowired
    private PaisRepository paisRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<PaisDto> cadastrar(@RequestBody @Validated PaisForm form){
        Pais pais = form.toModel();
        paisRepository.save(pais);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pais.getId()).toUri();
        return ResponseEntity.created(uri).body(new PaisDto(pais));
    }
}
