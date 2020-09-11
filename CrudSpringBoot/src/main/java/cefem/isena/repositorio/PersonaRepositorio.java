package cefem.isena.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cefem.isena.dominio.Persona;

@Repository
public interface PersonaRepositorio extends CrudRepository<Persona, Integer>{

}
