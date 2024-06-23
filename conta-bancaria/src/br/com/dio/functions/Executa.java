package br.com.dio.functions;

import br.com.dio.models.Cliente;
import br.com.dio.models.Conta;
import br.com.dio.models.ContaCorrente;
import br.com.dio.models.ContaPoupanca;

import java.util.HashMap;
import java.util.Scanner;

public class Executa {
	private final HashMap<Integer, Conta> contas = new HashMap<>();
	Scanner scanner = new Scanner(System.in);
	
	
	private void menu() {
		System.out.println("""
		                   1 - Criar conta
		                   2 - Depositar
		                   3 - Sacar
		                   4 - Transferir
		                   5 - Imprimir extrato
		                   6 - Listar contas
		                   7 - Sair
		                   """);
	}
	
	public void iniciar() {
		System.out.println("""
		                   === Bem-vindo ao sistema de contas bancarias ===
		                   \s
		                   Selecione uma opcao:
		                   \s""");
		
		int opcao;
		
		do {
			menu();
			opcao = scanner.nextInt();
			
			switch (opcao) {
				case 1:
					System.out.println("Digite o nome do titular da conta: ");
					String nome = scanner.next();
					System.out.println("Digite o cpf do titular da conta: ");
					String cpf = scanner.next();
					Cliente cliente = new Cliente(nome, cpf);
					System.out.println("Qual o tipo de conta deseja criar? (1 - Corrente, 2 - Poupanca)");
					int tipoConta = scanner.nextInt();
					Conta conta;
					if (tipoConta == 1) {
						conta = new ContaCorrente(cliente);
					}
					else if (tipoConta == 2) {
						conta = new ContaPoupanca(cliente);
					}
					else {
						System.out.println("Opcao invalida");
						break;
					}
					contas.put(conta.getNumeroDaConta(), conta);
					break;
				
				case 2:
					System.out.println("Digite o numero da conta: ");
					int numeroConta = scanner.nextInt();
					System.out.println("Digite o valor a ser depositado: ");
					double valorDeposito = scanner.nextDouble();
					contas.get(numeroConta).depositar(valorDeposito);
					break;
				
				case 3:
					System.out.println("Digite o numero da conta: ");
					int numeroContaSaque = scanner.nextInt();
					System.out.println("Digite o valor a ser sacado: ");
					double valorSaque = scanner.nextDouble();
					contas.get(numeroContaSaque).sacar(valorSaque);
					break;
				
				case 4:
					System.out.println("Digite o numero da conta de origem: ");
					int numeroContaOrigem = scanner.nextInt();
					System.out.println("Digite o numero da conta de destino: ");
					int numeroContaDestino = scanner.nextInt();
					System.out.println("Digite o valor a ser transferido: ");
					double valorTransferencia = scanner.nextDouble();
					contas.get(numeroContaOrigem).transferir(valorTransferencia, contas.get(numeroContaDestino));
					break;
				
				case 5:
					System.out.println("Digite o numero da conta: ");
					int numeroContaExtrato = scanner.nextInt();
					contas.get(numeroContaExtrato).imprimirExtrato();
					break;
				
				case 6:
					for (Conta c : contas.values()) {
						System.out.println(c);
					}
					break;
				
				case 7:
					break;
				
				default:
					System.out.println("Opcao invalida");
					break;
			}
			
		} while (opcao != 7);
		
	}
}
