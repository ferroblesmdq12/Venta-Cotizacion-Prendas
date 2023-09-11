package utilidades;

import java.util.ArrayList;
import java.util.List;

import model.Vendedor;


/*************************************************
 * 
 * Esta Clase simula una tabla de Vendedores.
 * 
 *************************************************/
public class GestorVendedor {
	
	// Simula Registro de vendedores //
	private static List<Vendedor> vendedores;
	
	static {
		vendedores = new ArrayList<>();
		
	}
	
	/**************************************************
	 * Agrega un Vendedor al registro vendedor.
	 * @param vendedor agrega al vendedor.
	 **************************************************/
	public static void agregarVendedor(Vendedor vendedor) {
		vendedores.add(vendedor);
	}
	
	/**************************************************
	 * Busca un vendedor por su codigo
	 * @param codigo  codigo del vendedor a buscar.
	 * @return un vendedor si existe, sino devuleve null. 
	 ****************************************************/
	public static Vendedor getVendedor(int codigo) {
		Vendedor vendedor = null;
		for(Vendedor v: vendedores)
		{
			if(v.getCodigo() == codigo)
			{
				vendedor = v;
			}
		}
		
		return vendedor;
	}
	
	// VER VENDEDORES POR PANTALLAS //
	
	public static void verVendedores() {
		for(Vendedor v: vendedores)
		{
			System.out.println(v);
		}
	}
	
	
}

