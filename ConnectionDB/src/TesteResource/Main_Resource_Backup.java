package TesteResource;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main_Resource_Backup {

	static Scanner sc = new Scanner(System.in);
	static final String FILE_PATH = "C:\\Users\\200029317\\Documents\\Guijas\\login_senha_users\\sistemaDeLoginESenha.txt";

	public static void main(String[] args) {
		int chose = 0;

		do {
            chose = wellcome_message(chose);

            switch (chose) {
                case 1:
                    logar();
                    break;
                case 2:
                    registrar();
                    break;
                case 3:
                    System.out.println("Entre em contato com o suporte pelo email: suporte@empresa.com");
                    break;
                case 4:
                    System.out.println("Entendemos os seus desejos. Até mais! ;)");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
                    break;
            }

        } while (chose != 4);
	}

	public static int wellcome_message(int chose) {
		System.out.println("Olá! Bem-vindo(a)!" + "\nGostaria de:");

		System.out.println("\n(1) Logar" + "\n(2) Registrar" + "\n(3) Entrar em contato com o suporte" + "\n(4) Sair");

		System.out.println("\nEscolha a sua opção:");
		chose = sc.nextInt();

		return chose;
	}

	public static void logar() {
		System.out.println("Digite o seu usuário:");
		String usuario = sc.next();
		System.out.println("Digite a sua senha:");
		String senha = sc.next();

		boolean autenticado = false;

		try (BufferedReader br = new BufferedReader(new FileReader(FILE_PATH))) {
			String linha;
			while ((linha = br.readLine()) != null) {
				String[] partes = linha.split(" ");
				String user = partes[1].replace("\"", "");
				String pass = partes[3].replace("\"", "");

				if (usuario.equals(user) && senha.equals(pass)) {
					autenticado = true;
					break;
				}
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo: " + e.getMessage());
		}

		if (autenticado) {
			System.out.println("Login bem-sucedido!");
		} else {
			System.out.println("Usuário ou senha incorretos!");
		}
	}

	public static void registrar() {
		System.out.println("Escolha um nome de usuário:");
		String novoUsuario = sc.next();
		System.out.println("Escolha uma senha:");
		String novaSenha = sc.next();

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
			bw.write("user: \"" + novoUsuario + "\" pass: \"" + novaSenha + "\"\n");
			System.out.println("Usuário registrado com sucesso!");
		} catch (IOException e) {
			System.out.println("Erro ao escrever no arquivo: " + e.getMessage());
		}
	}
}
