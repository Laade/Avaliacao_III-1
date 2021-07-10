package inf008.model;

public abstract class Cor {
    
    private String id;
	private String descricao;
	private String simbolo;
         
    public Cor(String id, String descricao, String simbolo) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setSimbolo(simbolo);
	}
    private void setId(String id) {
		this.id = id;
	}
	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	private void setSimbolo(String simbolo) {
		this.simbolo = simbolo;
	}
    private String getId() {
		return this.id;
	}
	private String getDescricao() {
		return this.descricao;
	}
	private String getSimbolo() {
		return this.simbolo;
	}
    
    public abstract int getLuminosidade();
    protected abstract int validaCor(int valor);
    public abstract boolean isEqual(Cor cor);
    
}
