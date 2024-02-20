package avengersProjeto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Conta implements AcoesConta {

	
	protected String nome;
	protected Endereco endereco;
	protected String cpf;
	protected String numero;
	protected String tipoConta;
	protected String senhaAcesso;
	protected double saldo;
	protected List<String> extrato;
	protected String numAgencia = "4562";
	protected String numConta;

	
	public Conta() {
		this.endereco = new Endereco();
		this.extrato = new ArrayList<>();
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(String tipoConta) {
		this.tipoConta = tipoConta;
	}

	public String getSenhaAcesso() {
		return senhaAcesso;
	}

	public void setSenhaAcesso(String senhaAcesso) {
		this.senhaAcesso = senhaAcesso;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<String> getExtrato() {
		return extrato;
	}

	public void setExtrato(List<String> extrato) {
		this.extrato = extrato;
	}

	public String getNumAgencia() {
		return numAgencia;
	}

	public void setNumAgencia(String numAgencia) {
		this.numAgencia = numAgencia;
	}

	public String getNumConta() {
		return numConta;
	}

	public void setNumConta(String numConta) {
		this.numConta = numConta;
	}

	public String geradorConta() {
		Random random = new Random();
		int digito1 = random.nextInt(10);
		int digito2 = random.nextInt(10);
		int digito3 = random.nextInt(10);
		int digito4 = random.nextInt(10);
		int digito5 = random.nextInt(10);
		String numFormatado = String.format("%d%d%d%d-%d", digito1, digito2, digito3, digito4, digito5);
		this.numConta = numFormatado;
		return numFormatado;
	}

	public void abrirConta() {
		Scanner S = new Scanner(System.in);
		System.out.println("--------------------------- ABRIR CONTA ---------------------------");
		System.out.println("Informe alguns dados pessoais.");
		System.out.println();
		System.out.println("Nome completo: ");
		this.setNome(S.nextLine());
		System.out.println("CPF: ");
		this.setCpf(S.nextLine());
		System.out.println("Número de celular(+DD): ");
		this.setNumero(S.nextLine());
		this.endereco.cadastrarEndereco();
		System.out.println("Senha de acesso(6 digitos): ");
		this.setSenhaAcesso(S.nextLine());
		System.out.println("Qual é o tipo da sua conta: conta corrente ou conta poupança ");
		this.setTipoConta(S.nextLine());
		
		if (this.getTipoConta().equalsIgnoreCase("conta corrente") || (this.getTipoConta().equalsIgnoreCase("corrente"))){
			abrirContaCorrente();
		} else if (this.getTipoConta().equalsIgnoreCase("conta poupança") || (this.getTipoConta().equalsIgnoreCase("poupança"))) {
			abrirContaPoupanca();
		} else {
			System.out.println("Atenção!! opções que são válidas: conta corrente ou conta poupança");
		}
	}

	public String nomeFormatado() {		
		String[] nomes = this.nome.split(" ");
		String primeiroNome = nomes[0];
		String segundoNome = nomes[1];
		return primeiroNome + " " + segundoNome;
	}
	
	public String cpfFormatado() {
		if (this.getCpf().length() == 11) {
			String formatacao = String.format("%s.%s.%s-%s", this.cpf.substring(0, 3), this.cpf.substring(3, 6),this.cpf.substring(6, 9), this.cpf.substring(9));
			this.setCpf(formatacao);
			return this.getCpf();
		} else {
			System.out.println("CPF inválido!!\nCertifique-se de fornecer 11 dígitos.");
			return "CPF inválido";
		}
	}
	
	public void statusConta() {
		System.out.println("---------------- SEUS DADOS ----------------");
		System.out.println();
		System.out.println("\nNome: " + this.getNome());
		System.out.println("CPF: " + cpfFormatado());
		System.out.printf("Saldo: R$%.2f", this.getSaldo());
		System.out.println("\nTipo da conta: " + this.getTipoConta());
		System.out.println("Número da conta: " + geradorConta());
		System.out.println("Número da agência: " + this.getNumAgencia());
		this.endereco.statusEndereco();		
	}

	@Override
	public void mudarSenha() {
		Scanner S = new Scanner(System.in);
		System.out.println("Digite sua nova senha(6 digitos):");
		String novaSenha = S.nextLine();
		this.setSenhaAcesso(novaSenha);
	}

	@Override
	public void entrarConta(String senhaDigitada) {
		Scanner S = new Scanner(System.in);
		if (senhaDigitada.equals(this.getSenhaAcesso())) {
			System.out.println("Senha correta!");
			statusConta();
		} else if (!senhaDigitada.equals(this.getSenhaAcesso())) {
			System.out.println("senha incorreta!");
			int contador = 1;
			while (contador >= 3) {
				System.out.println("Você tera mais" + contador + " chaces para digitar novamente sua senha:");
				System.out.println("Digite sua Senha(6 digitos): ");
				String senha = S.nextLine();
				if (senha.equals(this.getSenhaAcesso())) {
					System.out.println("Senha correta!");
					this.statusConta();
				}
				contador++;
			}
			System.out.println("Você deseja trocar de senha: \n1 - Sim \n2 - Não");
			int opcao = S.nextInt();
			if (opcao == 1) {
				mudarSenha();
			}
		}
	}

	public void imprimirExtrato() {
		System.out.println("------------- EXTRATO DA CONTA -------------");
		for (String transacao : this.extrato) {
			System.out.println(transacao);
		}
	}

	public void registrarExtrato(String tipo, double valor) {
		String transacao = String.format("%s - Valor: %.2f - Data: %s", tipo, valor, new Date());
		this.extrato.add(transacao);
	}

	
	@Override
	public void sacar(double valorSacar) {
		Scanner S = new Scanner(System.in);
		valorSacar = S.nextDouble();
		S.nextLine();
		System.out.println("Digite sua senha de acesso para dar continuidade.");
		String validarSenha = S.nextLine();
		if (validarSenha.equals(this.getSenhaAcesso())) {
			if (this.getTipoConta().equalsIgnoreCase("conta corrente")) {
				sacarContaCorrente(valorSacar);
			} else if (this.getTipoConta().equalsIgnoreCase("conta poupança")) {
				sacarContaPoupanca(valorSacar);
			}
		}else {
			System.out.println("Senha Invalida. Tente novamente");
		}
		
		registrarExtrato("Saque: ", valorSacar);
	}

	@Override
	public void depositar(double valor) {
		Scanner S =  new Scanner(System.in);
		System.out.println("Digite sua senha de acesso para dar continuidade.");
		String validarSenha = S.nextLine();
		if (validarSenha.equals(this.getSenhaAcesso())) {
			this.setSaldo(this.getSaldo() + valor);
			System.out.println();
			System.out.printf("Você fez um depósito no valor de: R$%.2f", valor);			
			System.out.printf("\nSaldo:%.2f ", this.getSaldo());
			registrarExtrato("Depósito", valor);
		}else {
			System.out.println("Senha incorreta. Tente novamente!");
		}
	}


	@Override
	public void transferir(double pix) {
		Scanner S = new Scanner(System.in);
		
		if (this.getSaldo() > 0 && this.getSaldo() >= pix) {
			System.out.println("Atenção: temos a previsão de até 24h para o TED ser efetuado com sucesso!!");
			System.out.println("Você deseja continuar a transferência: \n1 -  Para confirmar a transferência. \n2 - Para cancela a transferência.");
			int contTransferencia = S.nextInt();
			S.nextLine();
			System.out.println("Digite sua senha de acesso para dar continuidade.");
			String validarSenha = S.nextLine();

			if (validarSenha.equals(this.getSenhaAcesso())) {
				if (contTransferencia == 1) {
					this.setSaldo(this.getSaldo() - pix);
					System.out.printf("Você fez uma transferência no valor de: R$%.2f" , pix);
					System.out.printf("\nSaldo: %.2f" , this.getSaldo());
					registrarExtrato("transferencia", pix);
				}else if(contTransferencia == 2) {
					System.out.println("Transferência cancelada.");
				}
			} else {
				System.out.println("Senha invalida!");
			}
		}else if (this.getSaldo() <= 0 && this.getSaldo() < pix){
			System.out.println("Seu saldo é insuficiente para realizar uma transferência");
			System.out.printf("Saldo: R$%.2f \nValor da transferência: %d", getSaldo(), pix);
			System.out.println("Para continuar você pode realizar um deposito");
			System.out.println("1 - Para realizar um deposito \n2 - Para cancelar a transferênciaa");
			int opcao = S.nextInt();
			if(opcao == 1) {
				this.setSaldo(this.getSaldo() - pix);
				System.out.printf("Você fez uma transferência no valor de: R$%.2f" , pix);
				System.out.printf("\nSaldo: %.2f" , this.getSaldo());
				registrarExtrato("transferencia", pix);
			}
		}else {
			System.out.println("Cancelando transferência...");
		}		
	}
    
	public void abrirContaCorrente() {
	
	}
    
	public void abrirContaPoupanca() {

	}

	private void sacarContaPoupanca(double valorSacar) {
		
		
	}

	private void sacarContaCorrente(double valor) {
		
		
	}

}
