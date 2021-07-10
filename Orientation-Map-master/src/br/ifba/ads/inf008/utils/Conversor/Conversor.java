package inf008.utils.Conversor;

import inf008.model.Cor;
import inf008.model.Mapa;

public class Conversor {

    public Mapa converter(Mapa mapa, ConversorCor conversor) {
        Mapa novo = conversor.getNovoMapa(mapa.getAltura(), mapa.getLargura());
        
        for(int iCont = 0; iCont < mapa.getAltura(); iCont ++) {
            for(int jCont = 0; jCont < mapa.getLargura(); jCont++) {
                Cor cor = mapa.getPixel(iCont, jCont);
                Cor novaCor = conversor.converter(cor);
                novo.setPixel(iCont, jCont, novaCor);
            }
        }
        return novo;
    }
}
