package inf008.controll;

public class CorInexistenteException extends Exception {

	private String NomeDaCor;
	
	public CorInexistenteException(String NomeDaCor) {
		super();
		this.NomeDaCor = NomeDaCor;
	}
	
	public String getNomeDaCor() {
		return this.NomeDaCor;
	}

}
