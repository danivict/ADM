package br.edu.ifpb.ADM.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "anuncios")
@Getter
@Setter
public class AnuncioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String anunciante;
    private String endereco;
    private List<String> fotos;
    private double valor;
    private List<String> categorias;

}
