package padrao;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Estabelecimento {
	private static final int ADICIONAR_PRODUTO = 1;
	private static final int LISTAR_PRODUTOS = 2;
	private static final int ATUALIZAR_QUANTIDADE = 3;
	private static final int REMOVER_PRODUTO = 4;
	private static final int SAIR = 5;
	
	private HashMap<Integer, Produto> produtos;
	private Scanner scan;
	private int idProduto;
	
	public Estabelecimento(Scanner scan) {
		this.produtos = new HashMap<>();
		this.scan = scan;
		this.idProduto = 1;
	}
	
	public void executarSistemaEstoque() {
		boolean continuar = true;
		
		while(continuar) {
			switch(menu()) {
				case ADICIONAR_PRODUTO:
					adicionarProduto();
					break;
				case LISTAR_PRODUTOS:
					listarProdutos();
					break;
				case ATUALIZAR_QUANTIDADE:
					atualizarQuantidade();
					break;
				case REMOVER_PRODUTO:
					removerProduto();
					break;
				case SAIR:
					System.out.println("Saindo do sistema...");
					continuar = false;	
					break;
			}	
		}
	}
	
	public int menu() {
		while(true) {
			System.out.println("=== Sistema de Estoque ===");
			System.out.println("1. Adicionar Produto");
			System.out.println("2. Listar Produtos");
			System.out.println("3. Atualizar Quantidade");
			System.out.println("4. Remover Produto");
			System.out.println("5. Sair");
			System.out.print("Escolha uma opção: ");
			
			try {
				int escolha = scan.nextInt();
				
				if (escolha >= 1 && escolha <= 5) {
					return escolha;
				}

				System.out.println("Digite uma opção do menu válida!\n");
			} catch (InputMismatchException e) {
				scan.nextLine();
				System.out.println("Entrada inválida! Tente Novamente.\n");
			}
		}
	}
	
	public void adicionarProduto() {
		Produto p = new Produto();
		
		try {
			scan.nextLine();
			System.out.print("\nDigite o nome do produto: ");
			p.setNome(scan.nextLine());

			while (true) {
				System.out.print("Digite a quantidade: ");
				try {
					p.setQuantidade(scan.nextInt());
					break;
				} catch (QuantidadeNegativaException e) {
					System.out.println(e.getMessage());
				}
			}

			while (true) {
				System.out.print("Digite o preço: ");
				try {
					p.setPreco(scan.nextDouble());
					break;
				} catch (PrecoNegativoException e) {
					System.out.println(e.getMessage());
				}
			}
			
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite uma entrada válida!\n");
			return;
		}

		produtos.put(idProduto++, p);
		System.out.println("Produto adicionado com sucesso!\n");
	}
	
	public void listarProdutos() {
		System.out.println("\n--- Produtos no estoque ---");
		
		if (produtos.isEmpty()) {
			System.out.println("Estoque está vazio!\n");
			return;
		}
		
		System.out.printf("%-5s %-20s %-10s %-10s\n", "ID", "Nome", "Quantidade", "Preço (R$)");
		System.out.println("-------------------------------------------------------");
	
		for (Map.Entry<Integer, Produto> entry : produtos.entrySet()) {
			int id = entry.getKey();
			Produto p = entry.getValue();
			System.out.printf("%-5d %-20s %-10d %-10.2f\n", id, p.getNome(), p.getQuantidade(), p.getPreco());
		}
	
		System.out.println("-------------------------------------------------------\n");
	}
	
	public void atualizarQuantidade() {
		try {
			if (produtos.isEmpty()) {
				System.out.println("Estoque está vazio! Não há produtos para atualizar.\n");
				return;
			}
			
			System.out.println("\n--- Produtos disponíveis ---");
			for (Map.Entry<Integer, Produto> entry : produtos.entrySet()) {
				System.out.printf("ID: %d | Nome: %s\n", entry.getKey(), entry.getValue().getNome());
			}
			
			System.out.print("\nDigite o ID do produto para atualizar a quantidade: ");
			int id = scan.nextInt();
	
			Produto p = produtos.get(id);
			if (p == null) {
				System.out.println("ID não encontrado! Tente novamente.\n");
				return;
			}
	
			while (true) {
				System.out.print("Digite a nova quantidade: ");
				try {
					p.setQuantidade(scan.nextInt());
					System.out.println("Quantidade atualizada com sucesso!\n");
					break;
				} catch (QuantidadeNegativaException e) {
					System.out.println(e.getMessage());
				}
			}
	
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite uma entrada válida!\n");
		}
	}
	
	public void removerProduto() {
		try {
			if (produtos.isEmpty()) {
				System.out.println("Estoque está vazio! Não há produtos para remover.\n");
				return;
			}

			System.out.println("\n--- Produtos disponíveis ---");
			for (Map.Entry<Integer, Produto> entry : produtos.entrySet()) {
				System.out.printf("ID: %d | Nome: %s\n", entry.getKey(), entry.getValue().getNome());
			}

			System.out.print("\nDigite o ID do produto para remover: ");
			int id = scan.nextInt();

			if (produtos.containsKey(id)) {
				produtos.remove(id);
				System.out.println("Produto removido com sucesso!\n");
			} else {
				System.out.println("ID não encontrado! Tente Novamente.\n");
			}

		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Entrada inválida! Certifique-se de digitar um número inteiro.\n");			
			return;
		}
	}
}
