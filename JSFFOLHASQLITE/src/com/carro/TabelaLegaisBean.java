package com.carro;

import com.carro.TabelaLegaisDAO;
import com.carro.TabelaLegais;
import com.carro.ErroSistema;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;


@ManagedBean
@SessionScoped
public class TabelaLegaisBean {
	
	private TabelaLegais TabRicci = new TabelaLegais();
	private List<TabelaLegais> TabLegais = new ArrayList<>();
	private TabelaLegaisDAO TabLegaisDAO = new TabelaLegaisDAO();
	
	
	
	public void adicionar(){
		try {
		TabLegaisDAO.salvar(TabRicci);
		TabRicci = new TabelaLegais();
		adicionarMensagem("Salvo!", "Tabela salva com sucesso!", FacesMessage.SEVERITY_INFO);
		} catch (ErroSistema ex) {
		adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
		}
		}

	
	
	public void listar(){
        try {
        	TabLegais = TabLegaisDAO.buscar();
            if(TabLegais == null || TabLegais.size() == 0){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum carro!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }


	
	public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }
	
	
	
	public void editar(TabelaLegais tl){
		TabRicci = tl;
		}

	
	
	public List<TabelaLegais> getTabLegais() {
		return TabLegais;
	}

	
	
	public void setTabLegais(List<TabelaLegais> tabLegais) {
		TabLegais = tabLegais;
	}
    
	
	
	public TabelaLegais getTabRicci() {
		return TabRicci;
	}


	
	public void setTabRicci(TabelaLegais tabRicci) {
		TabRicci = tabRicci;
	}


}
