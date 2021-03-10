package br.edu.infnet.tdd.modelo;

public class Cliente {
	
	private String nome;

	public Cliente(String nome) {
		this.setNome(nome);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
