package br.com.java.diobancodigital;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import lombok.Data;

@Data
public class Banco {

	private String nome;
	private List<Conta> contas;

	public Banco(String nome) {
		this.nome = nome;
	}

	public Set<Cliente> getTodosClientes() {
		Set<Cliente> clientes = new HashSet<Cliente>();
		for (Conta conta : this.contas) {
			clientes.add(conta.getCliente());
		}

		return clientes;
	}

	public void imprimir(Set<Cliente> clientes) {
		System.out.println("=== Todos Clientes ===");
		for (Cliente cliente : clientes) {
			System.out.println("Cliente: " + cliente.getNome());
		}
		System.out.println("======================");
	}

}
