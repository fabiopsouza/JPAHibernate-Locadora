package br.com.locadora.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Fabricante {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String Nome;
	
	@OneToMany(mappedBy="fabricante", targetEntity = ModeloCarro.class, 
			fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ModeloCarro> modelos;
	
	public Fabricante(){
		this.modelos = new ArrayList<ModeloCarro>();
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return Nome;
	}
	public void setNome(String nome) {
		Nome = nome;
	}
	public List<ModeloCarro> getModelos() {
		return modelos;
	}
	public void setModelos(List<ModeloCarro> modelos) {
		this.modelos = modelos;
	}
}
