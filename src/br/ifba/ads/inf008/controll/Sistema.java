package inf008.controll;

import java.util.Collection;

import inf008.model.Cor;
import inf008.model.Mapa;
import inf008.model.MapaRGB;

public class Sistema {
    
    public Collection<String> analisaMapa(String caminhoArquivo, String simbolo) throws Exception {

        // seleciono a imagem
        // escolho o simbolo que eu quero
        // recebo uma colecao de cores pertencentes à esse simbolo
        // verifico se o mapa é rgb ou cmyk

        // se for rgb eu intero sobre as cores, 
        // pergunto se cada uma delas é rgb, se for eu pergunto eu pego o percentual dela
        // senao eu converto em rgb e pego o percentual dela

        // se for cmyk eu intero sobre as cores, 
        // pergunto se cada uma delas é cmyk, se for eu pergunto eu pego o percentual dela
        // senao eu converto em cmyk e pego o percentual dela

        // ps: acredito que ficaria agradável colocar o converter dentro da classe cor apropriada

        // Convertendo de arquivo para Mapa
        return null;
    }
}

