package inf008.model;

public abstract class Cor {
    
	private String id;
	private String descricao;
	private Simbolo simbolo;
         
    public Cor(String id, String descricao, Simbolo simbolo) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setSimbolo(simbolo);
	}

	public abstract String getCodTipo();
    public abstract int getLuminosidade();
    protected abstract int validaCor(int valor);
    
	private void setId(String id) {
		this.id = id;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private void setSimbolo(Simbolo simbolo) {
		this.simbolo = simbolo;
	}
    public String getId() {
		return this.id;
	}
    public String getDescricao() {
		return this.descricao;
	}
    public Simbolo getSimbolo() {
		return this.simbolo;
	}
    
}