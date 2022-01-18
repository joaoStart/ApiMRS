package com.restapi.logapi.logApi.domain.service;

import com.restapi.logapi.logApi.domain.exception.EntidadeNaoEncontradaException;
import com.restapi.logapi.logApi.domain.exception.NegocioException;
import com.restapi.logapi.logApi.domain.model.Entrega;
import com.restapi.logapi.logApi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId){
        return entregaRepository.findById(entregaId)
                .orElseThrow(()-> new EntidadeNaoEncontradaException("Entrega não encontrada."));
    }
}
