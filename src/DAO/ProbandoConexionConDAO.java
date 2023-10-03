package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DAO.PrendaDAOImp;
import DAO.DAO;
import DAO.ConexionMySQL;
import model.Prenda;

public class ProbandoConexionConDAO {

	public static void main(String[] args) {
		
		Prenda prenda = new Prenda();
		
		prenda.setNombrePrenda("sombrero Cowboys");
		prenda.setPrecio(8200);
		
		DAO<Prenda, Integer> prendaDAO = new PrendaDAOImp();
		//boolean isInsert = prendaDAO.insertar(prenda);
		
		boolean isDelete = prendaDAO.eliminar(prenda);
		
		
		
		//System.out.println(isInsert);  // Para que diga FALSE //
		
	
 		
		

	}

}
