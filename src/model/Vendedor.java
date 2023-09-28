package model;

import java.util.ArrayList;
import java.util.List;

/*************************************
 * Esta clase representa al Vendedor *
 * que realiza las cotizaciones.     *
 *                                   *
 ************************************/


public class Vendedor {
	
	// ATRIBUTOS //
	
	// Codigo del vendedor //
	private int codigo;
	
	//Nombre del vendedor//
	private String nombres;
	
	//Apellido//
	private String apellidos;
	
	//Lista de cotizaciones realizadas por el vendedor//
	private List<Cotizacion> historialCotizaciones;
	
	//Lista de vendedores //
	private List<Vendedor> listaVendedores;
	
	
	// CONSTRUCTOR POR DEFECTO //
	
	// Aqui se crea la lista de cotizaciones //
	
	public Vendedor() {
		historialCotizaciones = new ArrayList<>();
	}
	
	
	
	/*******************************
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param codigo
	 * @param nombres
	 * @param apellidos
	 * 
	 *****************************/
	public Vendedor(int codigo, String nombres, String apellidos) {
		this.codigo = codigo;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.historialCotizaciones = new ArrayList<>();
	}


	
	
	
	// METODOS //
	
	/**********************************************************
	 * Agrega una cotizacion al histrorial de cotizaciones
	 * @param cotizacion
	 * 
	 *********************************************/
	
	public void registrarCotizacion(Cotizacion cotizacion) {
		this.historialCotizaciones.add(cotizacion);
	}
	
	
	/*************************************************
	 * Muestra por pantalla el Historial de 
	 * Cotizaciones
	 *********************************************/
	
	public void mostrarHistorial() {
		for(Cotizacion c:historialCotizaciones)
		{
			System.out.println(c);
		}
	}
	
	
	
	/****************************************************
	 * Devuelve el proximo valor de nroCotizacion
	 * @return proximo nro de cotizacion que el vendedor
	 * realizara.
	 * 
	 *********************************************/
	
	public int getProximoNroCotizacion() {
		return this.historialCotizaciones.size()+1;
	}


	@Override
	public String toString() {
		return "Vendedor [CODIGO = " + codigo + ", NOMBRES = " + nombres + ", APELLIDOS = " + apellidos + "]";
	}


	public int getCodigo() {
		return codigo;
	}


	public String getNombres() {
		return nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public List<Cotizacion> getHistorialCotizaciones() {
		return historialCotizaciones;
	}


}
