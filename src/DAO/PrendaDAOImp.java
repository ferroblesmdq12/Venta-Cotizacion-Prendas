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
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class PrendaDAOImp implements ConexionMySQL, DAO<Prenda, Integer>{ 
	
	/*********************
	 * BUSCAR POR ID
	 ********************/
	
	public Prenda buscarPorId (Integer key) {
		
		Prenda prendaBuscada = null;
		
		Connection conexion = getConexion();
		
		String sentenciaSQL = "SELECT * FROM prendas WHERE pre_codigo = ?";
		
		PreparedStatement preparedStatement = null;
		
		
		try {
			preparedStatement = conexion.prepareStatement(sentenciaSQL);
			preparedStatement.setInt(1, key);
			ResultSet resultado = preparedStatement.executeQuery();
			
			while(resultado.next()) {
				
				int codigo = resultado.getInt("pre_codigo");
				String nombrePrenda = resultado.getString("pre_nombre");
				double precio = resultado.getDouble("pre_precio_lista");
				prendaBuscada = new Prenda (codigo, nombrePrenda, precio);
			}
		}catch (SQLException e) {
			
			e.printStackTrace();
			
		}finally {
			
			try {
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				conexion.close();
			}catch (SQLException e) {
				
				e.printStackTrace();
			}
		}
		
		return prendaBuscada;
		
		
	
	}
	
	

	
	/**************
	 * INSERTAR
	 *************/
	
	
	public boolean insertar(Prenda entidad) {
		
		Connection conexion = getConexion();
        String sentenciaSQL = "INSERT INTO prendas(pre_nombre, pre_precio_lista) VALUES (?, ?)";
        PreparedStatement preparedStatement = null;
        
        try {
            preparedStatement = conexion.prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, entidad.getNombrePrenda());
            preparedStatement.setDouble(2, entidad.getPrecio());
            // preparedStatement.setInt(3,entidad.getCodigo());
            preparedStatement.executeUpdate();
            return true;
        }catch(SQLException e) {
        	e.printStackTrace();
        }finally {
        	
        	try {
        		
        		if (preparedStatement != null) {
        			
        			preparedStatement.close();
        			
        		}
        		conexion.close();
        	}catch (SQLException e) {
        		e.printStackTrace();
        	}
        	
        }
        
        return false;
        
        
	}

	
	
	
	
	/********************************
	 *                              *
	 *         ACTUAIZAR            *
	 *                              *
	 *******************************/

	public boolean actualizar(Prenda entidad) {
        Connection conexion = getConexion();
        String sentenciaSQL = "UPDATE prendas SET pre_nombre=?, pre_precio_lista=? WHERE pre_codigo=?";
      
        
        PreparedStatement preparedStatement = null;

        try {
            preparedStatement = conexion.prepareStatement(sentenciaSQL);
            preparedStatement.setString(1, entidad.getNombrePrenda());
            preparedStatement.setDouble(2, entidad.getPrecio());
            preparedStatement.setInt(3, entidad.getCodigo());
            preparedStatement.executeUpdate();
            return true;
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                conexion.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
	
	
	
	
	
     /*************************
     *                        *
	 *        ELIMINAR        *
	 *                        *
	 *************************/
	

	 public boolean eliminar(Prenda entidad) {
	        Connection conexion = getConexion();
	        String sentenciaSQL = "DELETE FROM prendas WHERE pre_codigo = ?";
	        PreparedStatement preparedStatement = null;

	        try {
	            preparedStatement = conexion.prepareStatement(sentenciaSQL);
	            preparedStatement.setInt(1, entidad.getCodigo());
	            preparedStatement.executeUpdate();
	            return true;
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                if (preparedStatement != null) {
	                    preparedStatement.close();
	                }
	                conexion.close();
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return false;
	    }
	
	


		/******************************************************
		 *                                                    *
		 *    OBTENER TODOS  LAS REGISTROS                    *
		 *                                                    *
		 *****************************************************/ 
	 
	 public List<Prenda> obtenerTodos() {
			List<Prenda> prendas = new ArrayList<Prenda>();
			
			Connection conexion = getConexion();
			String sentenciaSQL = "SELECT * FROM prendas";
			Statement objetoSentenciaSQL = null;
			try {
				objetoSentenciaSQL = conexion.createStatement();
				ResultSet resultado = objetoSentenciaSQL.executeQuery(sentenciaSQL);
				while(resultado.next()) {
					//int codigo = resultado.getInt("pre_codigo");
					String nombrePrenda = resultado.getString("pre_nombre");
					double precio = resultado.getDouble("pre_precio_lista");
					Prenda prendaBuscada = new Prenda( nombrePrenda, precio);
					prendas.add(prendaBuscada);
				}	
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				try {
					objetoSentenciaSQL.close();
					conexion.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
			return prendas;
		}
	 

	
	
	
	
	/******************************************************
	 *     ACTUALIZAR                                     *
	 *    Se utiliza el objeto PreparedStatement          *
	 *    para evitar la inyección de SQL y               *
	 *    permitir la actualización segura de los datos.  *
	 *                                                    *
	 *****************************************************/ 
	
	
//	public boolean actualizar2(Prenda entidad) {
//		
//		Connection conexion = getConexion();
//		
////		String sentenciaSQL = "UPDATE prendas SET pre_precio_lista = 9000  WHERE pre_codigo = 30 ";
//		
//		String sentenciaSQL = "UPDATE prendas SET pre_nombre=?, pre_precio_lista WHERE pre_codigo = ?";
//		
//		PreparedStatement preparedStatement = null;
//		
//		
//		try {
//			
//				preparedStatement = conexion.prepareStatement(sentenciaSQL);
//	            preparedStatement.setString(1, entidad.getNombrePrenda());
//	            preparedStatement.setDouble(2, entidad.getPrecio());
//	            preparedStatement.setInt(3, entidad.getCodigo());
//	            preparedStatement.executeUpdate();
//	            return true;
//	            
//		} catch (SQLException e) {
//			
//			e.printStackTrace();		
//		} finally {
//			
//		} try {
//			if (preparedStatement != null) {
//				preparedStatement.close();
//			}
//			conexion.close();
//		} catch (SQLException e) {
//			
//			e.printStackTrace();
//		}
//		
//		return false;
//	
//			
//	}

}





/*******************************************************************************************************************************************************/
