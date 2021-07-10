package controll;

import java.util.List;
import model.Cor;

public interface CorDAOIF {
	//public void salvar(Cor cor) throws Exception;
	public int pesquisarCor(Cor c) throws Exception;
}