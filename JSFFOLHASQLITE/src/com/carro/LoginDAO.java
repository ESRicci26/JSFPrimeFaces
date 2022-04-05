package com.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginDAO {

	public static boolean validate(String user, String password) throws ErroSistema {
		PreparedStatement ps = null;

		try {
			Connection conexao = FabricaConexao.getConexao();
			ps = conexao.prepareStatement("Select uname, password from Login where uname = ? and password = ?");
			ps.setString(1, user);
			ps.setString(2, password);

			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return true;
			}
		} catch (SQLException ex) {
			System.out.println("Login error -->" + ex.getMessage());
			return false;
		} 
		return false;
	}
}