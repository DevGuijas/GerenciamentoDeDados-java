package TesteResource;

import java.util.Scanner;

public class Main_Resource {
	
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		
		int chose = 0;
		
		// Teste de valores:
		System.out.println("Situação atual do seu inteiro: " + chose);
		
		chose = wellcome_message(chose);
		
		// Teste de valores:
		System.out.println("Situação atual do seu inteiro: " + chose);
		
		switch(chose) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			System.out.println("Entendemos os seus desejos. Até mais! ;)");
			System.exit(0);
		}
		
	}
	
	public static int wellcome_message(int chose) {
		System.out.println("Olá! Bem vindo(a)!"
				+ "\nGostaria de:");
		
		System.out.println("\n(1) Logar"
				+ "\n(2) Registrar"
				+ "\n(3) Entrar em contato com o suporte"
				+ "\n(4) Sair");
		
		System.out.println("\nEscolha a sua opção:");
		chose = sc.nextInt();
		
		return chose;
	}

}
