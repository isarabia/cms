package cefem.isena.servicio;

import java.util.List;
import java.util.Optional;

import cefem.isena.dominio.Persona;

public interface PersonaServicio {

	public List<Persona>listar();
	public Optional<Persona>listarId(int id);
	public int save(Persona p);
	public void delete(int id);
}
