package br.com.locadora.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Carro {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String placa;
	private String chassi;
	private String cor;
	private BigDecimal valorDiaria;
	
	@ManyToOne
	@JoinColumn(name="modelo_id")
	private ModeloCarro modelo;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="acessorio_carro", joinColumns = {
			@JoinColumn(name="carro_id", nullable=false, updatable=false) 
		}, inverseJoinColumns = {
			@JoinColumn(name="acessorio_id", nullable=false, updatable=false)
		})
	private List<Acessorio> acessorios;
	
	@OneToMany(mappedBy="carro", targetEntity = Aluguel.class,
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aluguel> alugueis;
	
	public Carro(){
		this.acessorios = new ArrayList<Acessorio>();
		this.alugueis = new ArrayList<Aluguel>();
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getChassi() {
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public BigDecimal getValorDiaria() {
		return valorDiaria;
	}

	public void setValorDiaria(BigDecimal valorDiaria) {
		this.valorDiaria = valorDiaria;
	}

	public ModeloCarro getModelo() {
		return modelo;
	}

	public void setModelo(ModeloCarro modelo) {
		this.modelo = modelo;
	}

	public List<Acessorio> getAcessorios() {
		return acessorios;
	}
	
	public void setAcessorios(List<Acessorio> acessorios) {
		this.acessorios = acessorios;
	}
	
	public List<Aluguel> getAlugueis() {
		return alugueis;
	}

	public void setAlugueis(List<Aluguel> alugueis) {
		this.alugueis = alugueis;
	}
}
