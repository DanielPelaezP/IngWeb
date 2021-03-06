package co.edu.udea.iw.dao.impl.test;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.CiudadDAO;
import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dao.impl.CiudadDAOImpl;
import co.edu.udea.iw.dao.impl.UsuarioDAOImpl;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@author Daniel Pelaez

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configurationSpring.xml")

public class UsuarioDaoImplTest {
	@Autowired
	private UsuarioDAO usuarioDAO;
	@Test
	public void testObtenerString() {
		//UsuarioDAO usuarioDAO = null;
		Usuario usuario = null;
		
		try
		{
			//usuarioDAO = new UsuarioDAOImpl();
			usuario = usuarioDAO.obtener("elver");
			assertEquals(usuario.getNombres(),"Elver");
		}
		catch(MyException e)
		{
			
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	

}
