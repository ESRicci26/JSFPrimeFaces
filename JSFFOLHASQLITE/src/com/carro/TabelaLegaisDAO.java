package com.carro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.carro.TabelaLegais;
import com.carro.FabricaConexao;
import com.carro.TabelaLegaisDAO;




public class TabelaLegaisDAO {

	
	public ArrayList<TabelaLegais> listarricci()throws SQLException, ErroSistema{
		try {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT * FROM TabelaLegaisCLT WHERE tabid=1");
		
		
 	    Connection conexao = FabricaConexao.getConexao();
		
		PreparedStatement comando = conexao.prepareStatement(sql.toString());
				
		ResultSet resultado = comando.executeQuery();
		 
		ArrayList<TabelaLegais>listaTL = new ArrayList<TabelaLegais>();
		
		
		
		while(resultado.next()){  //INÍCIO WHILE
			TabelaLegais TabLeg = new TabelaLegais();
			TabLeg.setTabid(resultado.getInt("tabid"));
			TabLeg.setTabinssfx001(resultado.getDouble("tabinssfx001"));
			TabLeg.setTabinssfx002(resultado.getDouble("tabinssfx002"));
			TabLeg.setTabinssfx003(resultado.getDouble("tabinssfx003"));
			TabLeg.setTabinssfx004(resultado.getDouble("tabinssfx004"));
			TabLeg.setTabinssfx005(resultado.getDouble("tabinssfx005"));
			TabLeg.setTabinssfx006(resultado.getDouble("tabinssfx006"));
			TabLeg.setTabinssteto(resultado.getDouble("tabinssteto"));
			TabLeg.setTabinssperc001(resultado.getDouble("tabinssperc001"));
			TabLeg.setTabinssperc002(resultado.getDouble("tabinssperc002"));
			TabLeg.setTabinssperc003(resultado.getDouble("tabinssperc003"));
			/*
			TabLeg.setTabirrffx001(resultado.getDouble("tabirrffx001"));
			TabLeg.setTabirrffx002(resultado.getDouble("tabirrffx002"));
			TabLeg.setTabirrffx003(resultado.getDouble("tabirrffx003"));
			TabLeg.setTabirrffx004(resultado.getDouble("tabirrffx004"));
			TabLeg.setTabirrffx005(resultado.getDouble("tabirrffx005"));
			TabLeg.setTabirrffx006(resultado.getDouble("tabirrffx006"));
			TabLeg.setTabirrffx007(resultado.getDouble("tabirrffx007"));
			TabLeg.setTabirrffx008(resultado.getDouble("tabirrffx008"));
			TabLeg.setTabirrvaldep(resultado.getDouble("tabirrfvaldep"));
			TabLeg.setTabirrfperc001(resultado.getDouble("tabirrfperc001"));
			TabLeg.setTabirrfperc002(resultado.getDouble("tabirrfperc002"));
			TabLeg.setTabirrfperc003(resultado.getDouble("tabirrfperc003"));
			TabLeg.setTabirrfperc004(resultado.getDouble("tabirrfperc004"));
			TabLeg.setTabirrfvalded001(resultado.getDouble("tabirrfvalded001"));
			TabLeg.setTabirrfvalded002(resultado.getDouble("tabirrfvalded002"));
			TabLeg.setTabirrfvalded003(resultado.getDouble("tabirrfvalded003"));
			TabLeg.setTabirrfvalded004(resultado.getDouble("tabirrfvalded004"));
			TabLeg.setTabirrfvalisento(resultado.getDouble("tabirrfvalisento"));
			TabLeg.setTabsalfamfx001(resultado.getDouble("tabsalfamfx001"));
			TabLeg.setTabsalfamfx002(resultado.getDouble("tabsalfamfx002"));
			TabLeg.setTabsalfamfx003(resultado.getDouble("tabsalfamfx003"));
			TabLeg.setTabsalfamfx004(resultado.getDouble("tabsalfamfx004"));
			TabLeg.setTabsalfamvl001(resultado.getDouble("tabsalfamvl001"));
			TabLeg.setTabsalfamvl002(resultado.getDouble("tabsalfamvl002"));
			*/

			
			listaTL.add(TabLeg);
		}  //FIM WHILE

		return listaTL;
		
		} catch (SQLException ex) {
			//ex.printStackTrace();
			System.out.printf("Não foi possível conectar ao banco de dados!", ex);
			

		}
		return null;
		
		
	}


	
	public void salvar(TabelaLegais TabRicci) throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps;
            if(TabRicci.getTabid() == null && TabRicci.getTabinssteto() > 0){
                ps = conexao.prepareStatement("INSERT INTO `TabelaLegaisCLT` (`tabinssfx001`,`tabinssfx002`,`tabinssfx003`,`tabinssfx004`,`tabinssfx005`,`tabinssfx006`,`tabinssteto`,`tabinssperc001`,`tabinssperc002`,`tabinssperc003`) VALUES (?,?,?,?,?,?,?,?,?,?)");

            } else {
                ps = conexao.prepareStatement("UPDATE TabelaLegaisCLT SET tabinssfx001=?, tabinssfx002=?, tabinssfx003=?, tabinssfx004=?, tabinssfx005=?, tabinssfx006=?, tabinssteto=?, tabinssperc001=?, tabinssperc002=?, tabinssperc003=? where tabid=?");
                ps.setInt(11, TabRicci.getTabid());
            }
            ps.setDouble(1, TabRicci.getTabinssfx001());
            ps.setDouble(2, TabRicci.getTabinssfx002());
            ps.setDouble(3, TabRicci.getTabinssfx003());
            ps.setDouble(4, TabRicci.getTabinssfx004());
            ps.setDouble(5, TabRicci.getTabinssfx005());
            ps.setDouble(6, TabRicci.getTabinssfx006());
            ps.setDouble(7, TabRicci.getTabinssteto());
            ps.setDouble(8, TabRicci.getTabinssperc001());
            ps.setDouble(9, TabRicci.getTabinssperc002());
            ps.setDouble(10, TabRicci.getTabinssperc003());
            
