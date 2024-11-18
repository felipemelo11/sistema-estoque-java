package padrao;

import java.util.Scanner;

public class Main {
	private static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Estabelecimento estabelecimento = new Estabelecimento(scan);
		
		estabelecimento.executarSistemaEstoque();
		
		scan.close();
	}
}
