package com.krakedev.clientes.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

//Para decirle a SprigBoot que este es un controlador usamos @RestController
@RestController

//aqui creamos los metodos y las rutas para poner como acceder a los metodos que creamos  crear, editar, eliminar y listar
@RequestMapping("/clientes")  //esto define la URL base para todas las clases
public class ClienteController {
	//aqui instanciamos una clase Servicio CLiente para poder llamar a los metodos de la clase ServicioCliente
	private final ServicioCliente servicioCliente = new ServicioCliente();
	
	//Definir la ruta para crear un cliente
	//Postmaping se usa para crear, el request le dice a sprint que combierta el json del cuerpo a un objeto cliente 
	@PostMapping
	public Cliente crear(@RequestBody Cliente cliente) {
		return servicioCliente.crear(cliente);
	}
	
	@GetMapping
	public List<Cliente> listar(){
		return servicioCliente.listar();
	}
	
	@GetMapping("/{cedula}")	
	public Cliente buscar(@PathVariable String cedula) {
		return servicioCliente.buscarPorCedula(cedula);
	}
	
	//crear el metodo put para actualizar los recursos que ya tenemos
	@PutMapping("/{cedula}")
	public Cliente actualizar(@PathVariable String cedula, @RequestBody Cliente clienteActualizado) {
		return servicioCliente.actualizar(cedula, clienteActualizado);
	}
	
	//crear el metodo eliminar
	@DeleteMapping("/{cedula}")
	public boolean eliminar(@PathVariable String cedula) {
		return servicioCliente.eliminar(cedula);
	}
	
	
	
}
