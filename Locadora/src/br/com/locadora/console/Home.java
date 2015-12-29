package br.com.locadora.console;

import javax.persistence.EntityManager;

import br.com.locadora.model.Acessorio;
import br.com.locadora.model.Aluguel;
import br.com.locadora.model.ApoliceSeguro;
import br.com.locadora.model.Carro;
import br.com.locadora.model.Fabricante;
import br.com.locadora.model.Funcionario;
import br.com.locadora.model.ModeloCarro;
import br.com.locadora.model.Motorista;
import br.com.locadora.util.JPAUtil;

public class Home {
	
	public static void main(String[] args) {
		EntityManager em = new JPAUtil().getEntityManager();
		em.getTransaction().begin();
		
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
		
		em.getTransaction().commit();
		em.close();		
	}

}
