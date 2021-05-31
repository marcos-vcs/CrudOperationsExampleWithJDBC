package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Estoque;

public class CrudOperations {
	
	public static List<Estoque> buscaTudo() throws IOException, SQLException  {
		
			Connection conexao = ConnectBank.getConnection();	
			String sql = "select * from estoque";
			Statement stmt = conexao.createStatement();
			ResultSet resultado = stmt.executeQuery(sql);
			List<Estoque> estoque = new ArrayList<>();
			
			while(resultado.next()) {
				Integer id 			= resultado.getInt("id");
				String  produto 	= resultado.getString("produto");
				String  marca 		= resultado.getString("marca");
				Integer quantidade 	= resultado.getInt("quantidade");
				Double  preco		= resultado.getDouble("preco");
				String  descricao	= resultado.getString("descricao");
				
				estoque.add(new Estoque(id, produto, marca, quantidade, preco, descricao));
			}
			
			conexao.close();
			stmt.close();	
			return estoque;
	}
	
	public static List<Estoque> buscaPeloId(int identificador) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();	
		String sql = "select * from estoque where id = ?";
		PreparedStatement pesquisa = conexao.prepareStatement(sql);
		pesquisa.setInt(1, identificador);
		ResultSet resultado = pesquisa.executeQuery();
		
		List<Estoque> estoque = new ArrayList<>();
		
		
		while(resultado.next()) {
			Integer id 			= resultado.getInt("id");
			String  produto 	= resultado.getString("produto");
			String  marca 		= resultado.getString("marca");
			Integer quantidade 	= resultado.getInt("quantidade");
			Double  preco		= resultado.getDouble("preco");
			String  descricao	= resultado.getString("descricao");
			
			estoque.add(new Estoque(id, produto, marca, quantidade, preco, descricao));
		}
		
		conexao.close();
		pesquisa.close();	
		return estoque;
	}
	
	public static String criaProduto(String produto, String marca, int quantidade, Double preco, String descricao) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "insert into estoque (produto, marca, quantidade, preco, descricao) VALUES (?, ?, ?, ?, ?)";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, produto);
		stmt.setString(2, marca);
		stmt.setInt(3, quantidade);
		stmt.setDouble(4, preco);
		stmt.setString(5, descricao);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String alteraProduto(String produto, Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "update estoque set produto = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, produto);
		stmt.setInt(2, id);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String alteraMarca(String marca, Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "update estoque set marca = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, marca);
		stmt.setInt(2, id);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String alteraQuantidade(Integer quantidade, Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "update estoque set quantidade = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, quantidade);
		stmt.setInt(2, id);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String alteraPreco(Double preco, Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "update estoque set preco = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setDouble(1, preco);
		stmt.setInt(2, id);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String alteraDescricao(String descricao, Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "update estoque set descricao = ? where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setString(1, descricao);
		stmt.setInt(2, id);
		
		if(!stmt.execute()) {
			conexao.close();
			return "INSERIDO COM SUCESSO, VOLTANDO AO MENU...";
		}else {
			conexao.close();
			return "ERRO AO INSERIR PRODUTO!";
		}
		
	}
	
	public static String deletaPeloId(Integer id) throws IOException, SQLException {
		
		Connection conexao = ConnectBank.getConnection();
		String sql = "delete from estoque where id = ?";
		PreparedStatement stmt = conexao.prepareStatement(sql);
		stmt.setInt(1, id);
		
		System.out.println(stmt.execute());
		if(!stmt.execute()) {
			conexao.close();
			return "APAGADO COM SUCESSO...";
		}else {
			conexao.close();
			return "HOUVE ERRO AO TENTAR APAGAR :(";
		}
		
		
	}
	
	
}
