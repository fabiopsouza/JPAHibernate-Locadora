package br.com.locadora.model;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
public class Aluguel {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private Calendar dataPedido;
	private Date dataEntrega;
	private Date dataDevolucao;
	private BigDecimal valorTotal;
	
	@ManyToOne
	@JoinColumn(name="carro_id")
	private Carro carro;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private ApoliceSeguro apolice;
	
	@ManyToOne
	@JoinColumn(name="motorista_id")
	private Motorista motorista;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Calendar getDataPedido() {
		return dataPedido;
	}
	public void setDataPedido(Calendar dataPedido) {
		this.dataPedido = dataPedido;
	}
	public Date getDataEntrega() {
		return dataEntrega;
	}
	public void setDataEntrega(Date dataEntrega) {
		this.dataEntrega = dataEntrega;
	}
	public Date getDataDevolucao() {
		return dataDevolucao;
	}
	public void setDataDevolucao(Date dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
	public BigDecimal getValorTotal() {
		return valorTotal;
	}
	public void setValorTotal(BigDecimal valorTotal) {
		this.valorTotal = valorTotal;
	}
	public Carro getCarro() {
		return carro;
	}
	public void setCarro(Carro carro) {
		this.carro = carro;
	}
	public ApoliceSeguro getApolice() {
		return apolice;
	}
	public void setApolice(ApoliceSeguro apolice) {
		this.apolice = apolice;
	}
	public Motorista getMotorista() {
		return motorista;
	}
	public void setMotorista(Motorista motorista) {
		this.motorista = motorista;
	}
}
