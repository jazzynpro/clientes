package com.krakedev.clientes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Anotaciones sobre la clase
@RestController

public class HolaController {

	// metodo que retorne un saludo metodo get
@GetMapping("/hola")//url desde el cual vamos a acceder
	public String saludar() {
		return "Hola desde SprinBoot";
	}
	
	//Anotaciones para que Springboot exponga a travez de rice web services
	
}
