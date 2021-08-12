package br.com.zup.edu.nossositedeviagens.controller;

import br.com.zup.edu.nossositedeviagens.controller.dto.PaisDto;
import br.com.zup.edu.nossositedeviagens.controller.form.RotaForm;
import br.com.zup.edu.nossositedeviagens.model.Rota;
import br.com.zup.edu.nossositedeviagens.repository.AeroportoRepository;
import br.com.zup.edu.nossositedeviagens.repository.RotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;

@RestController
@RequestMapping("/rotas")
public class RotaController {

    @Autowired
    private RotaRepository rotaRepository;

    @Autowired
    private AeroportoRepository aeroportoRepository;

    @Transactional
    @PostMapping("/cadastrar")
    public ResponseEntity<Void> cadastrar(@Valid @RequestBody RotaForm rotaForm) {

        Rota rota = rotaForm.toModel(aeroportoRepository);
        rotaRepository.save(rota);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(rota.getId()).toUri();

        return ResponseEntity.created(uri).build();
    }
}
