package br.com.locadora.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class ApoliceSeguro {

	@Id
	private int aluguelId;
	private BigDecimal valorFranquia;
	private Boolean protecaoTerceiro;
	private Boolean protecaoCausasNaturais;
	private Boolean protecaoRoubo;
	
	@MapsId
	@OneToOne
	@JoinColumn(name="aluguelId")
	private Aluguel aluguel;

	public int getAluguelId() {
		return aluguelId;
	}
	public void setAluguelId(int aluguelId) {
		this.aluguelId = aluguelId;
	}
	public BigDecimal getValorFranquia() {
		return valorFranquia;
	}
	public void setValorFranquia(BigDecimal valorFranquia) {
		this.valorFranquia = valorFranquia;
	}
	public Boolean getProtecaoTerceiro() {
		return protecaoTerceiro;
	}
	public void setProtecaoTerceiro(Boolean protecaoTerceiro) {
		this.protecaoTerceiro = protecaoTerceiro;
	}
	public Boolean getProtecaoCausasNaturais() {
		return protecaoCausasNaturais;
	}
	public void setProtecaoCausasNaturais(Boolean protecaoCausasNaturais) {
		this.protecaoCausasNaturais = protecaoCausasNaturais;
	}
	public Boolean getProtecaoRoubo() {
		return protecaoRoubo;
	}
	public void setProtecaoRoubo(Boolean protecaoRoubo) {
		this.protecaoRoubo = protecaoRoubo;
	}
	public Aluguel getAluguel() {
		return aluguel;
	}
	public void setAluguel(Aluguel aluguel) {
		this.aluguel = aluguel;
	}
}
