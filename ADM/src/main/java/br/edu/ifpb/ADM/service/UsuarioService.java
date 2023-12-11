package br.edu.ifpb.ADM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ADM.model.UsuarioModel;
import br.edu.ifpb.ADM.model.RespostaModelo;
import br.edu.ifpb.ADM.repository.UsuarioRepository;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository ur;

    @Autowired
    private RespostaModelo rm;

    // metodo para cadastrar ou alterar usuarios
    public ResponseEntity<?> cadastrarAlterar(UsuarioModel um, String acao) {
        if (um.getNome().equals("")) {
            rm.setMensagem("O nome do usuário é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<UsuarioModel>(ur.save(um), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<UsuarioModel>(ur.save(um), HttpStatus.OK);
            }
        }

    }

    public Iterable<UsuarioModel> listar() {
        return ur.findAll();
    }

    // metodo para remover produtos
    public ResponseEntity<RespostaModelo> remover(long id) {
        ur.deleteById(id);
        rm.setMensagem("O usuário foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
