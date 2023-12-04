package br.edu.ifpb.ADM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ADM.model.AnuncioModel;
import br.edu.ifpb.ADM.model.RespostaModelo;
import br.edu.ifpb.ADM.repository.AnuncioRepository;

@Service
public class AnuncioService {

    @Autowired
    private AnuncioRepository ar;

    @Autowired
    private RespostaModelo rm;

    // metodo para cadastrar ou alterar anuncios
    public ResponseEntity<?> cadastrarAlterar(AnuncioModel am, String acao) {
        if (am.getTitulo().equals("")) {
            rm.setMensagem("O título do anuncio é obrigatório!");
            return new ResponseEntity<RespostaModelo>(rm, HttpStatus.BAD_REQUEST);
        } else {
            if (acao.equals("cadastrar")) {
                return new ResponseEntity<AnuncioModel>(ar.save(am), HttpStatus.CREATED);
            } else {
                return new ResponseEntity<AnuncioModel>(ar.save(am), HttpStatus.OK);
            }
        }

    }

    public Iterable<AnuncioModel> listar() {
        return ar.findAll();
    }

    // metodo para remover produtos
    public ResponseEntity<RespostaModelo> remover(long id) {
        ar.deleteById(id);
        rm.setMensagem("O anuncio foi removido com sucesso!");
        return new ResponseEntity<RespostaModelo>(rm, HttpStatus.OK);
    }
}
