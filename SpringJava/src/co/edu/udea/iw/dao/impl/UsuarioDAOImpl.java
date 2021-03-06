/**
 * 
 */
package co.edu.udea.iw.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import co.edu.udea.iw.dao.UsuarioDAO;
import co.edu.udea.iw.dto.Ciudad;
import co.edu.udea.iw.dto.Usuario;
import co.edu.udea.iw.exception.MyException;

/**
 * @author Daniel Pelaez
 *
 */
public class UsuarioDAOImpl implements UsuarioDAO {
	private SessionFactory sessionFactory;
	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}


	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	//retorna un usuario por clave
	public Usuario obtener(String login) throws MyException{
	Usuario usuario=null;
	Session session=null;
	try{
		session=sessionFactory.getCurrentSession();
   
		usuario=(Usuario)session.get(Usuario.class,login);
		
		
	
	}catch(HibernateException e){
		throw new MyException("Error consultando la ciudad",e);
	}
	return usuario;
	}
	
}
