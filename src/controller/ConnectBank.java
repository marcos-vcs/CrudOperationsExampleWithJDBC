package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectBank {

	public static Connection getConnection() throws IOException{
		
		try {
			Properties prop = getProperties();
			final String url 	  = prop.getProperty("banco.url");
			final String user 	  = prop.getProperty("banco.user");
			final String password = prop.getProperty("banco.password");
			
			return DriverManager.getConnection(url,user,password);
			
		} catch (SQLException e) {
			System.out.println("Nao foi possivel conectar ao banco ...");
		}
		return null;	
	}
	
	private static Properties getProperties() throws IOException {
		
		Properties prop = new Properties();
		String caminho = "/dataBaseConnectionConfig.properties";
		prop.load(ConnectBank.class.getResourceAsStream(caminho));
		return prop;
		
	}
	
}
