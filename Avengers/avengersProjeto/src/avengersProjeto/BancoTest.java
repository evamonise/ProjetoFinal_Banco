package avengersProjeto;

import java.util.Scanner;

public class BancoTest {

	public static void main(String[] args) {
		Scanner S = new Scanner(System.in);		
		int opcao;
		Conta conta = new Conta();
		ContaCorrente contaCorrente = new ContaCorrente();
		ContaPoupanca contaPoupanca = new ContaPoupanca();
		System.out.println("Seja bem vindo(a) ao banco Cubo, para abrir sua conta precisamos de algumas informações.");
		System.out.println();
		System.out.println("Para seguirmos com a criação da sua conta digite: \n1 - para conta corrente \n2 - para conta poupança");
		conta.setTipoConta(S.nextLine());
		if(conta.getTipoConta().equals("1")) {
			contaCorrente.abrirConta();	
		}else if(conta.getTipoConta().equals("2")) {
			contaPoupanca.abrirConta();
		}else {
			System.out.println("");
		}
				
		do {
		
			System.out.println();		
			System.out.println("\n--------------------- MENU ---------------------");
			System.out.println();
			System.out.println("1 - Para acessar o extrato da sua conta.");
			System.out.println("2 - Para mostrar seu Saldo.");
			System.out.println("3 - Para realizar uma transferência.");
			System.out.println("4 - para realizar um deposito.");
			System.out.println("5 - para realizar um pix(conta corrente).");
			System.out.println("6 - para realizar saque.");
			System.out.println("7 - para calcular os juros(conta poupança).");
			System.out.println("8 - para entrar na conta.");
			System.out.println("9 - para sair da conta");
			System.out.println();
			System.out.println("Digite uma das opções: ");			
			opcao = S.nextInt();
			S.nextLine();
			
			switch (opcao) {
			
			case 1:
				if(conta.getTipoConta().equals("1")){
					contaCorrente.imprimirExtrato();
				} else if(conta.getTipoConta().equals("2")) {
					contaPoupanca.imprimirExtrato();
				}
				break;
			
			case 2:
				if(conta.getTipoConta().equals("1")) {
					System.out.printf("Saldo: R$%.2f",contaCorrente.getSaldo());	
				}else if(conta.getTipoConta().equals("2")) {
					System.out.printf("Saldo: R$%.2f",contaPoupanca.getSaldo());
				}
				break;			
			
			case 3:	
				System.out.println("valor da transferencia: ");			
				double valor = S.nextDouble(); 				
				S.nextLine();
				if(conta.getTipoConta().equals("1")) {
					contaCorrente.transferir(valor);	
				}else if(conta.getTipoConta().equals("2")) {
					contaPoupanca.transferir(valor);
				}				
				break;
			
			case 4:
				System.out.println("valor do deposito: ");
				double deposito = S.nextDouble();
				S.nextLine();
				if(conta.getTipoConta().equals("1")) {
					contaCorrente.depositar(deposito);
					System.out.println();
				}else if(conta.getTipoConta().equals("2")) {
					contaPoupanca.depositar(deposito);
				}
				break;
			
			case 5:
				System.out.println("valor do pix: ");
				double pix = S.nextDouble();
				S.nextLine();
				if(conta.getTipoConta().equals("1")) {
					contaCorrente.pixContaCorrente(pix);
					System.out.println();
				}else {
					System.out.println("A ação de realizar um pix está disponivel apenas para a conta corrente.");
		
				}				
				break;
			
			case 6:	
				System.out.println("valor do saque: ");
				double saque = S.nextDouble();
				S.nextLine();
				if(conta.getTipoConta().equals("1")) {
					contaCorrente.sacarContaCorrente(saque);
					System.out.println();
				}else if(conta.getTipoConta().equals("2")) {
					contaPoupanca.sacarContaPoupanca(saque);
				}
				break;

			case 7:	
				if(conta.getTipoConta().equals("2")) {
					contaPoupanca.calcularJuros();
				}else {
					System.out.println("A ação de calcular juros só está disponivel para conta do tipo poupança");
				}					
				break;

			case 8:
				System.out.println("Digite sua senha de acesso: ");
				String senha = S.nextLine();
				if(conta.getTipoConta().equals("1")) {
					contaCorrente.entrarConta(senha);
				}else if(conta.getTipoConta().equals("2")) {
					contaPoupanca.entrarConta(senha);
				}else {
					
				}
				
				break;
			
			case  9 :
				System.out.println("Saindo da conta...");
				break;

			default:
				System.out.println("Opção inválida. Tente novemente");
				break;
			}
		} while (opcao != 9);
	}
}



