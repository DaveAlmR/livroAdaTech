package com.projetinho.livrinho.controller;

import com.projetinho.livrinho.model.Categoria;
import com.projetinho.livrinho.model.Livrinho;
import com.projetinho.livrinho.services.LivrinhoService;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/livros")
public class LivrinhoController extends GenericController<Livrinho, LivrinhoService> {
    public LivrinhoController() {
        super.logger = LoggerFactory.getLogger(LivrinhoController.class);
    }
}
