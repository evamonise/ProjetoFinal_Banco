package avengersProjeto;

import java.util.Scanner;

public class Endereco {
	
	private String rua;
	private String numero;
	private String cidade;
	private String estado;
	private String cep;
	
	public Endereco() {
		
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Endereco(String rua, String numero, String cidade, String estado, String cep) {
		this.rua = rua;
		this.numero = numero;
		this.cidade = cidade;
		this.estado = estado;
		this.cep = cep;
	}
	
	public void cadastrarEndereco() {
		Scanner S = new Scanner(System.in);
	
		System.out.println("Rua: ");
		this.rua = S.nextLine();
		System.out.println("Número: ");
		this.numero = S.nextLine();
		System.out.println("Cidade: ");
		this.cidade = S.nextLine();
		System.out.println("Estado: ");
		this.estado = S.nextLine();
		System.out.println("Cep: " );
		this.cep = S.nextLine();
	}
	
	public String formatarCep() {
		if(this.cep.length() == 8) {
			String cepFormatado = String.format("%s-%s",this.cep.substring(0,5),this.cep.substring(5,8));
			this.cep = cepFormatado;	
		}else {
			System.out.println("Cep invalido. verifique se o cep informado tem 8 dígitos");
		}
		return this.cep;
	}
	
	public void statusEndereco() {
		System.out.println("Rua: " + this.rua);
		System.out.println("Número: " + this.numero );
		System.out.println("Cidade: " + this.cidade);
		System.out.println("Estado: " + this.estado );
		System.out.println("Cep: " + formatarCep());
		
	}
}
