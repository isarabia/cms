package cefem.isena.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cefem.isena.dominio.Entrada;
import cefem.isena.repositorio.EntradaRepositorio;

@Service
public class EntradaServicioImpl implements EntradaServicio{

	@Autowired
	private EntradaRepositorio data;
	
	@Override
	public List<Entrada> listar() {
		return (List<Entrada>)data.findAll();
	}

	@Override
	public Optional<Entrada> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Entrada p) {
		int res=0;
		Entrada entrada=data.save(p);
		if (!entrada.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		data.deleteById(id);
	}

}
