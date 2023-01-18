package com.formulario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.formulario.model.Persona;
import com.formulario.repository.PersonaRepository;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:4200/")
public class PersonaController {
	
	@Autowired
	private PersonaRepository repository;
	
	@PostMapping("/addPersona")
	public Persona guardarRed(@RequestBody Persona persona) {
		return repository.save(persona);
	}
	
	@GetMapping("/personas")
	public List<Persona> listaPersonas(){
		return repository.findAll();
	}
	
	@PutMapping("/editarPersona/{id}")
	public Persona editarPersona(@PathVariable Integer id,@RequestBody Persona persona) {
		Persona persona1 = new Persona();
		
		persona1.setId(id);
		persona1.setCc(persona.getCc());
		persona1.setNombre(persona.getNombre());
		persona1.setCelular(persona.getCelular());
		persona1.setCorreo(persona.getCorreo());
		persona1.setDireccion(persona.getDireccion());
		
		repository.save(persona1);
		
		return persona1;
	}
	
	@DeleteMapping("/deletePersona/{id}")
	public void eliminarPersona(@PathVariable Integer id) {
		repository.deleteById(id);
	}

}
