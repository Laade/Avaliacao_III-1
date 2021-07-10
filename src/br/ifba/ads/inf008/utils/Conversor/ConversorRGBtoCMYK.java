package inf008.utils.Conversor;

import inf008.model.Cor;
import inf008.model.CorCMYK;
import inf008.model.CorRGB;
import inf008.model.Mapa;
import inf008.model.MapaCMYK;

public class ConversorRGBtoCMYK implements ConversorCor{

    @Override
    public Mapa getNovoMapa(int altura, int largura) {
        return new MapaCMYK(altura, largura);
    }

    @Override
    public Cor converter(Cor cor) {
        CorRGB corRGB = (CorRGB) cor;

        int _red = divideBy255(corRGB.getRed());
        int _green = divideBy255(corRGB.getGreen());
        int _blue = divideBy255(corRGB.getBlue());

        int keyBlack = 1 - customMax(_red, _green, _blue);

        return new CorCMYK((1 - _red - keyBlack) / (1 - keyBlack), 
                           (1 - _green - keyBlack) / (1 -keyBlack), 
                           (1 - _blue - keyBlack) / (1 -keyBlack), keyBlack);
    }

    private int divideBy255(int arg) {
        return arg / 255;
    }

    private int customMax(int arg1, int arg2, int arg3) {
        return Math.max(Math.max(arg1, arg2), arg3);

    }
    
}
