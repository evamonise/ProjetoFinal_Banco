package avengersProjeto;

import java.util.Scanner;

public class ContaCorrente extends Conta {

	private double pix;
	
	@Override
	public void abrirContaCorrente() {
		System.out.println();
		setSaldo(getSaldo() + 75.00);
		System.out.println("Olá, "+ nomeFormatado() +"! seja bem-vindo(a) ao banco Cubo. Sua conta foi aberta com sucesso!");
		System.out.printf("Você ganhou um saldo bônus de: R$%.2f",75.00);
		System.out.printf("\nSaldo: R$%.2f" ,getSaldo());
		registrarExtrato("Saldo bônus: R$", 75.00);
	}
	
	public void pixContaCorrente(double valor) {
		Scanner S = new Scanner(System.in);
		System.out.println("Digite sua senha de acesso para dar continuidade.");
		String validarSenha = S.nextLine();
		if (validarSenha.equals(this.getSenhaAcesso())) {
			System.out.println("Senha correta");
			if (getSaldo() > 0 && getSaldo() >= valor) {
				System.out.printf("Saldo: R$%.2f", getSaldo());
				setSaldo(getSaldo() - valor);
				System.out.println();
				System.out.printf("\nPix no valor de R$%.2f realizado com sucesso", valor);
				System.out.printf("\nNovo Saldo: R$ %.2f", getSaldo());
			} else {
				System.out.printf("Saldo insulficiente!!\nSaldo: R$%.2f \nPix: R$%.2f", getSaldo(), valor);
				System.out.println();
				System.out.println("Para dar continuidade ao saque você pode usar seu saque especial ou fazer um deposito.");
				System.out.println("Digite: \n1 - Continuar com o saque. \n2 - fazer um deposito para continuar. \n3 - Cancelar o saque");
				int opcao = S.nextInt();
				S.nextLine();
				
				if (opcao == 1) {
					setSaldo(getSaldo() - valor);
					System.out.println();
					System.out.printf("Seu pix no valor de R$%.2f foi concluido com sucesso usando o saque especial.",valor);
					System.out.printf("\nNovo Saldo: R$ %.2f", getSaldo());
				
				}else if(opcao == 2) {
					System.out.println("Valor do deposito: ");
					double deposito = S.nextDouble();
					S.nextLine();
					setSaldo(getSaldo()+ deposito);
					System.out.println();
					System.out.printf("\nPix no valor de R$%.2f realizado com sucesso", valor);
					System.out.printf("\nNovo Saldo: R$ %.2f", getSaldo());
					
					if(getSaldo() > 0 && getSaldo() >= valor) {
						System.out.printf("Saldo: R$%.2f", getSaldo());
						setSaldo(getSaldo() - valor);
						System.out.println();
						System.out.printf("\nPix no valor de R$%.2f realizado com sucesso", valor);
						System.out.printf("\nNovo Saldo: R$ %.2f", getSaldo());
					
						while(deposito < valor){
						System.out.println("Seu saldo ainda é insulficiente!");
						System.out.printf("Saldo: R$%.2f", getSaldo());
						Conta conta = new Conta();
						conta.depositar(deposito);	
						}
					}							
				}else {
					System.out.println("Seu pix foi concelado com sucesso.");
				}	
			}
		}else {
			System.out.println("Senha incorreta");
		}	
		}
		
				
	public void sacarContaCorrente(double valor){

		if (this.getSaldo() > 0 && this.getSaldo() >= valor) {
			System.out.printf("Saldo: R$%.2f", this.getSaldo());
			this.setSaldo(this.getSaldo() - valor);			
			System.out.printf("\nSaque no valor de R$%.2f realizado com sucesso", valor);
			System.out.printf("\nNovo Saldo: R$ %.2f", this.getSaldo());
		} else {
			Scanner S = new Scanner(System.in);
			System.out.printf("Saldo insulficiente!!\nSaldo: R$%.2f \nSaque: R$%.2f", this.getSaldo(), valor);
			System.out.println();
			System.out.println("Para dar continuidade ao saque você pode usar seu saque especial.");
			System.out.println("Digite: \n1 - Continuar com o saque \n2 - Cancelar o saque");
			int opcao = S.nextInt();
			S.nextLine();
			if (opcao == 1) {
				this.setSaldo(this.getSaldo() - valor);
				System.out.printf("Seu saque no valor de R$%.2f foi concluido com sucesso usando o saque especial.",valor);
				System.out.printf("\nNovo Saldo: R$ %.2f", this.getSaldo());
			} else {
				System.out.println("Seu saque foi concelado com sucesso.");
			}		
		}		
	}

	public double getPix() {
		return pix;
	}

	public void setPix(double pix) {
		this.pix = pix;
	}
}
