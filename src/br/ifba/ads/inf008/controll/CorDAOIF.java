package inf008.controll;

import java.util.Collection;

import inf008.model.Cor;

public interface CorDAOIF {
	public void salvar(Cor c) throws Exception;
	public Collection<Cor> findBySimbolo(String s) throws Exception;
	public Collection<Cor> findAll() throws Exception;
}