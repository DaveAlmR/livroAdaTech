package com.projetinho.livrinho.controller;

import com.projetinho.livrinho.model.Livrinho;
import com.projetinho.livrinho.model.Pessoa;
import com.projetinho.livrinho.services.LivrinhoService;
import com.projetinho.livrinho.services.PessoaService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/pessoas")
public class PessoaController extends GenericController<Pessoa, PessoaService> {
    public PessoaController() {
        super.logger = LoggerFactory.getLogger(PessoaController.class);
    }
}
