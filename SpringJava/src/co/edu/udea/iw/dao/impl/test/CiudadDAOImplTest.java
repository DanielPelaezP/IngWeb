package co.edu.udea.iw.dao.impl.test;
/**
 * @author sergio.llanos
 * @version 1.0
 */
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.exception.MyException;
import javassist.ClassPath;
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configurationSpring.xml") // indicar donde esta el archivo de configuracion de spring
public class CiudadDAOImplTest {
	
	@Autowired //inicializa el objeto CiudadDAO
	CiudadDAO ciudadDAO;
	//Prueba que se realiza para demostrar que la lista retorna al menos 1 elemento
	@Test
	public void testObtener() {
		//CiudadDAO ciudadDAO = null; //Se crea el objeto ciudadDao
		List <Ciudad> ciudades = null; //Se crea la lista de ciudades
		try{
			//ciudadDAO = new CiudadDAOImpl();
			ciudades = ciudadDAO.obtener(); //Con este metodo se obtienen las ciudades
			assertTrue(ciudades.size()>0);   //Con este metodo verificamos nuestra prueba
			
		}
		catch(MyException e)
		{
			e.printStackTrace();
			fail(e.getMessage());
		}
	}

	@Test
	//Prueba que se realiza para demostrar que se puede retornar una ciudad especifica
	public void testObtenerLong() {
		//CiudadDAO ciudadDAO = null;
		Ciudad ciudad = null;
		try
		{
			//ciudadDAO = new CiudadDAOImpl();
			ciudad = ciudadDAO.obtener(1l); //Con este metodo mandamos de parametro el codigo 1
			//Como mandamos el 1 deberia retornar con el metodo getNombre Medellin
			assertEquals(ciudad.getNombre(),"Medellin");
		}
		catch(MyException e)
		{
			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}

