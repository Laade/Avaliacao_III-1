package inf008.utils.Exception;

public class CorInexistenteException  extends Exception{
    private String nomeCor;

	public CorInexistenteException(String nomeCor) {
		super();
		this.nomeCor = nomeCor;
	}
	
	public String getNomeCor() {
		return nomeCor;
	}
}
