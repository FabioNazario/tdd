package br.edu.infnet.tdd.modelo;

import java.util.ArrayList;
import java.util.List;

public class Venda {
	
	private Cliente cliente;
	private List<ItemVenda> itensVenda;

	
	public double getTotal() {
		if(this.getItensVenda() == null) {
			this.setItensVenda(new ArrayList<ItemVenda>());
		}
		double total= 0;

		for (ItemVenda itemVenda : itensVenda) {
			total += itemVenda.getSubtotal();
		}
		
		return total; 
	}
	
	void adicionarProduto(Produto produto, int quantidade) {
		if(this.getItensVenda() == null) {
			this.setItensVenda(new ArrayList<ItemVenda>());
		}
		
		if(produto == null || quantidade <=0) return;
		
		ItemVenda itemVenda = new ItemVenda();
		itemVenda.setProduto(produto);
		itemVenda.setQuantidade(quantidade);
		produto.removerEstoque(quantidade);
		this.getItensVenda().add(itemVenda);
	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemVenda> getItensVenda() {
		return itensVenda;
	}

	public void setItensVenda(List<ItemVenda> itensVenda) {
		this.itensVenda = itensVenda;
	}



}
