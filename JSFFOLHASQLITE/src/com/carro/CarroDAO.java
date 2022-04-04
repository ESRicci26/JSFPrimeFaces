package com.carro;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Edilson Salvador Ricci
 */
public class CarroDAO {
    
    public void salvar(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(carro.getId() == null){
                ps = conexao.prepareStatement("INSERT INTO `carro` (`modelo`,`fabricante`,`cor`,`ano`,`valorcarro`,`valorparcela`,`valorqtdvezes`,`valorinss`,`valorirrf`,`valorsalfam`) VALUES (?,?,?,?,?,?,?,?,?,?)");
            } else {
                ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=?, valorcarro=?, valorparcela=?, valorqtdvezes=?, valorinss=?, valorirrf=?, valorsalfam=? where id=?");
                ps.setInt(11, carro.getId());
            }
            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            ps.setDouble(5, carro.getValorcarro());
            ps.setDouble(6, carro.getValorparcela());
            ps.setDouble(7, carro.getValorqtdvezes());
            ps.setDouble(8, carro.getValorinss());
            ps.setDouble(9, carro.getValorirrf());
            ps.setDouble(10, carro.getValorsalfam());
            
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
   
    
    
    public void calcular(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = null;
            if(carro.getId() != null){
             
            	ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=?, valorcarro=?, valorparcela=?, valorqtdvezes=?, valorinss=?, valorirrf=?, valorsalfam=? where id=?");
                ps.setInt(11, carro.getId());
            }
            
          //String cor = carro.getCor();
          //ps.setString(3, carro.getCor());
          double vlcarro = carro.getValorcarro();
          double vlqtdparccarro = carro.getValorqtdvezes();
          double valorparcelacarro = vlcarro / vlqtdparccarro;
            //ps.setString(1, carro.getModelo());
          // ps.setString(2, novofabricante.toString());

            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            ps.setDouble(5, carro.getValorcarro());
            //ps.setDouble(6, carro.getValorparcela());
            ps.setDouble(6, valorparcelacarro);
            ps.setDouble(7, carro.getValorqtdvezes());
            ps.setDouble(8, carro.getValorinss());
            ps.setDouble(9, carro.getValorirrf());
            ps.setDouble(10, carro.getValorsalfam());


            
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
   
    
    
    public void deletar(Integer idCarro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps  = conexao.prepareStatement("delete from carro where id = ?");
            ps.setInt(1, idCarro);
            ps.execute();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao deletar o carro!", ex);
        }
    }
    
    
    
    
    public List<Carro> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from carro");
            ResultSet resultSet = ps.executeQuery();
            List<Carro> carros = new ArrayList<>();
            while(resultSet.next()){
                Carro carro = new Carro();
                carro.setId(resultSet.getInt("id"));
                carro.setModelo(resultSet.getString("modelo"));
                carro.setFabricante(resultSet.getString("fabricante"));
                carro.setCor(resultSet.getString("cor"));
                carro.setAno(resultSet.getDate("ano"));
                carro.setValorcarro(resultSet.getDouble("valorcarro"));
                carro.setValorparcela(resultSet.getDouble("valorparcela"));
                carro.setValorqtdvezes(resultSet.getDouble("valorqtdvezes"));
                carro.setValorinss(resultSet.getDouble("valorinss"));
                carro.setValorirrf(resultSet.getDouble("valorirrf"));
                carro.setValorsalfam(resultSet.getDouble("valorsalfam"));
                
                carros.add(carro);
            }
            FabricaConexao.fecharConexao();
            return carros;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar os carros!",ex);
        }
    }



public void tabelacalc(Carro carro) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = null;
            if(carro.getId() != null){
             
            	ps = conexao.prepareStatement("update carro set modelo=?, fabricante=?, cor=?, ano=?, valorcarro=?, valorparcela=?, valorqtdvezes=?, valorinss=?, valorirrf=?, valorsalfam=? where id=?");
                ps.setInt(11, carro.getId());
            }
            
            
            TabelaLegaisDAO fdao = new TabelaLegaisDAO();
    		ArrayList<TabelaLegais> listaPedro = fdao.listarricci();
    		for (TabelaLegais ptableg : listaPedro){  //INÍCIO FOR
    		
    			
    			
          double vlcarro = carro.getValorcarro();
          double vlqtdparccarro = carro.getValorqtdvezes();
          double valorparcelacarro = vlcarro / vlqtdparccarro;

            ps.setString(1, carro.getModelo());
            ps.setString(2, carro.getFabricante());
            ps.setString(3, carro.getCor());
            ps.setDate(4, new Date(carro.getAno().getTime()));
            ps.setDouble(5, carro.getValorcarro());
            ps.setDouble(6, valorparcelacarro);
            ps.setDouble(7, carro.getValorqtdvezes());
            //ps.setDouble(8, carro.getValorinss());
            ps.setDouble(9, carro.getValorirrf());
            ps.setDouble(10, carro.getValorsalfam());


            
          //CÁLCULO DE DESCONTO DE INSS			
			Double INSSFX02 = ptableg.getTabinssfx002();
			Double INSSFX03 = ptableg.getTabinssfx003();
			Double INSSFX04 = ptableg.getTabinssfx004();
			Double INSSFX05 = ptableg.getTabinssfx005();
			Double INSSFX06 = ptableg.getTabinssfx006();
			Double INSSTETO07 = ptableg.getTabinssteto();
			Double INSSPERC01 = ptableg.getTabinssperc001();
			Double INSSPERC02 = ptableg.getTabinssperc002();
			Double INSSPERC03 = ptableg.getTabinssperc003();

			Double BASEINSS = vlcarro;
			Double VLINSS = 0.00;

			if (BASEINSS <= INSSFX02) {
				VLINSS = BASEINSS * INSSPERC01;
				} else if (BASEINSS >= INSSFX03 && BASEINSS <= INSSFX04) {
				VLINSS = BASEINSS * INSSPERC02;
				} else if (BASEINSS >= INSSFX05 && BASEINSS <= INSSFX06) {
				VLINSS = BASEINSS * INSSPERC03;
				} else {
				VLINSS = INSSTETO07;
				}
			ps.setDouble(8, VLINSS);


            
            ps.execute();
            FabricaConexao.fecharConexao();
            
    		}//FIM DO FOR    
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
        
        
    }

   
    
    
    
    
    public void MostrarItemClicado(Carro carro) throws ErroSistema{      
    	         if (carro.isSelected()){
    	         
    	        int ricciId = carro.getId();
            	String ricciModelo = carro.getModelo();
            	double ricciValorCarro = carro.getValorcarro();
            	System.out.println("ID                "+ricciId);
            	System.out.println("Modelo            "+ricciModelo);
            	System.out.println("Valor             "+ricciValorCarro);

                System.out.println("ID Carro.get      "+carro.getId());
                System.out.println("Modelo Carro.get  "+carro.getModelo());
                System.out.println("Valor Carro.get   "+carro.getValorcarro());                
    	         }else {
    	        	 System.out.println("Você Não Selecionou Nenhum Carro!");
    	   }
    	}



	
}
