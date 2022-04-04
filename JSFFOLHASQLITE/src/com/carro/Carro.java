package com.carro;



import java.util.Date;
import java.util.Objects;

public class Carro {
    
    private Integer id;
    private String modelo;
    private String fabricante;
    private String cor;
    private Date ano;
    private double valorcarro;
    private double valorparcela;
    private double valorqtdvezes;
    private boolean selected;
    private double valorinss;
    private double valorirrf;
    private double valorsalfam;
        
    
    public double getValorinss() {
		return valorinss;
	}

	public void setValorinss(double valorinss) {
		this.valorinss = valorinss;
	}

	public double getValorirrf() {
		return valorirrf;
	}

	public void setValorirrf(double valorirrf) {
		this.valorirrf = valorirrf;
	}

	public double getValorsalfam() {
		return valorsalfam;
	}

	public void setValorsalfam(double valorsalfam) {
		this.valorsalfam = valorsalfam;
	}

	
	public double getValorcarro() {
		return valorcarro;
	}

	public void setValorcarro(double valorcarro) {
		this.valorcarro = valorcarro;
	}

	public double getValorparcela() {
		return valorparcela;
	}

	public void setValorparcela(double valorparcela) {
		this.valorparcela = valorparcela;
	}

	public double getValorqtdvezes() {
		return valorqtdvezes;
	}

	public void setValorqtdvezes(double valorqtdvezes) {
		this.valorqtdvezes = valorqtdvezes;
	}

	

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Date getAno() {
        return ano;
    }

    public void setAno(Date ano) {
        this.ano = ano;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Carro other = (Carro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
    
    public boolean isSelected() {
        return selected;
  }

  public void setSelected(boolean selected) {
        this.selected = selected;
  }

}
