package com.carro;

import javax.faces.bean.ManagedBean; 


@ManagedBean  
public class InputMaskBean {  

private InputMask mask = new InputMask();


public String getDate() {  
	return mask.getDate();  
}  
public void setDate(String date) {  
mask.setDate(date);
}  

public String getPhone() {  
	return mask.getPhone();  
}  
public void setPhone(String phone) {  
	mask.setPhone(phone);  
}

public String getCpf() {
	return mask.getCpf();
}
public void setCpf(String cpf) {
	mask.setCpf(cpf);
}

public double getValorcarro() {
	return mask.getValorcarro();
}
public void setValorcarro(double valorcarro) {
	mask.setValorcarro(valorcarro);
}

public String getCnpj() {
	return mask.getCnpj();
}
public void setCnpj(String cnpj) {
	mask.setCnpj(cnpj);
}

public String getCep() {
	return mask.getCep();
}
public void setCep(String cep) {
	mask.setCep(cep);
}

public double getQtdparcela() {
	return mask.getQtdparcela();
}
public void setQtdparcela(double qtdparcela) {
	mask.setQtdparcela(qtdparcela);
}

public double getValormes() {
	return mask.getValormes();
}
public void setValormes(double valormes) {
	mask.setValormes(valormes);
}


public void calcularDadosTela() {

    //VARIÁVEIS GLOBAIS PARA CÁLCULO DESSE MÉTODO
    double valorZero = 0.00;
    
    double vlCarro = mask.getValorcarro();
    double qtParcela = mask.getQtdparcela();
    double vlMes = mask.getValormes();
    //vlMes = vlCarro / qtParcela;
    //mask.setValormes(vlMes);
    
    //CÁLCULO DO VALOR DA PARCELA
    if (vlCarro > valorZero && qtParcela > valorZero ) {
    	vlMes = vlCarro / qtParcela;
    	mask.setValormes(vlMes);
    } else {
    	mask.setValormes(valorZero);
}
  
}


}