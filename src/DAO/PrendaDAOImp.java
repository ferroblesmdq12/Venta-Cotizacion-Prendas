package DAO;


/********************************
 * Esta clase Abstracta es       * 
 * la Buisness Object            *
 * Para cada clase necesitaremos *
 * una de estas                  *
 ********************************/

import DAO.ConexionMySQL;
import model.Prenda;
import DAO.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PrendaDAOImp implements ConexionMySQL, DAO<Prenda, Integer>{
	
	
	public Prenda buscarPorId (Integer key) {
		
		return null;
	}
	
	
	/*
	 * INSERTAR
	 */
	
	public boolean insertar(Prenda entidad) {
		
		Connection conexion = getConexion();
		
		String sentenciaSQL = "INSERT INTO prendas(pre_nombre,pre_precio_lista)" // Le pasamos los parametros //
							+ " VALUES('"+entidad.getNombrePrenda()+"',"+entidad.getPrecio()+")";//Inserta valores a la tabla de la BBDD //
		
		
		
		Statement objetoSentenciaSQL;
		
		try {
			
				objetoSentenciaSQL = conexion.createStatement();
				objetoSentenciaSQL.execute(sentenciaSQL);
				objetoSentenciaSQL.close();
				conexion.close();
			
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
				
		return false;
	}
	
	
	/*
	 * Eliminar
	 */
	
	public boolean eliminar(Prenda entidad) {
		Connection conexion = getConexion();
		
		String sentenciaSQL = "DELETE FROM prendas WHERE pre_codigo = 31";// elimina este registro //
		
		Statement objetoSentenciaSQL;
		
		try {
			
			objetoSentenciaSQL = conexion.createStatement();
			objetoSentenciaSQL.execute(sentenciaSQL);
			objetoSentenciaSQL.close();
			conexion.close();

		
		}catch(SQLException e) 
		{
			e.printStackTrace();
		}
		
		return false;
	}
	
	
	
	public boolean actualizar(Prenda entidad) {
		
		return false;
	}

}
