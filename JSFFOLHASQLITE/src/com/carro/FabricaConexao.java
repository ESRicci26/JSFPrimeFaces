package com.carro;



import com.carro.ErroSistema;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Edilson Salvador Ricci
 */
public class FabricaConexao {
    
    private static Connection conexao;
    private static final String URL_CONEXAO = "jdbc:sqlite:C:\\\\FOPAGRH\\\\\\SISTEMACARROS.db";

    public static Connection getConexao() throws ErroSistema {
        if(conexao == null){
            try {
                Class.forName("org.sqlite.JDBC");
                conexao = DriverManager.getConnection(URL_CONEXAO);
            } catch (SQLException ex) {
                throw new ErroSistema("N�o foi poss�vel conectar ao banco de dados!", ex);
            } catch (ClassNotFoundException ex) {
                throw new ErroSistema("O driver do banco de dados n�o foi encontrado!", ex);
            }
        }
        return conexao;
    }
    
    public static void fecharConexao() throws ErroSistema{
        if(conexao != null){
            try {
                conexao.close();
                conexao = null;
            } catch (SQLException ex) {
                throw new ErroSistema("Erro ao fechar conex�o com o banco de dados!", ex);
            }
        }
    }
    
    
}
