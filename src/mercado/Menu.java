package mercado;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;
import mercado.model.Produto;
import mercado.model.Lanche;
import mercado.controller.ProdutoController;
import mercado.model.Bebida;

public class Menu {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		ProdutoController produtos = new ProdutoController();

		int opcao = 1, num, tipo, sabor, idade;
		float valor;
		String nomeProduto;

		Produto l1 = new Lanche(1, "Coxinha", 2, 3.0f, 1);
		l1.visualizar();
		Produto b1 = new Bebida(1, "Coca-Cola", 1, 10.0f, 10);
		b1.visualizar();
		Produto b2 = new Bebida(1, "Vodka", 1, 10.0f, 19);
		b2.visualizar();

		while (true) {

			System.out.println();
			System.out.println("~-----------------------------------------------------------~");
			System.out.println("|                    Mercadinho do Cleber                   |");
			System.out.println("~-----------------------------------------------------------~");
			System.out.println("|                                                           |");
			System.out.println("|                 1- Adcionar Produto                       |");
			System.out.println("|                 2- Listar todos Produtos                  |");
			System.out.println("|                 3- Buscar Produtos por ID                 |");
			System.out.println("|                 4- Atualizar Dados do Produto             |");
			System.out.println("|                 5- Apagar Produto                         |");
			System.out.println("|                 0- Sair                                   |");
			System.out.println("|                                                           |");
			System.out.println("~-----------------------------------------------------------~");
			System.out.printf("   Entre com a opção desejada:                               ");
			try {
				opcao = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Digite valores inteiros.");
				sc.nextLine();
				opcao = 0;
			}
			if (opcao == 0) {
				sair();
				sc.close();
				System.exit(0);
			}

			switch (opcao) {

			case 1 -> {
				System.out.println("Insira o Tipo de Produto(1 - Bebida ou 2 - Lanche): ");
				tipo = sc.nextInt();

				System.out.println("Insira o nome do Produto: ");
				sc.skip("\\R");
				nomeProduto = sc.nextLine();

				System.out.println("Insira o Valor do Produto R$: ");
				valor = sc.nextFloat();

				switch (tipo) {
				case 1 -> {
					System.out.println("Insira sua Idade: ");
					idade = sc.nextInt();
					produtos.cadastro(new Bebida(produtos.gerarId(), nomeProduto, tipo, valor, idade));
				}
				case 2 -> {
					System.out.println("Selecione o tipo de Sabor(1- Doce, 2- Salgado");
					sabor = sc.nextInt();
					produtos.cadastro(new Lanche(produtos.gerarId(), nomeProduto, tipo, valor, sabor));
				}
				}
				keyPress();
			}
			case 2 -> {
				produtos.listarTodos();
				keyPress();
			}
			case 3 -> {
				System.out.println("Digite o ID do produto: ");
				num = sc.nextInt();
				produtos.procurarPorId(num);
				keyPress();
			}
			case 4 -> {
				System.out.println("Digite o ID do produto: ");
				num = sc.nextInt();

				Optional<Produto> produto = produtos.buscarNaCollection(num);
				if (produto.isPresent()) {
					System.out.println("Insira o Tipo de Produto(1 - Bebida ou 2 - Lanche): ");
					tipo = sc.nextInt();

					System.out.println("Insira o nome do Produto: ");
					sc.skip("\\R");
					nomeProduto = sc.nextLine();

					System.out.println("Insira o Valor do Produto R$: ");
					valor = sc.nextFloat();

					switch (tipo) {
					case 1 -> {
						System.out.println("Insira sua Idade: ");
						idade = sc.nextInt();
						produtos.atualizar(new Bebida(num, nomeProduto, tipo, valor, idade));
					}
					case 2 -> {
						System.out.println("Selecione o tipo de Sabor(1- Doce, 2- Salgado)");
						sabor = sc.nextInt();
						produtos.atualizar(new Lanche(num, nomeProduto, tipo, valor, sabor));
					}
					}
				}else {
					System.out.println("O Produto do ID: : " + num + " não foi encontrada");
				}
				keyPress();
			}
			case 5 -> {
				System.out.println("Insira o ID do Produto: ");
				num = sc.nextInt();
				produtos.deletar(num);
				keyPress();
			}
			default -> {
				System.out.println("Opção Inválida!");
			}
			}
		}
	}

	public static void sair() {
		System.out.println("~-----------------------------------------------------------~");
		System.out.println("|                                                           |");
		System.out.println("|                    Mercadinho do Cleber                   |");
		System.out.println("|                                                           |");
		System.out.println("~-----------------------------------------------------------~");
		System.out.println("|                                                           |");
		System.out.println("|O melhor mercado da sua vizinhança!                        |");
		System.out.println("|                                                           |");
		System.out.println("|Desenvolvido por: Pablo                                    |");
		System.out.println("|github.com/pxmiddle                                        |");
		System.out.println("|                                                           |");
		System.out.println("~-----------------------------------------------------------~");
	}

	public static void keyPress() {
		try {
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");

		}
	}
}
