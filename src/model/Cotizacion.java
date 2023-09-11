package model;

import java.util.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;


/**************************************** 
 *                                      *
 * CLASE COTIZACION:                    * 
 * Representa la cotizacion hecha por   *
 * un vendedor.                         *
 *                                      *
 ****************************************/


public class Cotizacion {
	
	
	// ATRIBUTOS //
	
	
	// nro para identificar la cotizacion //
	private int nroIdentificacion;
	
	//fecha de realizacion de la cotizacion //
	private LocalDateTime fecha;
	
	//Prenda cotizada//
	private Prenda prenda;
	
    // cantidad de prendas cotizadas //
	private int cantidadPrendas;
	
	//total de la cotizacion //
	private double totalCotizacion;
	
	//Vendedor que Realizo la cotizacion//
	private Vendedor vendedor;
	
	
	
	// CONSTRUCTORES //
	
	//Constructor por Defecto //
	public Cotizacion() {
		
	}
	
	/***************************************
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param nroIdentificacion 
	 * @param fecha
	 * @param prenda
	 * @param cantidadPrendas
	 * @param totalCotizaciones
	 * @param vendedor
	 * *****************************/
	
	public Cotizacion(int nroIdentificacion, LocalDateTime fecha, Prenda prenda, int cantidadPrendas, Vendedor vendedor) {
		this.nroIdentificacion = nroIdentificacion;
		this.fecha = fecha;
		this.prenda = prenda;
		this.cantidadPrendas = cantidadPrendas;
		this.vendedor = vendedor;
		// en el siguiente multiplicamos cantidad de prendas x por el precio de la prenda //
		this.totalCotizacion = this.cantidadPrendas*prenda.getPrecio();
	}

	@Override
	public String toString() {
		return "Cotizacion [nroIDENTIFICACION = " + nroIdentificacion + ", FECHA = " + fecha + ", PRENDA = " + prenda
				+ ", CANTIDAD = " + cantidadPrendas + ", TOTAL_COTIZACION = " + totalCotizacion + ", VENDEDOR = "
				+ vendedor + " ]";
	}
	
	
	
	// METODOS //
	
	
	
	
	
	

}
