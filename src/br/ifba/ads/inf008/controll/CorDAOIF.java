package inf008.controll;

import inf008.model.Cor;

public interface CorDAOIF {
	//public void salvar(Cor cor) throws Exception;
	public int pesquisarCor(Cor c) throws Exception;
	void adicionar(Cor c) throws Exception;
}
