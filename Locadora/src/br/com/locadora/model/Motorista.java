package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Motorista extends Pessoa{
	
	private String numeroCNH;
	
	@OneToMany(mappedBy="motorista", targetEntity=Aluguel.class,
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluguel> alugueis;

	public Motorista(){
		this.alugueis = new ArrayList<Aluguel>();
	}
	
	public String getNumeroCNH() {
		return numeroCNH;
	}

	public void setNumeroCNH(String numeroCNH) {
		this.numeroCNH = numeroCNH;
	}

	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
}
