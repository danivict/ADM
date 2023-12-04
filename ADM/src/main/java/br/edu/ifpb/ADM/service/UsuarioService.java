package br.edu.ifpb.ADM.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.edu.ifpb.ADM.model.UsuarioModel;
import br.edu.ifpb.ADM.repository.UsuarioRepository;

@Service
public class UsuarioService {
    
    @Autowired
    private UsuarioRepository ur;

    public Iterable<UsuarioModel> listar(){
        return ur.findAll();
    }
}
