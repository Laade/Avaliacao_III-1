package inf008.model;

public class Simbolo {
	private int id;
	private String descricao;
	
	public Simbolo(int id, String descricao) {
		this.setId(id);
		this.setDescricao(descricao);
	}

	private void setId(int id) {
		this.id = id;
	}

	private void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}