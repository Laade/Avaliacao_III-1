package inf008.controll;

import java.util.Collection;

import inf008.model.Cor;

// Vai ser usado para manipulação com o banco
public interface CorDAOIF {
	public void salvar(Cor c) throws Exception;
	public void atualizar(Cor c) throws Exception;
	public Collection<Cor> findBySimbolo(String s) throws Exception;
	public Cor findByDescricao(String s) throws Exception;
	public Collection<Cor> findAll() throws Exception;
	public Collection<String> findAllSimbolo() throws Exception;


	// //public void salvar(Cor cor) throws Exception;
	// public void adicionar(Cor c) throws Exception;
	// public int pesquisarSimbolo(String simbolo) throws Exception;



	
	
	

}
