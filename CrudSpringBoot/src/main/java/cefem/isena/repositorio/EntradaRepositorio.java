package cefem.isena.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cefem.isena.dominio.Entrada;

@Repository
public interface EntradaRepositorio extends CrudRepository<Entrada, Integer>{

}
