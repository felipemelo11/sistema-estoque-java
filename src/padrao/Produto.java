package padrao;

public class Produto {
	private String nome;
	private int quantidade;
	private double preco;
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	
	public void setQuantidade(int quantidade) throws QuantidadeNegativaException { 
		if (quantidade < 0) { 
			throw new QuantidadeNegativaException(); 
		} 
	
		this.quantidade = quantidade; 
	}
	
	public double getPreco() {
		return preco;
	}
	
	public void setPreco(double preco) throws PrecoNegativoException {
		if (preco < 0) { 
			throw new PrecoNegativoException(); 
		} 
		
		this.preco = preco;
	}
}
