package inf008.model;

public class CorRGB extends Cor{

    public static final CorRGB PRETA = new CorRGB(0, 0, 0);
	public static final CorRGB BRANCA = new CorRGB(255, 255, 255);
	public static final CorRGB RED = new CorRGB(255, 0, 0);
	public static final CorRGB GREEN = new CorRGB(0, 255, 0);
	public static final CorRGB BLUE = new CorRGB(0, 0, 255);

    private int red;
    private int green;
    private int blue;

    // Quando a cor RGB é chamada sem parâmetros ela retorna uma cor preta
    public CorRGB(){
        this(0,0,0);
    };

     // Construtor de Cópia
     public CorRGB(CorRGB cor) {
        this(cor.getRed(), cor.getGreen(), cor.getBlue());
    }

    // Contrutor Cria Cor RGB
    public CorRGB(int red, int green, int blue){
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    public int getRed() {
        return this.red;
    }
    
    public int getGreen() {
        return this.green;
    }

    public int getBlue() {
        return this.blue;
    }

    public void setRed(int red) {
        this.red = this.validaCor(red);
    }

    public void setGreen(int green) {
        this.green = this.validaCor(green);
    }

    public void setBlue(int blue) {
        this.blue = this.validaCor(blue);
    }

    @Override
    protected int validaCor(int cor) {
        if(cor < 0){
            return 0;
          }
          if(cor > 255){
              return 255;
          }
          return cor;  
    }

    @Override
    public int getLuminosidade() {
        return validaLuminosidade((int)((this.getRed() * 0.3) + 
                                        (this.getGreen() * 0.59) + 
                                        (this.getBlue() * 0.11)));
    }

    private int validaLuminosidade(int value) {
        return value <= 0 ? 0 : value;
    }

    public boolean isEqual(CorRGB rgb) {
        return (this.getRed() == rgb.getRed()) && (this.getGreen() == rgb.getGreen()) && (this.getBlue() == rgb.getBlue());
    }

    public String getcorHex(){
        String sRed = Integer.toHexString(this.getRed());
        String sGreen = Integer.toHexString(this.getGreen());
        String sBlue = Integer.toHexString(this.getBlue());

        return ("#" + sRed + sGreen + sBlue).toUpperCase();
    }

    public CorRGB getGrayScale() {
		return new CorRGB(this.getLuminosidade(), 
						  this.getLuminosidade(), 
						  this.getLuminosidade());
	}

    


    // public void clarear(double percent) {
	// 	percent = 1 + percent;
	// 	this.mudarPct(percent);		
	// }
	
	// public void escurecer(double percent) {
	// 	percent = 1 - percent;
	// 	this.mudarPct(percent);
	// }
	
	// private void mudarPct(double percent) {
	// 	this.setRed((int)(this.getRed() * percent));
	// 	this.setGreen((int)(this.getGreen() * percent));
	// 	this.setBlue((int)(this.getBlue() * percent));
	// }
    
}
