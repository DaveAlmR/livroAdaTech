package com.projetinho.livrinho.controller;

import com.projetinho.livrinho.model.Aluguel;
import com.projetinho.livrinho.model.Livrinho;
import com.projetinho.livrinho.services.AluguelService;
import com.projetinho.livrinho.services.LivrinhoService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/alugueis")
public class AluguelController extends GenericController<Aluguel, AluguelService> {
    public AluguelController() {
        super.logger = LoggerFactory.getLogger(AluguelController.class);
    }
}
