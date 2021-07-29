package br.com.zup.edu.nossositedeviagens.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zup.edu.nossositedeviagens.controller.form.CompanhiaForm;
import br.com.zup.edu.nossositedeviagens.model.Companhia;
import br.com.zup.edu.nossositedeviagens.repository.PaisRepository;

@RestController
@RequestMapping("/companhias")
public class CompanhiaController {
    @Autowired
    private PaisRepository paisRepository;


    @PostMapping("/cadastrar")
    public ResponseEntity<CompanhiaDto> cadastrar(@RequestBody @Validated CompanhiaForm form){
        Companhia companhia = form.toModel();
        companhiaRepository.save(companhia);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(companhia.getId()).toUri();
        return ResponseEntity.created(uri).body(new CompanhiaDto(companhia));
    }
}
