package main;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.IOException;

import model.Cotizacion;
import model.Prenda;
import model.Vendedor;
import utilidades.ConversorFechas;
import utilidades.GestorPrendas;
import utilidades.GestorVendedor;

/**************************************** 
 *                                      *
 * En esta clase se inicia la ejecucion * 
 * de la aplicacion.                    *
 *                                      *
 ****************************************/




public class Principal {
	
	
	// Cargamos las lista antes del main, para que queden inicializadas. //
	
	
	
	static {
		// VENDEDORES //
		// Creamos Vendedores//
		
		Vendedor vendedor01 = new Vendedor(7600869, "Fernando", "Robles");
		Vendedor vendedor02 = new Vendedor(7600622, "Damian", "Angelucci");
		Vendedor vendedor03 = new Vendedor(7600123, "Lucas", "Ludueña");
		Vendedor vendedor04 = new Vendedor(7600425, "Carlos", "Figueroa");
		
		GestorVendedor.agregarVendedor(vendedor01);
		GestorVendedor.agregarVendedor(vendedor02);
		GestorVendedor.agregarVendedor(vendedor03);
		GestorVendedor.agregarVendedor(vendedor04);
		
		
		
		
		// PRENDAS //
		// se crean las prendas //
		Prenda prenda01 = new Prenda(111,"pantalon",2500);
		Prenda prenda02 = new Prenda(222,"remera", 1870);
		Prenda prenda03 = new Prenda(333, "buzo", 3500);
		Prenda prenda04 = new Prenda(444, "calzoncillo", 800);
		Prenda prenda05 = new Prenda(555, "medias", 550);
		Prenda prenda06 = new Prenda(666, "camperas", 7500);
		Prenda prenda07 = new Prenda(777, "zapatillas", 14300);
		
		// Luego Se agregan las prendas a la lista//
		GestorPrendas.agregarPrenda(prenda01);
		GestorPrendas.agregarPrenda(prenda02);
		GestorPrendas.agregarPrenda(prenda03);
		GestorPrendas.agregarPrenda(prenda04);
		GestorPrendas.agregarPrenda(prenda05);
		GestorPrendas.agregarPrenda(prenda06);
		GestorPrendas.agregarPrenda(prenda07);
	}
	
	
/** MAIN */

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int codigoVendedor;

		// Se visualizan las prendas que estan cargadas y/o Disponibles en la lista //
		System.out.println("BIENVENIDOS AL SISTEMA DE VENTAS Y LAVADO DE ACTIVOS.\n");
		//Lista vendedores//
		System.out.println("VENDEDORES: ");
		GestorVendedor.verVendedores();

				
		

		

		/** MENU */

		int opcion;

		do {
			System.out.println("\nMenú:");
			System.out.println("1.Elegir Vendedor y realizar cotizacion con las prendas.");
			System.out.println("2. Opción 2");
			System.out.println("3. Salir");
			System.out.print("Seleccione una opción: \n");

			opcion = scanner.nextInt();

			switch (opcion) {
			case 1:
				//Aqui pedimos ingresar el su Codigo de vendedor, para realizar la cotizacion//
				/** Falta realizar una validacion */
				System.out.println("Ingrese su código de Vendedor: ");
				codigoVendedor = Integer.parseInt(scanner.next());
				Vendedor vendedor =GestorVendedor.getVendedor(codigoVendedor);
				
				
				//Lista de prendas //
				System.out.println("\nPRENDAS: ");
				GestorPrendas.visualizarPrendas();
				
				
				// registramos una cotizacion //
				vendedor.registrarCotizacion(crearCotizacion(vendedor));
							
				//Mostramos el historial de cotizacion//
				vendedor.mostrarHistorial();
				break;
				
			case 2:
				System.out.println("Seleccionó la Opción 2");
				System.out.println("No hay nada para realizar...");
				break;
				
			case 3:
				System.out.println("Saliendo del programa.");
				limpiarPantalla();
				break;
				
			default:
				System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
			}
		} while (opcion != 3);

