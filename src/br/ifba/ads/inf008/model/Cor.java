package model;

public abstract class Cor {
    
	 protected String id;
		protected String descricao;
		protected String simbolo;
         
    public Cor(String id, String descricao, String simbolo) {
		this.setId(id);
		this.setDescricao(descricao);
		this.setSimbolo(simbolo);
	}
    public Cor(int cyan, int magente, int yellow, int keyBlack) {
	}
    
	public Cor(int red, int green, int blue) {
		// TODO Auto-generated constructor stub
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
    public String getId() {
		return this.id;
	}
    public String getDescricao() {
		return this.descricao;
	}
    public String getSimbolo() {
		return this.simbolo;
	}
    
    public abstract int getLuminosidade();
    protected abstract int validaCor(int valor);
    public abstract boolean isEqual(Cor cor);
    
}