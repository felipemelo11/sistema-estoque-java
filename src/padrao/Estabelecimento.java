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
	
	public Estabelecimento() {
		produtos = new HashMap<>();
		scan = new Scanner(System.in);
		idProduto = 1;
	}
	
	public void executarSistemaEstoque() {
		boolean flag = true;
		
		while(flag) {
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
					flag = false;	
					break;
			}	
		}
	}
	
	public int menu() {
		System.out.println("=== Sistema de Estoque ===");
		System.out.println("1. Adicionar Produto");
		System.out.println("2. Listar Produtos");
		System.out.println("3. Atualizar Quantidade");
		System.out.println("4. Remover Produto");
		System.out.println("5. Sair");
		System.out.print("Escolha uma opção: ");
		
		int escolha = 0;
		
		try {
			escolha = scan.nextInt();
			if (escolha > 5 || escolha < 1) throw new InputMismatchException();
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite uma opção do menu válida!\n");
		}

		return escolha;
	}
	
	public void adicionarProduto() {
		Produto p = new Produto();
		
		try {
			scan.nextLine();
			System.out.print("\nDigite o nome do produto: ");
			p.setNome(scan.nextLine());

			System.out.print("Digite a quantidade: ");
			p.setQuantidade(scan.nextInt());
			
			System.out.print("Digite o preço: ");
			p.setPreco(scan.nextDouble());
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite uma entrada válida!\n");
			return;
		} catch (QuantidadeNegativaException | PrecoNegativoException e) {
			System.out.println(e.getMessage() + "\n");
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
		
		for (Map.Entry<Integer, Produto> entry: produtos.entrySet()) {
			Produto p = entry.getValue();
			System.out.println("ID: " + entry.getKey());
			System.out.println("Nome: " + p.getNome());
			System.out.println("Quantidade: " + p.getQuantidade());
			System.out.printf("Preço: R$%.2f\n\n", p.getPreco());
		}
	}
	
	public void atualizarQuantidade() {
		int id = 0;
		int qtd = 0;
		
		try {
			System.out.print("\nDigite o ID do produto para atualizar a quantidade: ");
			id = scan.nextInt();
			
			System.out.print("Digite a nova quantidade: ");
			qtd = scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite uma entrada válida!\n");
			return;
		}

		Produto p = produtos.get(id);
		if (p != null) {
			try {
				p.setQuantidade(qtd);
				System.out.println("Quantidade atualizada com sucesso!\n");
			} catch (QuantidadeNegativaException e) {
				System.out.println(e.getMessage() + "\n");
			}
		} else {
			System.out.println("ID não encontrado! Tente Novamente.\n");
		}
	}
	
	public void removerProduto() {
		int id = 0;
		
		try {
			System.out.print("Digite o ID do produto para remover: ");
			id = scan.nextInt();
		} catch (InputMismatchException e) {
			scan.nextLine();
			System.out.println("Digite um ID válido!\n");			
			return;
		}
		
		if (produtos.remove(id) != null) {
			System.out.println("Produto removido com sucesso!\n");
		} else {
			System.out.println("ID não encontrado! Tente Novamente.\n");
		}
	}
}