		scanner.close();
		
	}
		
	
	/** FUNCIONES */	
		
		/************************************************************
		 * Permite crear una cotizacion solicitada por consola.
		 * @param vendedor el vendedor que realiza la cotizacion.
		 * @return la cotizacion realizada por el vendedor.
		 ************************************************************/
		
		public static Cotizacion crearCotizacion(Vendedor vendedor) {
			Scanner scanner = new Scanner(System.in);
			// usamos la funcion de fecha actual y asi no es necesario usar validacion//
			LocalDateTime fecha = LocalDateTime.now();
			//Date fecha;
			//boolean isValidDate;
			
			
			
			
			// Primero validamos la fecha de cotizacion //.
			
			// Este Sirve para cuando no necesitemos la fecha actual y tengamos que cargar fechas anteriore o 
			// Posteriores a la fecha Acual.
			
//			do 
//			{
//				System.out.println("Ingrese la fecha de Cotizacion: ");
//				String fechaString = scanner.next();
//				fecha = ConversorFechas.StringToDate(fechaString);
//				
//				if(fecha == null) 
//				{
//					isValidDate=false;
//					System.err.println("Debe ingresar una fecha válida! ");
//				}else
//				{
//					isValidDate = true;
//				}
//			}while(isValidDate!=true);
			
			
			
			// Segundo, validamos el codigo de la prenda //
			
			int codigoPrenda;
			Prenda prenda = null;
			boolean isValidClothCode;
			
			do
			{
				try
				{
					System.out.println("\nIngrese el codigo de la prenda a cotizar: ");
					codigoPrenda = Integer.parseInt(scanner.next());
					prenda = GestorPrendas.getPrenda(codigoPrenda);
					
					if(prenda==null)
					{
						isValidClothCode=false;
						System.err.println("No existe una prenda con ese codigo, ingrese otro.");
					}else
					{
						isValidClothCode=true;
					}
		
				} catch(NumberFormatException e)
				{
					System.err.println("El codigo de la prenda es un valor numérico: ");
					isValidClothCode=false;
				}
			}while(isValidClothCode!=true);
			
			boolean isValidClothCount;
			int cantidadPrendas=0;
			do 
			{
				try
				{
					System.out.println("Ingrese la cantidad de prendas a cotizar: ");
					cantidadPrendas = Integer.parseInt(scanner.next());
					if(cantidadPrendas <= 0)
					{
						isValidClothCount=false;
						System.err.println("Debe ingresar una cantidad de prendas válida.");
					}
					else
					{
						isValidClothCount=true;
					}
				}catch(NumberFormatException e)
				{
					System.err.println("la cantidad de prendas es un valor nu,erico positivo mayor a cero: ");
					isValidClothCount=false;
				}
			}while(isValidClothCount!=true);
			
			Cotizacion cotizacion = new Cotizacion(vendedor.getProximoNroCotizacion(),fecha, prenda, cantidadPrendas, vendedor);
			return cotizacion;
		}
		
	

			
			/*********************************************************************
			 * Permite mostrar las costizaciones de un vendedor
			 * @param vendedor el vendedor del que se mostrara sus cotizaciones
			 **********************************************************************/
			public static void mostrarCotizaciones(Vendedor vendedor)
			{
				vendedor.mostrarHistorial();
			}
			
			
			
			/***********************************
			 * Funcion para limpiar pantalla
			 ************************************/
			
			public static void limpiarPantalla() {
		        try {
		            if (System.getProperty("os.name").contains("Windows")) {
		                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		            } else {
		                System.out.print("\033[H\033[2J");
		                System.out.flush();
		            }
		        } catch (IOException | InterruptedException e) {
		            e.printStackTrace();
		        }
			}
		
}


 

					
				
			
			
		


