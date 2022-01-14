package com.restapi.logapi.logApi.api.controller;

import com.restapi.logapi.logApi.api.model.DestinatarioModel;
import com.restapi.logapi.logApi.api.model.EntregaModel;
import com.restapi.logapi.logApi.domain.model.Entrega;
import com.restapi.logapi.logApi.domain.repository.EntregaRepository;
import com.restapi.logapi.logApi.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private ModelMapper modelMapper;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@Valid @RequestBody Entrega entrega){
        return solicitacaoEntregaService.solicitar(entrega);
    }

    @GetMapping
    public List<Entrega> listar(){
        return entregaRepository.findAll();
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId){
        return entregaRepository.findById(entregaId)
                .map(entrega -> {
                    EntregaModel entregaModel = modelMapper.map(entrega,EntregaModel.class);
                    return ResponseEntity.ok(entregaModel);
                }).orElse(ResponseEntity.notFound().build());
    }
}
