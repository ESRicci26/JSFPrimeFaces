package com.carro;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name = "listenerBean")
@SessionScoped
public class ListenerBean implements Serializable {
	private static final long serialVersionUID = 1L;

	private Listener listener = new Listener();

	
	public String getName() {
		return listener.getName();
	}
	public void setName(String name) {
		listener.setName(name);
	}

	public String getLastName() {
		return listener.getLastName();
	}
	public void setLastName(String lastName) {
		listener.setLastName(lastName);
	}
	
	public int getNumero1() {
		return listener.getNumero1();
	}
	public void setNumero1(int numero1) {
		listener.setNumero1(numero1);
	}
	public int getNumero2() {
		return listener.getNumero2();
	}
	public void setNumero2(int numero2) {
		listener.setNumero2(numero2);
	}
	public int getResultado() {
		return listener.getResultado();
	}
	public void setResultado(int resultado) {
		listener.setResultado(resultado);
	}
	
	
	// Formulário "Ajax Listener" do arquivo "ajax-listener.xhtml"
	public void hojeEvent() {
		listener.getLastName().toUpperCase();
	}

	// Ajax com Ação no Botão Executar SOMAR form4
	public void somaCampo() {
		int res1 = listener.getResultado();
		int num1 = listener.getNumero1();
		int num2 = listener.getNumero2();
		res1 = num1 + num2;
		listener.setResultado(res1);
	}


}