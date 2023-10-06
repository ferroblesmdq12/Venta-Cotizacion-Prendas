package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import DAO.PrendaDAOImp;
import DAO.DAO;
import DAO.ConexionMySQL;
import model.Prenda;
import DAO.PruebaConexion;



public class ProbandoConexionConDAO {

	public static void main(String[] args) {
		
		Prenda prenda = new Prenda();
		DAO<Prenda, Integer> prendaDAO = new PrendaDAOImp();
		// cosntructor para ingresar valores por teclado //
		Scanner scanner = new Scanner(System.in);
		int opcion;
		        
		        do {
		            System.out.println("Menú:");
		            System.out.println("1. Insertar registro en prendas.");
		            System.out.println("2. Actualizar nombre de la prenda(no actualiza).");
		            System.out.println("3. Eliminar registro en prendas(No elimina).");
		            System.out.println("4. buscar por ID en Prendas");
		            System.out.println("5. actualizar manualmente.");
		            System.out.println("0. Salir");
		            System.out.print("Seleccione una opción: ");

		            opcion = scanner.nextInt();

		            switch (opcion) {
		            
		                case 1:
		                	
		                	insertarPrenda(prendaDAO, scanner);
		                	pausar();
		                	break;
		               
		                case 2:
		                	actualizarPrenda(prendaDAO, scanner);
		                	pausar();
		                    break;
		                
		                case 3:
		                	eliminarPrenda(prendaDAO, scanner);
		                	pausar();
		                	break;
		        
		                case 4:
		                	buscarPorId(prendaDAO, scanner);
		                	pausar();
		                	break;
		                	
		                case 5:
		                	
		                	
		                	break;
		                
		                case 6:
		                	
		                	
		                	break;
		            	    
		                
		                case 0:
		                	System.out.println("Saliendo del Programa...\n");
		                	pausar();
		               

		                default:
		                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
		            }
		        } while (opcion != 5);

		        scanner.close();
		    }
	
	
	/*********************************************************
	 *                                                       *
	 *                 FUNCIONES A UTILIZAR                  *
	 *                                                       * 
	 *********************************************************/
	
	/*******************
	 *                 *
	 * BUSCAR POR ID   *
	 *                 *
	 ******************/
	
	 private static void buscarPorId(DAO<Prenda, Integer> prendaDAO, Scanner scanner) {
	        System.out.println("Ingrese Codigo de prenda a buscar: ");
	        int codigoId = scanner.nextInt();
	        Prenda prenda = prendaDAO.buscarPorId(codigoId);
	        if (prenda != null) {
	            System.out.println("Prenda encontrada: " + prenda);
	        } else {
	            System.out.println("No se encontró la prenda con el ID proporcionado.");
	        }
	    }
	
	
	
	/**************
	 * INSERTAR
	 *************/
	
	 private static void insertarPrenda(DAO<Prenda, Integer> prendaDAO, Scanner scanner) {
	       
	        Integer codigo = 0;
		 	System.out.println("Ingresar nombre de la prenda: ");
	        String nombrePrenda = scanner.next();

	        double precioLista;
	        do {
	            System.out.println("Ingrese precio de la prenda: ");
	            precioLista = scanner.nextDouble();
	            if (precioLista <= 0) {
	                System.err.println("Debe ingresar un precio de lista válido.");
	            }
	        } while (precioLista <= 0);

	        Prenda prenda = new Prenda(nombrePrenda, precioLista);
	        prendaDAO.insertar(prenda);
	        System.out.println("Se insertó registro en BBDD.");
	        
	    }
	 
	 
	
	     /*******************************
		 *                              *
		 *         ACTUAIZAR            *
		 *                              *
		 *******************************/
	 
	
	 
