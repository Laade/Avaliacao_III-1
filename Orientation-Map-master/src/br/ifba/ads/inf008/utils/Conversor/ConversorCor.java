package inf008.utils.Conversor;

import inf008.model.Cor;
import inf008.model.Mapa;

public interface ConversorCor {

    public Mapa getNovoMapa(int altura, int largura);
    public Cor converter(Cor cor);
    
}
