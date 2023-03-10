package com.projetinho.livrinho.controller;

import com.projetinho.livrinho.model.Categoria;
import com.projetinho.livrinho.model.Livrinho;
import com.projetinho.livrinho.services.CategoriaService;
import com.projetinho.livrinho.services.LivrinhoService;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/categorias")
public class CategoriaController extends GenericController<Categoria, CategoriaService> {
    public CategoriaController() {
        super.logger = LoggerFactory.getLogger(CategoriaController.class);
    }
}
