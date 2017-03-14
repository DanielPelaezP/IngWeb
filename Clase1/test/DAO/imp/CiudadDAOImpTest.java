package DAO.imp;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import DAO.CiudadDAO;
import DTO.Ciudad;
import EXCEPTION.MyException;

public class CiudadDAOImpTest {

	//@Test//prueba de la listas de ciudades
	public void testObtener() {
		CiudadDAO ciudadDAO = null;
		List<Ciudad> lista = null;
		try{
			ciudadDAO = new CiudadDAOImp();
			lista = ciudadDAO.obtener();
			assertTrue(lista.size()> 0);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
			}
@Test//	prueba  de una ciudad
	public void testObtener1() {
		CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try{
			ciudadDAO = new CiudadDAOImp();
			ciudad = ciudadDAO.obtener(1L);
			assertTrue(ciudad!=null);
		}catch(MyException e){
			fail(e.getMessage());
		}
		
			
}
}
