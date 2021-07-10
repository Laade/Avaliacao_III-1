package inf008.model;

public class MapaRGB extends Mapa{
    private CorRGB[][] pixels;

	public MapaRGB(int altura, int largura, CorRGB[][] mapa) {
		this.pixels = mapa;
	}
	
	// Caso nenhuma imagem seja passada, ele criará uma imagem em branco
	public MapaRGB(int altura, int largura) {
		this.pixels = new CorRGB[altura][largura];
		for(int iCont = 0; iCont < this.pixels.length; iCont++)
			for(int jCont = 0; jCont < this.pixels[iCont].length; jCont++)
				this.pixels[iCont][jCont] = CorRGB.BRANCA;
	}
	
	@Override
	public void setPixel(int altura, int largura, Cor pixel) {
		this.pixels[altura][largura] = (CorRGB)pixel;
	}
	
	public void setPixel(int altura, int largura, int red, int green, int blue) {
		this.setPixel(altura, largura, new CorRGB(red, green, blue));
	}

	@Override 
	public Cor[][] getImagem() {
		return this.pixels;
	}	

	@Override 
	public CorRGB getPixel(int altura, int largura){
		return this.pixels[altura][largura];
	}
	
	public boolean equals(MapaRGB imagem) {
		if(this.getAltura() != imagem.getAltura() ||
		   this.getLargura() != imagem.getLargura())
		     return false;
		
		for(int iCont = 0; iCont < this.pixels.length; iCont++)
			for(int jCont = 0; jCont < this.pixels[iCont].length; jCont++)
				if(!this.pixels[iCont][jCont].equals(imagem.pixels[iCont][jCont]))
					return false;
		return true;					
	}
	
	// public MapaRGB getGrayScale() {
	// 	MapaRGB grayScale = new MapaRGB(this.getAltura(), this.getLargura());
	// 	for(int iCont = 0; iCont < this.pixels.length; iCont++)
	// 		for(int jCont = 0; jCont < this.pixels[iCont].length; jCont++)
	// 			grayScale.setPixel(iCont, jCont, this.getPixel(iCont, jCont).getGrayScale());
	// 	return grayScale;
	// }
	
	// public MapaRGB clone() {
	// 	return this.recortar(0, 0, this.getAltura(), this.getLargura());
	// }
	
	// public boolean isFragmento(MapaRGB imagem) {
	// 	MapaRGB copia = imagem.clone();
	// 	for(int iCont = 0; iCont < 4; iCont++) {
	// 		if(this.fragmento(copia))
	// 			return true;
	// 		copia = copia.girar90();		
	// 	}	
	// 	return false;
	// }
	
	// private boolean fragmento(MapaRGB imagem) {
	// 	for(int iCont = 0; iCont <= this.getAltura() - imagem.getAltura(); iCont++)		
	// 		for(int jCont = 0; jCont <= this.getLargura() - imagem.getLargura(); jCont++)
	// 			if (this.recortar(iCont, jCont, imagem.getAltura(), imagem.getLargura()).equals(imagem))
	// 				return true;
	// 	return false;
	// }
	
	// public MapaRGB recortar(int x, int y, int hTam, int lTam) {
	// 	int altura = ((this.getAltura() - x) < hTam) ? (this.getAltura() - x) : hTam;
	// 	int largura = ((this.getLargura() - y) < lTam) ? (this.getLargura() - y) : lTam;
		
	// 	MapaRGB nova = new MapaRGB(altura, largura);
	// 	for(int iCont = x, iNova = 0; iCont < altura + x; iCont++, iNova++)
	// 		for(int jCont = y, jNova = 0; jCont < largura + y; jCont++, jNova++)
	// 			nova.setPixel(iNova, jNova, this.getPixel(iCont, jCont));
	// 	return nova;
	// }
	
	// public MapaRGB girar90() {
	// 	MapaRGB nova = new MapaRGB(this.getLargura(), this.getAltura());
		
	// 	for(int jCont = 0; jCont < this.getLargura(); jCont++)
	// 		for(int iCont = this.getAltura() - 1, iNova = 0; iCont >= 0; iCont--, iNova++)
	// 			nova.setPixel(jCont, iNova, this.getPixel(iCont, jCont));
	// 	return nova;			
	// }

	

}