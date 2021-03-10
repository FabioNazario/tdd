package br.edu.infnet.tdd.modelo;

public class ItemVenda {

	private Produto produto;
	private int quantidade;

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public double getSubtotal() {
		return produto.getValor() * quantidade;
	}

	
	
}
