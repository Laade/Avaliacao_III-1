package inf008.utils.Exception;

public class SimboloInexistenteException extends Exception {
	
	private int idSimbolo;
	private String nomeSimbolo;
	
	public SimboloInexistenteException(int idSimbolo) {
		super();
		this.idSimbolo = idSimbolo;
	}

}	