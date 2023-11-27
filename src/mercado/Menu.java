package mercado;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import mercado.model.Produto;
import mercado.model.Lanche;
import mercado.model.Bebida;


public class Menu {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		int opcao = 1;
	
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
			case 1 ->{System.out.println("Add Produto");}
			case 2 ->{System.out.println("Listar Produto");}
			case 3 ->{System.out.println("Buscar por ID");}
			case 4 ->{System.out.println("Atualizar dados");}
			case 5 ->{System.out.println("Apagar Produto");}
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
	
	public void keyPress() {
		try {
			System.out.println("\n\nPressione a tecla Enter para continuar...");
			System.in.read();
		} catch (IOException e) {
			System.out.println("Você pressionou uma tecla inválida.");

		}
	}
}