	 private static void actualizarPrenda(DAO<Prenda, Integer> prendaDAO, Scanner scanner) {
		    
		 System.out.print("Ingrese Codigo de prenda a actualizar: ");
		    int codigoId = obtenerEnteroValido(scanner);
		    System.out.println(codigoId);

		    Prenda prenda = prendaDAO.buscarPorId(codigoId);
		    
		    if (prenda != null) {
		        
		    	System.out.println("Prenda encontrada: " + prenda);
		        
		        String nuevoNombre = obtenerPrenda(scanner);
		        double nuevoPrecio = obtenerPrecio(scanner);
		        
		        System.out.println(nuevoNombre);
		        System.out.println(nuevoPrecio);

		        prenda.setNombrePrenda(nuevoNombre);
		        prenda.setPrecio(nuevoPrecio);

		        if (prendaDAO.actualizar(prenda)) {
		            System.out.println("Prenda actualizada correctamente.");
		        } else {
		            System.out.println("No se pudo actualizar la prenda.");
		        }
		    } else {
		        System.out.println("No se encontró la prenda con el ID proporcionado.");
		    }
		}

		private static String obtenerPrenda(Scanner scanner) {
		    System.out.print("Ingrese nuevo nombre de la prenda (o presione Enter para dejarlo sin cambios): ");
		    return scanner.nextLine().trim();
		}

		private static double obtenerPrecio(Scanner scanner) {
		    while (true) {
		        System.out.print("Ingrese nuevo precio de la prenda (o presione Enter para dejarlo sin cambios): ");
		        String nuevoPrecioString = scanner.nextLine().trim();

		        if (nuevoPrecioString.isEmpty()) {
		            return -1; // Indicar que no se proporcionó un precio
		        }

		        try {
		            double nuevoPrecio = Double.parseDouble(nuevoPrecioString);
		            if (nuevoPrecio <= 0) {
		                System.out.println("El precio debe ser un número positivo.");
		            } else {
		                return nuevoPrecio;
		            }
		        } catch (NumberFormatException e) {
		            System.out.println("Formato de precio inválido. Intente nuevamente.");
		        }
		    }
		}
		


		
		private static int obtenerEnteroValido(Scanner scanner) {
		    while (true) {
		        String input = scanner.nextLine().trim();
		        if (input.isEmpty()) {
		            System.out.println("Por favor, ingrese un número válido.");
		        } else {
		            try {
		                return Integer.parseInt(input);
		            } catch (NumberFormatException e) {
		                System.out.println("Por favor, ingrese un número válido.");
		            }
		        }
		    }
		}
		
		

		
	 
	     /*************************
	     *                        *
		 *        ELIMINAR        *
		 *                        *
		 *************************/
	 
	 private static void eliminarPrenda(DAO<Prenda, Integer> prendaDAO, Scanner scanner) {
		    System.out.println("Ingrese Codigo de prenda a eliminar: ");
		    int codigoId = scanner.nextInt();
		    Prenda prenda = prendaDAO.buscarPorId(codigoId);
		    
		    //if(Object.notNull(prenda))
		    if (prenda != null) {
		        System.out.println("Prenda encontrada: " + prenda);
		        System.out.println("¿Estás seguro de que quieres eliminar esta prenda? (S/N)");
		        String confirmacion = scanner.next().toUpperCase();

		        if (confirmacion.equals("S")) {
		            if (prendaDAO.eliminar(prenda)) {
		                System.out.println("Prenda eliminada correctamente.");
		            } else {
		                System.out.println("No se pudo eliminar la prenda.");
		            }
		        } else {
		            System.out.println("Operación de eliminación cancelada.");
		        }
		    } else {
		        System.out.println("No se encontró la prenda con el ID proporcionado.");
		    }
		}
	 
	 
	 

	 /*************************
	  *                        *
	  *        PAUSAR          *
	  *                        *
	  *************************/


	 public static void pausar() {
		 System.out.print("Presione Enter para continuar...");
		 try {
			 System.in.read();
		 } catch (Exception e) {
			 e.printStackTrace();
		 }
	 }
}






