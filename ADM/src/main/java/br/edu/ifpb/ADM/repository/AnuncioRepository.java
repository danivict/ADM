package br.edu.ifpb.ADM.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.edu.ifpb.ADM.model.AnuncioModel;

@Repository
public interface AnuncioRepository extends CrudRepository<AnuncioModel, Long> {

}