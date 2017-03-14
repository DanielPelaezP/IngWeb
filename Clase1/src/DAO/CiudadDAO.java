package DAO;

import java.util.List;

import DTO.Ciudad;
import EXCEPTION.MyException;
//interfaz que define el DAO para ciudad
public interface CiudadDAO  {
	//entrega la lista completa de la base de datos
	public List<Ciudad> obtener() throws MyException;
	public Ciudad obtener(Long codigo) throws MyException;//se sobre carga el metodo obtener segun el numero de parametros

}
