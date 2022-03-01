package br.com.java.diobancodigital;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DioBancoDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(DioBancoDigitalApplication.class, args);

		Init();
	}

	private static void Init() {
		List<Banco> listaBancos = new ArrayList<Banco>();
		List<Cliente> listaClientes = new ArrayList<Cliente>();
		List<ContaCorrente> listaCC = new ArrayList<ContaCorrente>();
		List<ContaPoupanca> listaPoupancas = new ArrayList<ContaPoupanca>();
		List<Conta> contasBanco01 = new ArrayList<Conta>();
		List<Conta> contasBanco02 = new ArrayList<Conta>();

		// Bancos

		// Banco
		listaBancos.add(new Banco("A"));
		listaBancos.add(new Banco("B"));

		// Conta
		listaClientes.add(new Cliente("Eustaquio"));
		listaCC.add(new ContaCorrente(listaClientes.get(0)));
		listaPoupancas.add(new ContaPoupanca(listaClientes.get(0)));

		listaCC.get(0).depositar(100);
		listaCC.get(0).transferir(100, listaPoupancas.get(0));
		listaCC.get(0).imprimirExtrato();
		listaPoupancas.get(0).imprimirExtrato();

		// Conta
		listaClientes.add(new Cliente("Roberval"));
		listaCC.add(new ContaCorrente(listaClientes.get(1)));
		listaPoupancas.add(new ContaPoupanca(listaClientes.get(1)));

		listaCC.get(1).depositar(10500);
		listaCC.get(1).transferir(260, listaPoupancas.get(1));
		listaCC.get(1).imprimirExtrato();
		listaPoupancas.get(1).imprimirExtrato();

		contasBanco01.addAll(listaCC);
		contasBanco01.addAll(listaPoupancas);
		listaBancos.get(0).setContas(contasBanco01);
		listaBancos.get(0).imprimir(listaBancos.get(0).getTodosClientes());

		// Conta
		Cliente leleu = new Cliente("Leleu");
		ContaCorrente ccLeleu = new ContaCorrente(leleu);
		ContaPoupanca poupancaLeleu = new ContaPoupanca(leleu);

		ccLeleu.depositar(450);
		ccLeleu.transferir(75, poupancaLeleu);
		ccLeleu.imprimirExtrato();
		poupancaLeleu.imprimirExtrato();

		contasBanco02 = new ArrayList<Conta>();
		contasBanco02.add(ccLeleu);
		contasBanco02.add(poupancaLeleu);
		listaBancos.get(1).setContas(contasBanco02);

		listaBancos.get(1).imprimir(listaBancos.get(1).getTodosClientes());

	}

}
