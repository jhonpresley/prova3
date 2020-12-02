package dao;

import factory.ConnectionFactory;
import modelo.Carro;
import java.sql.*;
import java.sql.PreparedStatement;

public class CarroDAO {
	private Connection connection;
	Long id;
	String nome;
	String ano;
	String cor;
	String placa;

	public CarroDAO() {
		this.connection = new ConnectionFactory().getConnection();
	}

	public void adiciona(Carro carro) {
		String sql = "INSERT INTO carro(nome,ano,cor,placa) VALUES(?,?,?,?)";
		try {
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, carro.getNome());
			stmt.setString(2, carro.getAno());
			stmt.setString(3, carro.getCor());
			stmt.setString(4, carro.getPlaca());
			stmt.execute();
			stmt.close();
		} catch (SQLException u) {
			throw new RuntimeException(u);
		}

	}

}