package br.edu.ifpb.ADM.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.ADM.model.AnuncioModel;
import br.edu.ifpb.ADM.model.RespostaModelo;
import br.edu.ifpb.ADM.service.AnuncioService;

@RestController
@CrossOrigin(origins = "*")
public class AnuncioController {

    @Autowired
    private AnuncioService as;

    @GetMapping("/listar")
    public Iterable<AnuncioModel> listar() {
        return as.listar();
    }

    @GetMapping("")
    public String rota() {
        return "API funfando";
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody AnuncioModel am) {
        return as.cadastrarAlterar(am, "cadastrar");
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> alterar(@RequestBody AnuncioModel am) {
        return as.cadastrarAlterar(am, "alterar");
    }

    @DeleteMapping("/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id) {
        return as.remover(id);
    }
}
