package com.restapi.logapi.logApi.api.controller;

import com.restapi.logapi.logApi.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClienteController {

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        var cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Joao");
        cliente1.setEmail("joao@gmail.com");
        cliente1.setTelefone("09878");

        var cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("maria");
        cliente2.setEmail("maria@gmail.com");
        cliente2.setTelefone("098780987");

        return Arrays.asList(cliente1,cliente2);
    }
}
