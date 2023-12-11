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

import br.edu.ifpb.ADM.model.UsuarioModel;
import br.edu.ifpb.ADM.model.RespostaModelo;
import br.edu.ifpb.ADM.service.UsuarioService;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService us;

    @GetMapping("/usuarios")
    public Iterable<UsuarioModel> listar() {
        return us.listar();
    }

    @PostMapping("/usuarios/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody UsuarioModel um) {
        return us.cadastrarAlterar(um, "cadastrar");
    }

    @PutMapping("/usuarios/alterar")
    public ResponseEntity<?> alterar(@RequestBody UsuarioModel um) {
        return us.cadastrarAlterar(um, "alterar");
    }

    @DeleteMapping("/usuarios/remover/{id}")
    public ResponseEntity<RespostaModelo> remover(@PathVariable long id) {
        return us.remover(id);
    }
}
