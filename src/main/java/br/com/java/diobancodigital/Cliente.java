package br.com.java.diobancodigital;

import lombok.Data;

@Data
public class Cliente {

	private String nome;

	public Cliente(String nome) {
		this.nome = nome;
	}

}
