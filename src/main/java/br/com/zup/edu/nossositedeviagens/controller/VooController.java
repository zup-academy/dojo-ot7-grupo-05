package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import br.com.zup.edu.nossositedeviagens.repository.VooRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/v1.0/voos")
public class VooController {

    @Autowired
    private VooRepository vooRepository;

    @Autowired
    private RotaRepository rotaRepository;

    @PostMapping
    public ResponseEntity<?> cadastrar(@Valid @RequestBody VooForm vooForm){

        Voo voo = vooForm.toModel(rotaRepository);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(voo.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
