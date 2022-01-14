package com.restapi.logapi.logApi.domain.service;

import com.restapi.logapi.logApi.domain.exception.NegocioException;
import com.restapi.logapi.logApi.domain.model.Cliente;
import com.restapi.logapi.logApi.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    public Cliente buscar(Long clienteId){
        return clienteRepository.findById(clienteId)
                .orElseThrow(()-> new NegocioException("Cliente não encontrado."));
    }

    @Transactional
    public Cliente salvar(Cliente cliente){
        boolean clienteEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteExistente -> !clienteExistente.equals(cliente));

        if (clienteEmUso){
            throw new NegocioException("Já existe um cliente cadastrado com esse e-mail.");
        }

        return clienteRepository.save(cliente);
    }

    @Transactional
    public void excluir(Long clienteId){
        clienteRepository.deleteById(clienteId);
    }
}
