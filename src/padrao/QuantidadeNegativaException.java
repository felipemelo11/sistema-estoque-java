package padrao;

public class QuantidadeNegativaException extends Exception {
	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "Quantidade não pode ser negativa!";
	}
}
