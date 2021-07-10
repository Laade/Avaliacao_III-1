package inf008.model;


public class Mapoteca {
    
    private Mapa[] mapas = new Mapa[0];

    public void pushMapa(Mapa mapa) {

        // Reservo mais um espaço no array
        Mapa[] novoMapa = new Mapa[this.mapas.length + 1];

        // Populo o novo mapa com os mapas existentes
        for(int i = 0; i < mapas.length; i ++) {
            novoMapa[i] = this.mapas[i];
        }

        novoMapa[novoMapa.length - 1] = mapa;
        this.mapas = novoMapa;
    }

    private Mapa[] getMapas() {
        return this.mapas;
    }

    public Mapa[] getMapasPorLuminosidade(int red, int green, int blue, double pctMinimo, double limiarLuminosidade){
        
        Mapoteca mapasSimilares = new Mapoteca();

        for(int i = 0; i < this.mapas.length; i ++) {
            if(this.mapas[i].getPercentualPixelsSimilares(new CorRGB(red, green, blue),  limiarLuminosidade) >= pctMinimo){
                mapasSimilares.pushMapa(this.mapas[i]);
            }
        }

        return mapasSimilares.getMapas();
    }

    public Mapa[] getMapasPorLuminosidade(CorRGB corRGB, double pctMinimo, double limiarLuminosidade){
        return getMapasPorLuminosidade(corRGB.getRed(), corRGB.getBlue(), corRGB.getGreen(), pctMinimo, limiarLuminosidade);
    
    }

    // public Mapa[] getMapasPorLuminosidade(String corHexadecimal, double pctMinimo, double limiarLuminosidade){
    //     // cor Haxedimal para para RGB
    // }


    // LÓGICA GET MAPAS POR LUMINOSIDADE
    
    // devo estar preparado para casos em que:
        // - a cor rgb seja um objeto
        // - a cor rgb esteja em hexa
        // - nao seja uma cor rgb, mas sim uma CMYK

        // Exemplo:

        // getImagemPorLuminosidade(0, 0, 0, 0.2, 0.1);

        // Imagem 10 x 10 - Imagem bidimensional
        // 100 pixel - quantidade de pixels
        // 20 pixels - quantidade minima de pixels
        // 28 - luminosidade da cor
        // 2.8 - Valor de similaridade = luminosidade - limiarSimilaridade.
        // 25 - Similar negativo = luminosidade - valor de similaridade
        // 31 - Similar positivo = luminosidde + valor de similaride

        // devo procurar ao menos 20 pixels em que sua luminosidade
        // deve se encontrar entre 25 e 31

         // devo retornar todos os mapas (ou imagens) que tenham água, arvores, 
         // montanhas ou qualquer outra coisa
        
         // Capa mapa é uma grande imagem

         // recebo uma lista de mapas(ou imagens)
         // vou em cada imagem(ou mapa) e aplico o filtro
         // adiciono em uma lista de mapas(ou imagens) todos aqueles 
         // em que foram encontrados a porcentagem minima
         // retorno essa lista de mapas ou (imagens)

}
