package br.com.locadora.console;

import br.com.locadora.repository.FabricanteRepository;

public class Home {
	
	public static void main(String[] args) {
		FabricanteRepository fr = new FabricanteRepository();
		
		System.out.println(fr.getById(1).getNome());
	}

}
