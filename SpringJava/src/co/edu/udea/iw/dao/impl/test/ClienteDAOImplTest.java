package co.edu.udea.iw.dao.impl.test;

import static org.junit.Assert.*;

import java.sql.Date;
import java.util.Calendar;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import co.edu.udea.iw.dao.ClienteDAO;
import co.edu.udea.iw.dao.impl.ClienteDAOImpl;
import co.edu.udea.iw.dto.Cliente;
import co.edu.udea.iw.dto.Rol;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration(locations="classpath:configurationSpring.xml")
public class ClienteDAOImplTest {
	@Autowired
	ClienteDAO clienteDAO;
	@Test
	public void testObtener() {
		
		List<Cliente> resultado = null;
		
		try {
			
			resultado = clienteDAO.obtener();
			
			for(Cliente cliente: resultado) {
				System.out.println(new StringBuffer(cliente.getNombres()).append(cliente.getApellidos()));
			}
			
			assertTrue(resultado.size() > 0);
		} catch(MyException e) {
			e.printStackTrace();
			fail(e.getMessage());
		}
	}
	
	@Test
	public void testGuardar(){
		
		Cliente cliente = null;
		ClienteDAO clienteDao = null;
		Usuario usuario = null;
		try{
			
			cliente = new Cliente();
			cliente.setCedula("123123");
			cliente.setNombres("Sergio Andres");
			cliente.setApellidos(" Llanos Garcia");
			cliente.setEmail("SergioAndres@gmail.com");
			
			
			usuario = new Usuario();
			usuario.setLogin("elver");
			cliente.setUsuarioCrea(usuario);
			cliente.setFechaCreacion(new Date(Calendar.getInstance().getTimeInMillis()));
			clienteDao = new ClienteDAOImpl();
			clienteDao.guardar(cliente);
		}catch(MyException e){
			e.printStackTrace();
			
		}
	}


}
