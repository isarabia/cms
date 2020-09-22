package cefem.isena.controlador;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import cefem.isena.dominio.Entrada;
import cefem.isena.servicio.EntradaServicio;

@Controller
@RequestMapping
public class EntradaControlador {
	
	public static String uploadDirectory = System.getProperty("user.dir")+"/JavaUploads";
	
	@Autowired
	private EntradaServicio service;
	
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Entrada>entradas=service.listar();
		model.addAttribute("entradas", entradas);
		return "index";
	}
	
	@GetMapping("/nuevo")
	public String agregar(Model model) {
		model.addAttribute("entrada", new Entrada());
		return "crearEntrada";
	}
	
	@PostMapping("/guardar")
	public String save(@Valid Entrada p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Entrada>entrada=service.listarId(id);
		model.addAttribute("entrada", entrada);
		return "crearEntrada";
	}
	
	@GetMapping("eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	@RequestMapping("/subir")
	public String UploadPage(Model model) {
		return "uploadview";
	}
	
	@RequestMapping("/upload")
	public String upload(Model model,@RequestParam("files") MultipartFile[] files) {
		StringBuilder fileNames = new StringBuilder();
		for (MultipartFile file : files) {
			Path fileNameAndPath = Paths.get(uploadDirectory,file.getOriginalFilename());
			fileNames.append(file.getOriginalFilename() + " ");
			try {
				Files.write(fileNameAndPath,file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		model.addAttribute("msg", "Successfully upload files " + fileNames.toString());
			return "uploadstatusview";
	}

}
