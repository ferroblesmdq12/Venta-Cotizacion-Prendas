package utilidades;

import java.util.ArrayList;
import java.util.List;

import model.Prenda;

/*********************************************
 * Esta clase simula una tabla de prendas.
 * 
 **********************************************/

public class GestorPrendas {
	
	// Simula Registro de Prendas //
	private static List<Prenda> prendas;
	
	static {
			prendas = new ArrayList<>();
	}
	
	/*************************************************
	 * Agrega una prenda a los registros de prendas
	 * @param prenda  agrega la prenda.
	 * 
	 ********************************************/
	public static void agregarPrenda(Prenda prenda) {
		prendas.add(prenda);
	}
	
	
	/****************************************************************
	 * Busca una prenda en el registro de prendas por codigo
	 * @param codigoPrenda   el codigo de la prenda a buscar.
	 * @return una prenda si existe, sino devuelve null.
	 **************************************************************/
	
	public static Prenda getPrenda(int codigoPrenda) {
		Prenda prenda = null;
		for(Prenda p: prendas)
		{
			if(p.getCodigo() == codigoPrenda)
			{
				prenda = p;
			}
			
		}
		return prenda;
		
	}
	
	
	// Ver Prendas por Pantalla //
	
	public static void visualizarPrendas() {
		for(Prenda p:prendas)
		{
			System.out.println(p);
		}
		
		
	}
	
	

}
