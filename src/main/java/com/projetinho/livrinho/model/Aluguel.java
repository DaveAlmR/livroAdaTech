package com.projetinho.livrinho.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Builder
public class Aluguel extends IBaseObject{
    private Long id;
    private Livrinho livrinho;
    private Pessoa pessoa;
    private double valor;
    private LocalDate limiteDevolucao;
    private double jurosDia;
}
