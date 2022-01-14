package com.restapi.logapi.logApi.domain.service;

import com.restapi.logapi.logApi.domain.exception.NegocioException;
import com.restapi.logapi.logApi.domain.model.Cliente;
import com.restapi.logapi.logApi.domain.model.Entrega;
import com.restapi.logapi.logApi.domain.model.StatusEntrega;
import com.restapi.logapi.logApi.domain.repository.ClienteRepository;
import com.restapi.logapi.logApi.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega){
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(OffsetDateTime.now());

        return entregaRepository.save(entrega);
    }
}
