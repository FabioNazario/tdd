package br.edu.infnet.tdd.modelo;

import org.junit.Assert;
import org.junit.Test;



//Criem a gestão do estoque (baixa ao executar a venda) empregando o TDD como abordagem de construção da app
//tem uma regra que só se pode vender produtos que tenham estoque

public class VendaTest {

	@Test
	public void criaVenatest() {
		
		//Monta cenários
		Venda venda = new Venda();
		Cliente cliente = new Cliente("Jose");
		venda.setCliente(cliente);
		Produto produto = new Produto("Xbox One", 3000.0);
		
		//execução da logica
		venda.adicionarProduto(produto, 1);
		
		//validação do teste
		Assert.assertEquals("Jose", venda.getCliente().getNome() );
		Assert.assertEquals("Xbox One", venda.getItensVenda().get(0).getProduto().getNome() );
		Assert.assertEquals(3000.0, venda.getTotal(), 0.0001);
	}
	
	
	@Test
	public void criaVendaVariosProdutostest() {
		
		//Monta cenários
		Venda venda = new Venda();
		Cliente cliente = new Cliente("Jose");
		venda.setCliente(cliente);
		Produto produto1 = new Produto("Xbox One", 3000.0);
		Produto produto2 = new Produto("Xiaomi", 1500.0);
		Produto produto3 = new Produto("iPhone", 12000.0);
		Produto produto4 = new Produto("LG", 100.0);
		
		//execução da logica
		venda.adicionarProduto(produto1, 3);
		venda.adicionarProduto(produto2, 2);
		venda.adicionarProduto(produto3, 1);
		venda.adicionarProduto(produto4, 5);
		
		//validação do teste
		Assert.assertEquals(9000.0, venda.getItensVenda().get(0).getSubtotal(), 0.0001);
		Assert.assertEquals(3000.0, venda.getItensVenda().get(1).getSubtotal(), 0.0001);
		Assert.assertEquals(3000.0, venda.getItensVenda().get(1).getSubtotal(), 0.0001);
		Assert.assertEquals(24500.0, venda.getTotal(), 0.0001);
		
		Assert.assertEquals(4, venda.getItensVenda().size());
		
	}
	
	

	@Test
	public void criaVendaVariosProdutosComNulotest() {
		
		//Monta cenários
		Venda venda = new Venda();
		Cliente cliente = new Cliente(null);
		venda.setCliente(cliente);
		Produto produto1 = new Produto("Xbox One", 3000.0);
		Produto produto2 = new Produto("Xiaomi", 1500.0);
		Produto produto3 = new Produto("iPhone", 12000.0);
		Produto produto4 = new Produto("LG", 100.0);
		
		//execução da logica
		venda.adicionarProduto(null, 3);
		venda.adicionarProduto(produto2, 2);
		venda.adicionarProduto(produto3, 1);
		venda.adicionarProduto(produto4, -5);
		
		//validação do teste
		Assert.assertEquals(3000.0, venda.getItensVenda().get(0).getSubtotal(), 0.0001);
		Assert.assertEquals(12000.0, venda.getItensVenda().get(1).getSubtotal(), 0.0001);
		Assert.assertEquals(15000.0, venda.getTotal(), 0.0001);
		
		Assert.assertEquals(2, venda.getItensVenda().size());
		
	}
	
	
	
	@Test
	public void adicionarRemoverEstoque() {
		
		//Monta cenários
		Venda venda = new Venda();
		Cliente cliente = new Cliente(null);
		venda.setCliente(cliente);
		Produto produto1 = new Produto("Xbox One", 3000.0);
		Produto produto2 = new Produto("Xiaomi", 1500.0);
		Produto produto3 = new Produto("iPhone", 12000.0);
		Produto produto4 = new Produto("LG", 100.0);
		
		produto1.adicionarEstoque(5);
		produto2.adicionarEstoque(6);
		produto3.adicionarEstoque(7);
		produto4.adicionarEstoque(8);
		
		//execução da logica
		venda.adicionarProduto(produto1, 3);
		venda.adicionarProduto(produto2, 2);
		venda.adicionarProduto(produto3, 1);
		venda.adicionarProduto(produto4, 5);
		
		//validação do teste
		Assert.assertEquals(2, produto1.getEstoque());
		Assert.assertEquals(4, produto2.getEstoque());
		Assert.assertEquals(6, produto3.getEstoque());
		Assert.assertEquals(3, produto4.getEstoque());
	}

}
