package com.krakedev.clientes;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.krakedev.clientes.entidades.Cliente;
import com.krakedev.clientes.services.ServicioCliente;

class ServicioClienteTest {

    private ServicioCliente servicioCliente;

    @BeforeEach
    void setUp() {
        // Inicializa un nuevo servicio antes de cada test para aislar las pruebas
        servicioCliente = new ServicioCliente();
    }

    @Test
    void testCrearClienteExitoso() {
        // Qué se prueba: Creación de un cliente nuevo no existente previamente en la lista.
        // Resultado esperado: El método retorna el objeto Cliente creado (no nulo) y la lista incrementa su tamaño a 1.
        
        Cliente nuevoCliente = new Cliente("1723456789", "Juan", "Pérez");
        Cliente resultado = servicioCliente.crear(nuevoCliente);

        assertNotNull(resultado);
        assertEquals("1723456789", resultado.getCedula());
        assertEquals(1, servicioCliente.listar().size());
    }

    @Test
    void testCrearClienteDuplicado() {
        // Qué se prueba: Intento de agregar un cliente con una cédula que ya existe en la lista.
        // Resultado esperado: El método retorna null y el tamaño de la lista se mantiene en 1.
        
        Cliente cliente1 = new Cliente("1723456789", "Juan", "Pérez");
        Cliente clienteDuplicado = new Cliente("1723456789", "Carlos", "Gómez");

        servicioCliente.crear(cliente1);
        Cliente resultado = servicioCliente.crear(clienteDuplicado);

        assertNull(resultado);
        assertEquals(1, servicioCliente.listar().size());
    }

    @Test
    void testBuscarPorCedulaExistente() {
        // Qué se prueba: Búsqueda de un cliente que sí está registrado en la lista.
        // Resultado esperado: Retorna el objeto Cliente correspondiente a la cédula consultada.
        
        Cliente cliente = new Cliente("1723456789", "Maria", "López");
        servicioCliente.crear(cliente);

        Cliente resultado = servicioCliente.buscarPorCedula("1723456789");

        assertNotNull(resultado);
        assertEquals("Maria", resultado.getNombre());
    }

    @Test
    void testBuscarPorCedulaNoExistente() {
        // Qué se prueba: Búsqueda de un cliente por cédula cuando la lista está vacía o el cliente no existe.
        // Resultado esperado: El método retorna null.
        
        Cliente resultado = servicioCliente.buscarPorCedula("0000000000");

        assertNull(resultado);
    }

    @Test
    void testListarClientes() {
        // Qué se prueba: Obtención de la lista completa de clientes registrados.
        // Resultado esperado: La lista retorna exactamente la cantidad de elementos agregados (2).
        
        servicioCliente.crear(new Cliente("1711111111", "Ana", "Torres"));
        servicioCliente.crear(new Cliente("1722222222", "Luis", "Ramírez"));

        List<Cliente> lista = servicioCliente.listar();

        assertNotNull(lista);
        assertEquals(2, lista.size());
    }

    @Test
    void testActualizarClienteExitoso() {
        // Qué se prueba: Actualización de datos (nombre y apellido) de un cliente existente por su cédula.
        // Resultado esperado: Retorna el cliente con los datos modificados exitosamente.
        
        servicioCliente.crear(new Cliente("1723456789", "Juan", "Pérez"));

        Cliente datosNuevos = new Cliente();
        datosNuevos.setNombre("Juan Carlos");
        datosNuevos.setApellido("Pérez Andrade");

        Cliente clienteActualizado = servicioCliente.actualizar("1723456789", datosNuevos);

        assertNotNull(clienteActualizado);
        assertEquals("Juan Carlos", clienteActualizado.getNombre());
        assertEquals("Pérez Andrade", clienteActualizado.getApellido());
    }

    @Test
    void testActualizarClienteNoExistente() {
        // Qué se prueba: Intento de actualizar los datos de un cliente cuyo número de cédula no existe.
        // Resultado esperado: Retorna null indicando que no se pudo realizar la actualización.
        
        Cliente datosNuevos = new Cliente("9999999999", "Pedro", "Gómez");
        Cliente resultado = servicioCliente.actualizar("9999999999", datosNuevos);

        assertNull(resultado);
    }

    @Test
    void testEliminarClienteExitoso() {
        // Qué se prueba: Eliminación de un cliente existente en la lista.
        // Resultado esperado: Retorna true y el tamaño de la lista disminuye a 0.
        
        servicioCliente.crear(new Cliente("1723456789", "Juan", "Pérez"));

        boolean eliminado = servicioCliente.eliminar("1723456789");

        assertTrue(eliminado);
        assertEquals(0, servicioCliente.listar().size());
    }

    @Test
    void testEliminarClienteNoExistente() {
        // Qué se prueba: Intento de eliminar un cliente que no existe en la lista.
        // Resultado esperado: Retorna false y la lista no sufre cambios.
        
        boolean eliminado = servicioCliente.eliminar("0000000000");

        assertFalse(eliminado);
    }
}