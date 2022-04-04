package com.carro;

import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class CarroBean {
    
    private Carro carro = new Carro();
    private List<Carro> carros = new ArrayList<>();
    private CarroDAO carroDAO = new CarroDAO();
    
    public void adicionar(){
        try {
            carroDAO.salvar(carro);
            carro = new Carro();
            adicionarMensagem("Salvo!", "Carro salvo com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    
    public void calcular(){
        try {
            carroDAO.calcular(carro);
            carro = new Carro();
            adicionarMensagem("Calculado!", "Carro Calculado com Sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
   
    
    public void MostrarItemClicado(){
    	try {
        carroDAO.MostrarItemClicado(carro);
		carro = new Carro();
		adicionarMensagem("CheckBox!", "Você Selecionou!", FacesMessage.SEVERITY_INFO);
    } catch (ErroSistema ex) {
        adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
    }
    }
   
    
    
    
    public void tabelacalc(){
        try {
            carroDAO.tabelacalc(carro);
            carro = new Carro();
            adicionarMensagem("Calculado BUSCA!", "Carro Calculado BUSCA com Sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    
    
    public void listar(){
        try {
            carros = carroDAO.buscar();
            if(carros == null || carros.size() == 0){
                adicionarMensagem("Nenhum dado encontrado!", "Sua busca não retornou nenhum carro!", FacesMessage.SEVERITY_WARN);
            }
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
  
    
    
    public void deletar(Carro c){
        try {
            carroDAO.deletar(c.getId());
            adicionarMensagem("Deletado!", "Carro deletado com sucesso!", FacesMessage.SEVERITY_INFO);
        } catch (ErroSistema ex) {
            adicionarMensagem(ex.getMessage(), ex.getCause().getMessage(), FacesMessage.SEVERITY_ERROR);
        }
    }
    
    
    
    public void editar(Carro c){
        carro = c;
    }
    
    
    
    
    public void ricci(Carro ric){
        carro = ric;
    }
    
    

    public void adicionarMensagem(String sumario, String detalhe, FacesMessage.Severity tipoErro){
        FacesContext context = FacesContext.getCurrentInstance();
        FacesMessage message = new FacesMessage(tipoErro, sumario, detalhe);
        context.addMessage(null, message);
    }
    
    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public List<Carro> getCarros() {
        return carros;
    }

    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }
    

    public void calcularDadosTela() {

        //VARIÁVEIS GLOBAIS PARA CÁLCULO DESSE MÉTODO
        double valorZero = 0.00;

        //CÁLCULO DO VALOR DA PARCELA
        double valorCarro = carro.getValorcarro();
        double qtdInformada = carro.getValorqtdvezes();
        double valorParcela = valorCarro / qtdInformada;

        if (valorCarro > valorZero && qtdInformada > valorZero ) {
        	carro.setValorparcela(valorParcela);
        } else {
        	carro.setValorparcela(valorZero);
    }
    }
       

}
