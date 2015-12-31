package br.com.locadora.console;

import java.math.BigDecimal;
import java.util.GregorianCalendar;

import javax.persistence.EntityManager;

import br.com.locadora.model.Acessorio;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.ApoliceSeguro;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Categoria;
import br.com.locadora.model.Fabricante;
import br.com.locadora.model.Funcionario;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.model.Motorista;
import br.com.locadora.model.Sexo;

public class Builder {

	public static Motorista motoristaBuild(){
		Motorista motorista = new Motorista();
		motorista.setNome("Fabio souza");
		motorista.setDataNascimento(new GregorianCalendar(1995,04,23).getTime());
		motorista.setCpf("112.223.122-12");
		motorista.setSexo(Sexo.MASCULINO);
		motorista.setNumeroCNH("123456789");
		return motorista;
	}
	
	public static Funcionario funcionarioBuild(){
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Maria Clara");
		funcionario.setDataNascimento(new GregorianCalendar(1995,04,23).getTime());
		funcionario.setCpf("234.234.233-11");
		funcionario.setSexo(Sexo.FEMININO);
		funcionario.setMatricula("1234");
		return funcionario;
	}
	
	public static Aluguel aluguelBuild(){
		Aluguel aluguel = new Aluguel();
		aluguel.setDataPedido(new GregorianCalendar());
		aluguel.setDataEntrega(new GregorianCalendar().getTime());
		aluguel.setDataDevolucao(new GregorianCalendar(2016,01,15).getTime());
		aluguel.setValorTotal(new BigDecimal(800));
		return aluguel;
	}
	
	public static ApoliceSeguro apoliceBuild(){
		ApoliceSeguro apolice = new ApoliceSeguro();
		apolice.setValorFranquia(new BigDecimal(100));
		apolice.setProtecaoTerceiro(true);
		apolice.setProtecaoCausasNaturais(true);
		apolice.setProtecaoRoubo(false);
		return apolice;
	}
	
	public static Carro carroBuild(){
		Carro carro = new Carro();
		carro.setPlaca("abc-1234");
		carro.setChassi("123465");
		carro.setCor("Prata");
		carro.setValorDiaria(new BigDecimal(240));
		return carro;
	}
	
	public static Acessorio acessorioBuild(){
		Acessorio acessorio = new Acessorio();
		acessorio.setDescricao("Carregador de celular");
		return acessorio;
	}
	
	public static ModeloCarro modeloBuild(){
		ModeloCarro modelo = new ModeloCarro();
		modelo.setDescricao("Logan 2015");
		modelo.setCategoria(Categoria.SEDAN_MEDIO);
		return modelo;
	}
	
	public static Fabricante fabricanteBuild(){
		Fabricante fabricante = new Fabricante();
		fabricante.setNome("Chevrolet");
		return fabricante;
	}
	
	public static void DataBaseBuild(EntityManager em){
		Funcionario funcionario = Builder.funcionarioBuild();
		em.persist(funcionario);
		
		Motorista motorista = Builder.motoristaBuild();
		em.persist(motorista);
		em.flush();
		
		Acessorio acessorio = Builder.acessorioBuild();
		em.persist(acessorio);
		em.flush();
		
		Fabricante fabricante = Builder.fabricanteBuild();
		em.persist(fabricante);
		em.flush();
		
		ModeloCarro modelo = Builder.modeloBuild();
		modelo.setFabricante(fabricante);
		em.persist(modelo);
		em.flush();
		
		Carro carro = Builder.carroBuild();
		carro.getAcessorios().add(acessorio);
		carro.setModelo(modelo);
		em.persist(carro);
		em.flush();
		
		Aluguel aluguel = Builder.aluguelBuild();
		aluguel.setMotorista(motorista);
		aluguel.setCarro(carro);
		em.persist(aluguel);
		
		ApoliceSeguro apolice = Builder.apoliceBuild();
		apolice.setAluguel(aluguel);
		em.persist(apolice);
	}
}
