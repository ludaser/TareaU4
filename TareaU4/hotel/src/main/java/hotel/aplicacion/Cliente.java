/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.aplicacion;

import hotel.utilidades.Utilidades;

/**
 * Esta clase contiene la información personal de un cliente del hotel, también valida el dni y genera un codigo por cliente
 * @author David
 */
public class Cliente {
    private static int contadorClientes = 0; /** Contador estático que asigna un número único/exclusivo del cliente */
    private int codigo; /** Código único/exclusivo del cliente */
    public String nombre; /** Nombre del cliente */
    public String dni; /** DNI del cliente */
    public String telefono; /** Teléfono del cliente */ 

    /** Es un constructo que inicializa un nuevo cliente con los datos obtenidos.
     * Se valida que el dni es correcto antes de crear el objeto 
     * @param nombre
     * @param dni
     * @param telefono
     * @throws Exception
     */
    public Cliente(String nombre, String dni, String telefono) throws Exception {
        // Validación del DNI, si no es correcto no creará el objeto
        Utilidades.validarDNI(dni); 
        this.nombre = nombre;
        this.dni = dni;
        this.telefono = telefono;
        this.codigo = obtenerNumeroCliente();
    }

    	/**  Obtiene el siguiente número del cliente.
      	Aumenta el contador de clientes para generar un número exclusivo por cada cliente. */
        private static int obtenerNumeroCliente() {
        contadorClientes++;
        return contadorClientes;
    }

       /** Devuelve una cadena con la información completa del cliente.
        La cadena contiene el código, nombre, DNI y teléfono del cliente */
    public String mostrarInformacion() {
        return "Código: " + codigo + ", Nombre: " + nombre + ", DNI: " + dni + ", Teléfono: " + telefono;
    }
    
    	// Métodos Getter y Setter para la Encapsulación
    
    /** obtiene el nombre del cliente */
    public String getNombre() {
        return nombre;
    }

    /** establece/implementa el nombre del cliente */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /** obtiene el dnii del cliente */
    public String getDni() {
        return dni;
    }

    /** Establece/implementa el dni del cliente */
    public void setDni(String dni) {
        this.dni = dni;
    }
    
    /** obtiene el telefono del cliente */
    public String getTelefono() {
        return telefono;
    }
    
    /** establece/implementa el telefono del cliente */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /** obtiene el codigo del cliente */
    public int getCodigo() {
        return codigo;
    }
}
