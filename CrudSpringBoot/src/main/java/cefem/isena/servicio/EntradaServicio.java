package cefem.isena.servicio;

import java.util.List;
import java.util.Optional;

import cefem.isena.dominio.Entrada;

public interface EntradaServicio {

	public List<Entrada>listar();
	public Optional<Entrada>listarId(int id);
	public int save(Entrada p);
	public void delete(int id);
}
