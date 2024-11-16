package padrao;

public class PrecoNegativoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Preço não pode ser negativo!";
	}
}
