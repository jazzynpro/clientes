package com.krakedev.clientes.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.krakedev.clientes.entidades.Cliente;

@Service //esto le dice a sprimboot que es un servicio
public class ServicioCliente {
// aqui se crea una lista de clientes con un arraylist
	private ArrayList<Cliente> clientes = new ArrayList<Cliente>();
	
	//metodo buscar por cedula, es tipo cliente porque va a retornar un cliente
	public Cliente buscarPorCedula(String cedula) {
		//buscar con un for each en el ArrayList de clientes
		for(Cliente c : clientes) {
			if(c.getCedula().equals(cedula)) {
				return c;
			}
		}return null;
	}
	
	//metodo para crear el cliente y guardarlo en la lista de clientes
	public Cliente crear(Cliente cliente) {
		Cliente existente = buscarPorCedula(cliente.getCedula());
		
		if(existente != null) {
			return null;
		}else {
			clientes.add(cliente);
			return cliente;
		}
	}
	
	//metodo para retornar lista de clientes
	public List<Cliente> listar(){
		return clientes;
	} 
	
	//metodo para actualizar lista
	public Cliente actualizar(String cedula, Cliente clienteActualizado){
		Cliente cliente = buscarPorCedula(cedula);
		if(cliente != null) {
			cliente.setNombre(clienteActualizado.getNombre());
			cliente.setApellido(clienteActualizado.getApellido());
		}return cliente;
	}
	//metodo eliminar cliente
	public boolean eliminar(String cedula) {
		Cliente cliente = buscarPorCedula(cedula);
		if(cliente != null) {
			clientes.remove(cliente);
			return true;
		}else {
			return false;
		}
	}
	
}
