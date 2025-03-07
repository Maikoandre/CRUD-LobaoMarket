package Menu;

import java.util.Scanner;
import java.util.HashMap;

public class Menu {
	private static final Scanner scanner = new Scanner(System.in);

	public static void userService() {
		String usuario = "maiko";
		String senha = "1234";
		String u, s;

		do {
			System.out.println("\n---------Login--------");
			System.out.print("Usuário: ");
			u = scanner.nextLine();
			System.out.print("Senha: ");
			s = scanner.nextLine();
			if (u.equals(usuario) && s.equals(senha)) {
				break;
			} else {
				System.out.println("Usuário ou senha incorretos. Tente novamente.");
			}
		} while (true);

		System.out.println();
		systemService();

	}

	private static void systemService() {
		HashMap<String, String> produtoPreco = new HashMap<>();
		HashMap<String, Integer> produtoQuantidade = new HashMap<>();

		boolean end = false;
		int choice;

		do {

			System.out.println("Seja bem-vindo ao Lobão Supermarket!");
			System.out.println("Escolha a operação desejada: \n" + "0 - Sair do sistema\n"
					+ "1 - Criar um novo registro\n" + "2 - Ler os registros armazenados\n"
					+ "3 - Atualizar um registro existente\n" + "4 - Deletar um registro\n");
			System.out.print("Opção: ");
			choice = scanner.nextInt();
			scanner.nextLine();
			System.out.println();

			switch (choice) {
			case 0:
				end = true;
				break;
			case 1:
				createInfo(produtoPreco, produtoQuantidade);
				break;
			case 2:
				readInfo(produtoPreco, produtoQuantidade);
				break;
			case 3:
				updateInfo(produtoPreco, produtoQuantidade);
				break;
			case 4:
				deleteInfo(produtoPreco, produtoQuantidade);
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}

		} while (!end);

	}

	private static void createInfo(HashMap<String, String> produtoPreco, HashMap<String, Integer> produtoQuantidade) {
		System.out.print("Digite o nome do produto: ");
		String produto = scanner.nextLine();

		System.out.println("Digite o preço do produto");
		String preco = scanner.nextLine();

		System.out.println("Digite a quantidade do produto");
		Integer quantidade = scanner.nextInt();
		scanner.nextLine();

		produtoPreco.put(produto, preco);
		produtoQuantidade.put(produto, quantidade);

		System.out.println("Produto cadastrado!");
	}

	private static void readInfo(HashMap<String, String> produtoPreco, HashMap<String, Integer> produtoQuantidade) {
		if (produtoPreco.isEmpty()) {
			System.out.println("Nenhum produto cadastrado!");
			return;
		}
		System.out.println("Produto | Preço | Quantidade");
		for (String nome : produtoPreco.keySet()) {
			System.out.println(nome + " | " + produtoPreco.get(nome) + " | " + produtoQuantidade.get(nome));
		}
		System.out.println();

	}

	private static void updateInfo(HashMap<String, String> produtoPreco, HashMap<String, Integer> produtoQuantidade) {
		System.out.println("Qual produto deseja alterar?");
		String produto = scanner.nextLine();

		if (!produtoPreco.containsKey(produto)) {
			System.out.println("Produto não encontrado!");
			return;
		}

		System.out.println("Qual coluna deseja alterar? \n1 - nome \n2 - preço \n3 - quantidade\n");
		int choice = scanner.nextInt();
		scanner.nextLine();
		switch (choice) {
		case 0:
			break;
		case 1:
			System.out.print("Digite o novo nome: ");
			String novoNome = scanner.nextLine();
			String preco = produtoPreco.remove(produto);
			int quantidade = produtoQuantidade.remove(produto);
			produtoQuantidade.put(novoNome, quantidade);
			produtoPreco.put(novoNome, preco);
			System.out.println("Nome atualizado.");
			break;
		case 2:
			System.out.print("Digite o novo preço: ");
			String novoPreco = scanner.nextLine();
			produtoPreco.replace(produto, novoPreco);
			System.out.println("Preço atualizado!");
			break;
		case 3:
			System.out.println("Digite a nova quantidade: ");
			int novaQuantidade = scanner.nextInt();
			scanner.nextLine();
			produtoQuantidade.replace(produto, novaQuantidade);
			break;
		default:
			System.out.println("Opção inválida!");
		}
	}
	
	private static void deleteInfo(HashMap<String, String> produtoPreco, HashMap<String, Integer> produtoQuantidade) {
		System.out.println("Digite o nome do produto para deletar: ");
		String produto = scanner.nextLine();
		
		if (produtoPreco.containsKey(produto)) {
			produtoPreco.remove(produto);
			produtoQuantidade.remove(produto);
			System.out.println("Produto removido!");
		} else {
			System.out.println("Produto não encontrado.");
		}

	}

}
