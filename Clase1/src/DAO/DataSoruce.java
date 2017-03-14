package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import EXCEPTION.MyException;

public class DataSoruce {
	
public static Connection getConnection() throws MyException{
	Connection con = null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection("jdbc:mysql://localhost:3306/BDclase1","root","root");//conecxion con base de datos
	}catch(ClassNotFoundException e){
		throw new MyException("driver no encontrado", e);
	}catch (SQLException e){
		throw new MyException("no puede establecer conexcion", e);
	}
	return con;
}
}
