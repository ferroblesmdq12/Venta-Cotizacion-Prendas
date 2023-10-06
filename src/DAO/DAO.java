package DAO;


/*****************
 * 
 * DATA OBJECT
 * 
 ************/


import java.util.List;

public interface DAO<E,K> {
	
	E buscarPorId(K key);
	List<E> obtenerTodos();
	boolean insertar(E entidad);
	boolean actualizar(E entidad);
	boolean eliminar(E entidad);
}
