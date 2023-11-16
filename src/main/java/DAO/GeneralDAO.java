package DAO;

import java.util.LinkedList;

public interface GeneralDAO<T>{
	public int add(T objetoDTO);
	public int add(LinkedList<T> lista);
	public int borrar(T aBorrar);
	public int borrar(LinkedList<T> aBorrar);
	public int update(T registro);
	public int update(LinkedList<T> registro);
	public LinkedList<T> getAll();
	public T get(int id);
}
