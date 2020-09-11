package cefem.isena.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import cefem.isena.modelo.Persona;

@Repository
public interface IPersona extends CrudRepository<Persona, Integer>{

}
