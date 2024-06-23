package br.com.dio.models;

public class ContaPoupanca extends Conta {
	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato da conta poupanca ===\n");
		System.out.println(super.toString());
		System.out.println("=================================\n");
	}
}
