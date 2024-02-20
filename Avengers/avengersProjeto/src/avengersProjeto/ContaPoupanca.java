package avengersProjeto;

import java.util.Scanner;

public class ContaPoupanca extends Conta {
	
	
	private double taxaJuro = 0.0617;
	private int tempo;
	private int vezesCompostosPorano = 12;
	
	
	@Override
	public void abrirContaPoupanca() {
		System.out.println();
		this.setSaldo(95.00);
		System.out.println("Olá, " + nomeFormatado() + "! seja bem-vindo(a) ao banco Cubo. Sua conta foi aberta com sucesso!");
		System.out.printf("Você ganhou um saldo bonus de: R$%.2f" ,95.00);
		System.out.printf("\nSaldo : R$%.2f", getSaldo());
		registrarExtrato("Saldo bônus: R$", 95.00);
	}
	
	
	public void sacarContaPoupanca(double valor) {
		if(getSaldo() > 0 && getSaldo()>= valor) {
			System.out.printf("Saldo: R$%.2f",getSaldo());
			System.out.println("\nVocê pode fazer 2 saques no mês.");
			Scanner S = new Scanner(System.in);
			System.out.println("Digite sua senha de acesso para dar continuidade.");
			String validarSenha = S.nextLine();
			if (validarSenha.equals(this.getSenhaAcesso())) {
				System.out.println("Senha correta");
				for (int i = 1; i <= 2; i++) {
					setSaldo(getSaldo()- valor);
					System.out.println();
					System.out.printf("Esse é o seu %d° saque no valor de: R$%.2f realizado com sucesso", i ,valor);
					i++;
				}
				System.out.printf("\nNovo saldo: R$%.2f ",getSaldo());
			}else {
				System.out.println();
				System.out.println("Senha invalida!");
				System.out.printf("\nSaldo: R$%.2f", getSaldo());
			}		
		}else {
			System.out.println();
			System.out.println("Saldo insuficiente");
			System.err.printf("Saldo: R$%.2f  \nValor do Saque: R$%.2f ", getSaldo(),valor);
		}
	}
	
	
	public void calcularJuros() {
		Scanner S = new Scanner(System.in);
		if(getTipoConta().equals("conta poupança")) {
			System.out.println("Informe a unidade de tempo(ano/mês): ");
			String tempo = S.nextLine();			
			if(tempo.equalsIgnoreCase("ano")) {
				System.out.println("Informe a quantidade de ano: ");
				this.tempo = S.nextInt();
				S.nextLine();
				double saldoJuros = getSaldo() * Math.pow(1 + this.taxaJuro/this.vezesCompostosPorano, this.vezesCompostosPorano * this.tempo);
				System.out.println();
				System.out.printf("Saldo Total: R$%.2f com juros de %d ano.", saldoJuros,this.tempo);
				System.out.printf("\nJuros: R$%.2f",saldoJuros - this.getSaldo());
			}else if (tempo.equalsIgnoreCase("mês") || tempo.equalsIgnoreCase("mes")){
				System.out.println("Informe a quantidade de mês: ");
				this.tempo = S.nextInt();
				S.nextLine();
				double saldoJuros = getSaldo() * Math.pow(1 + this.taxaJuro/this.vezesCompostosPorano, this.vezesCompostosPorano * this.tempo/12.0);
				System.out.println();
				System.out.printf("Saldo Total: R$%.2f com juros de %d mês.", saldoJuros,this.tempo);
				System.out.printf("\nJuros: R$%.2f",saldoJuros - getSaldo());
			}else {
				System.out.println("Unidade informada invalida!!");
			}			
		} else {
			System.out.println("Sua conta é uma conta corrente você não consegue calcular seus juros pois essa é uma função de uma conta poupança");
		}
	}


	public double getTaxaJuro() {
		return taxaJuro;
	}


	public void setTaxaJuro(double taxaJuro) {
		this.taxaJuro = taxaJuro;
	}


	public int getTempo() {
		return tempo;
	}


	public void setTempo(int tempo) {
		this.tempo = tempo;
	}


	public int getVezesCompostosPorano() {
		return vezesCompostosPorano;
	}


	public void setVezesCompostosPorano(int vezesCompostosPorano) {
		this.vezesCompostosPorano = vezesCompostosPorano;
	}
}