            ps.execute();
            FabricaConexao.fecharConexao();
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao tentar salvar!", ex);
        }
    }
   
	
	
	
	public List<TabelaLegais> buscar() throws ErroSistema{
        try {
            Connection conexao = FabricaConexao.getConexao();
            PreparedStatement ps = conexao.prepareStatement("select * from TabelaLegaisCLT");
            ResultSet resultSet = ps.executeQuery();
            List<TabelaLegais> TabLegais = new ArrayList<>();
            while(resultSet.next()){
                TabelaLegais TabLegaisRicci = new TabelaLegais();
                TabLegaisRicci.setTabid(resultSet.getInt("tabid"));
                TabLegaisRicci.setTabinssfx001(resultSet.getDouble("tabinssfx001"));
                TabLegaisRicci.setTabinssfx002(resultSet.getDouble("tabinssfx002"));
                TabLegaisRicci.setTabinssfx003(resultSet.getDouble("tabinssfx003"));
                TabLegaisRicci.setTabinssfx004(resultSet.getDouble("tabinssfx004"));
                TabLegaisRicci.setTabinssfx005(resultSet.getDouble("tabinssfx005"));
                TabLegaisRicci.setTabinssfx006(resultSet.getDouble("tabinssfx006"));
                TabLegaisRicci.setTabinssteto(resultSet.getDouble("tabinssteto"));
                TabLegaisRicci.setTabinssperc001(resultSet.getDouble("tabinssperc001"));
                TabLegaisRicci.setTabinssperc002(resultSet.getDouble("tabinssperc002"));
                TabLegaisRicci.setTabinssperc003(resultSet.getDouble("tabinssperc003"));
                
                TabLegais.add(TabLegaisRicci);
            }
            FabricaConexao.fecharConexao();
            return TabLegais;
            
        } catch (SQLException ex) {
            throw new ErroSistema("Erro ao buscar Tabelas!",ex);
        }
    }


	
}
