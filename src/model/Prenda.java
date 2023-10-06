package model;

/***************************************
 * 
 * Esta clase es de las prendas que 
 * pueden cotizarse.
 * 
 ****************************************/

public class Prenda {
	
	// ATRIBUTOS //
	
	//Codigo de Prenda//
	private int codigo;
	
	//Nombre de prenda//
	private String nombrePrenda;
	
	//precio de la prenda//
	private double precio;
	
	
	// COSTRUCTOR POR DEFECTO //
	public Prenda() {
		//
	}


	
	//CONSTRUCTOR PARAMETRIZADO //
	
	/*********************************************
	 * CONSTRUCTOR PARAMETRIZADO
	 * @param codigo codigo de la prenda
	 * @param nombrePrenda nombre de la prenda
	 * @param precio precio de la prenda
	 * ***************************************/
	
//	public Prenda( int codigo, String nombrePrenda, double precio) {
	public Prenda(String nombrePrenda, double precio) {
		
		this.nombrePrenda = nombrePrenda;
		this.precio = precio;
	}

public Prenda(int codigo,String nombrePrenda, double precio) {
		this.codigo = codigo;
		this.nombrePrenda = nombrePrenda;
		this.precio = precio;
	}


	@Override
	public String toString() {
		return "Prenda [CODIGO = " + codigo + ", PRENDA = " + nombrePrenda + ", PRECIO = " + precio + "]";
	}

	// METODOS //
	

	/**
	 * Devuelve el codigo de la prenda
	 * @return codigo
	 */

	public int getCodigo() {
		return codigo;
	}


	/**
	 * Devuelve el nombre de la prenda
	 * @return nombrePrenda
	 */

	public String getNombrePrenda() {
		return nombrePrenda;
	}

	
	/**
	 * Devuelve el precio de la prenda
	 * @return precio;
	 */

	public double getPrecio() {
		return precio;
	}



	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}



	public void setNombrePrenda(String nombrePrenda) {
		this.nombrePrenda = nombrePrenda;
	}



	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
	
	
	
	
	

}
