package br.com.dio.models;

public abstract class Conta implements IConta {
	private static int agencia = 333;
	private static int numeroDeContas = 1;
	private int numeroDaConta = 1;
	private Cliente cliente;
	
	private double saldo;
	
	
	public Conta(Cliente cliente) {
		this.numeroDaConta = numeroDeContas;
		numeroDeContas++;
		this.cliente = cliente;
	}
	
	public void depositar(double valor) {
		saldo += valor;
	}
	
	;
	
	public void sacar(double valor) {
		saldo -= valor;
	}
	
	;
	
	public double getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	
	public int getNumeroDaConta() {
		return numeroDaConta;
	}
	
	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}
	
	
	@Override
	public String toString() {
		return "Cliente: " + cliente.getNome() + "\nAgencia: " + agencia + "\nNumero da conta: " + numeroDaConta + "\nSaldo: " + saldo;
	}
}
