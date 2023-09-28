package main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Prenda;

public class PruebaConexion {

	public static void main(String[] args) {
		
		// Definimos un String que representa  la ubicacion del driver JDBC //
		
		String driver = "com.mysql.cj.jdbc.Driver";
		
		String url = "jdbc:mysql://localhost:3306/cotizaciones"; // Para saber donde esta ubicada el motor de la base (mi caso es local) //
		
//		String url = "jdbc:mysql://127.0.0.1:3306/?user=root/cotizaciones"; // copiado de Mysql
			
		
		/* CONSTRUCTOR DE CONEXION */
		Connection conexion = null;
		
		
		try {
			/* CREAMOS LA CONEXION */
			Class.forName(driver); // registra el driver para poder utilizarlo //
			conexion = DriverManager.getConnection(url,  "root", ""); // le pasamos por parametros: url, usuario: "root", contraseña:  "" (que en esete caso no tiene). //
			System.out.println("Conexion Establecida");
			
			/* Aqui vamos a desarrollar metodos para hacer las consultas a las tablas de la BBDD */
			
			//Cargamos datos en la tabla prendas de la BBDD //
			String sentenciaSQL = "INSERT INTO prendas(pre_nombre,pre_precio_lista)  VALUES('Pantalon Jogin Jordan', 3508)";//Inserta valores a la tabla de la BBDD //
			Statement objetoSentenciaSQL = conexion.createStatement(); //Objeto que representa la sentencia con interfaz SATEMENT de SQL//
			objetoSentenciaSQL.execute(sentenciaSQL);// Ejecuta la sentencia SQL //
			
			
			//Ahora queremos obtener los datos de la tabla de BBDD //
			sentenciaSQL = "SELECT * FROM prendas";
			
			ResultSet resultados = objetoSentenciaSQL.executeQuery(sentenciaSQL);
			
			//Necesitamos hacer un ciclo while que recorra cada columna de la tabla y filas y muestre los datos //
			while(resultados.next())
			{
				int codigo = resultados.getInt("pre_codigo");
				String nombre = resultados.getString("pre_nombre");
				double precioLista = resultados.getDouble("pre_precio_lista");
				Prenda prenda = new Prenda(codigo, nombre, precioLista);
				System.out.println(prenda);
				
				
			}
			
			
			
			objetoSentenciaSQL.close();// Se cierra conexion //

		}
		catch(ClassNotFoundException | SQLException e) 
		{
			e.printStackTrace();
		}
		
		
		

	}

}
