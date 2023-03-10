package com.projetinho.livrinho.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Builder
public class Pessoa extends IBaseObject{
    private Long id;
    private String name;
    private String address;
    private String phone;
}
