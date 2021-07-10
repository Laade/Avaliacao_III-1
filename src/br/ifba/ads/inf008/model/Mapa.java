package inf008.model;

// TO-DO
// [] ADICIONAR ID E DESCRICAO A CADA MAPA
// [] ADICIONAR UM MÉTODO TOSTRING QUE PEGA A DESCRICAO DO MAPA E O SEU FORMATO


public abstract class Mapa {

    public Mapa() {
        
    }

    // Toda classe que herdar de mapa deve implementar esses métodos
    public abstract void setPixel(int altura, int largura, Cor pixel);
    public abstract Cor[][] getImagem();
    public abstract Cor getPixel(int altura, int largura);

    public int getAltura(){
        return this.getImagem().length;
    }  

    public int getLargura(){
        return this.getImagem()[0].length;
    }

    public int getArea(){
        return this.getAltura() * this.getLargura();
    }

    public double getPercentualPixelsSimilares(CorRGB cor, double limiarLuminosidade){

        int pixelsSimilares = 0;
        
        int luminosidadeGlobal = cor.getLuminosidade();
        int valorSimilaridade = (int)(luminosidadeGlobal - limiarLuminosidade);
        int similaridadeMinimo = (int)(luminosidadeGlobal - valorSimilaridade);
        int similaridadeMaximo = (int)(luminosidadeGlobal + valorSimilaridade);
        

        for(int i = 0; i <= this.getAltura(); i++)
          for(int j = 0; j <= this.getLargura(); j++){
                int luminosidadeLocal = this.getPixel(i, i).getLuminosidade();
                if(similaridadeMinimo >= luminosidadeLocal && similaridadeMaximo <= luminosidadeLocal)
                    pixelsSimilares ++;
          } 
        
        return (double)pixelsSimilares / this.getArea() * 100;    

    }
}


