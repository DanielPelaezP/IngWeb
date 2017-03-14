package DAO.imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.CiudadDAO;
import DAO.DataSoruce;
import DTO.Ciudad;
import EXCEPTION.MyException;

public class CiudadDAOImp implements CiudadDAO {
	
	public List<Ciudad> obtener() throws MyException{
	PreparedStatement ps = null;
	Connection con = null;
	ResultSet rs = null;
	List<Ciudad> lista = new ArrayList<Ciudad>();
	try{
		con = DataSoruce.getConnection();
		ps = con.prepareStatement("Select * From ciudades");
		rs = ps.executeQuery();
		while(rs.next()){
		Ciudad ciudad = new Ciudad();
		ciudad.setCodigo(rs.getLong("Codigo"));
		ciudad.setNombre(rs.getString("Nombre"));
		ciudad.setCodigoArea(rs.getString("CodigoArea"));
		lista.add(ciudad);
		}
	}catch(SQLException e){
		throw new MyException("error consultado", e);
	}finally{
		try{
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con !=null);
				con.close();
		}catch(SQLException e){
			throw new MyException("error cerrando", e);
		}
	}
	return lista;
	}
	public Ciudad obtener(Long codigo) throws MyException{
		
		PreparedStatement ps = null;
		Connection con = null;
		ResultSet rs = null;
		Ciudad ciudad = null;
		try{
			con = DataSoruce.getConnection();
			ps = con.prepareStatement("Select * From ciudades WHERE codigo =?");
			ps.setLong(1,codigo);//se evita SQL inyection
			rs = ps.executeQuery();
			if(rs.next()){//se toma solo una cuidad porque estoy buscando la ciudad por clave primaria
				ciudad = new Ciudad();
				ciudad.setCodigo(rs.getLong("Codigo"));
				ciudad.setNombre(rs.getString("Nombre"));
				ciudad.setCodigoArea(rs.getString("CodigoArea"));
			}
		}catch(SQLException e ){
		throw new MyException("error consultado", e);
	}finally{
		try{
			if(rs != null)
				rs.close();
			if(ps != null)
				ps.close();
			if(con !=null);
				con.close();
		}catch(SQLException e){
			throw new MyException("error cerrando", e);
		}
	}
	return ciudad;
	}
	
}
