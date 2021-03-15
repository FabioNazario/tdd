package br.edu.infnet.tdd.modelo;

public class Produto {
	
	private String nome;
	private double valor;
	private int estoque;

	public Produto(String nome, double valor) {
		this.setNome(nome);
		this.setValor(valor);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public void adicionarEstoque(int quantidade) {
		this.estoque += quantidade; 
	}
	
	public void removerEstoque(int quantidade) {
		this.estoque -= quantidade; 
	}

	public int getEstoque() {
		return estoque;
	}
	

}
