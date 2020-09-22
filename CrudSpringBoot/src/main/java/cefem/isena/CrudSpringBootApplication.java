package cefem.isena;

import java.io.File;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import cefem.isena.controlador.EntradaControlador;

@SpringBootApplication
@ComponentScan({"cefem.isena","controlador"})
public class CrudSpringBootApplication {

	public static void main(String[] args) {
		new File(EntradaControlador.uploadDirectory).mkdir();
		SpringApplication.run(CrudSpringBootApplication.class, args);
	}

}
