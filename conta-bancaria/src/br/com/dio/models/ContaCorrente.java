package br.com.dio.models;

public class ContaCorrente extends Conta {
	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}
	
	@Override
	public void imprimirExtrato() {
		System.out.println("=== Extrato da conta corrente ===");
		System.out.println(super.toString());
		System.out.println("=================================\n");
	}
}
