package inf008.model;

public class CorRGB extends Cor {

	public static final CorRGB PRETA = new CorRGB(null, "PRETA", null, 0, 0, 0);
	public static final CorRGB BRANCA = new CorRGB(null, "BRANCA", null, 255, 255, 255);
	public static final CorRGB RED = new CorRGB(null, "RED", null, 255, 0, 0);
	public static final CorRGB GREEN = new CorRGB(null, "GREEN", null, 0, 255, 0);
	public static final CorRGB BLUE = new CorRGB(null, "BLUE", null, 0, 0, 255);

	private int red;
	private int green;
	private int blue;

	public CorRGB(int red, int green, int blue) {
		super(red, green, blue);
	}

	// Quando a cor RGB � chamada sem par�metros ela retorna uma cor preta
	public CorRGB() {
		this(null, "PRETA", null, 0, 0, 0);
	};

	// Construtor de C�pia
	public CorRGB(String id, String descricao, String simbolo, CorRGB cor) {
		this(null, descricao, simbolo, cor.getRed(), cor.getGreen(), cor.getBlue());
	}

	// Contrutor Cria Cor RGB
	public CorRGB(String id, String descricao, String simbolo, int red, int green, int blue) {
		super(id, descricao, simbolo);
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
		if (cor < 0) {
			return 0;
		}
		if (cor > 255) {
			return 255;
		}
		return cor;
	}

	@Override
	public int getLuminosidade() {
		return validaLuminosidade((int) ((this.getRed() * 0.3) + (this.getGreen() * 0.59) + (this.getBlue() * 0.11)));
	}

	private int validaLuminosidade(int value) {
		return value <= 0 ? 0 : value;
	}

	@Override
	public boolean equals(Object cor) {
		if (cor instanceof CorRGB) {
			CorRGB rgb = (CorRGB) cor;
			return (this.getRed() == rgb.getRed()) && (this.getGreen() == rgb.getGreen())
					&& (this.getBlue() == rgb.getBlue());
		} else {
			return false;
		}
	}

	public String getcorHex() {
		String sRed = Integer.toHexString(this.getRed());
		String sGreen = Integer.toHexString(this.getGreen());
		String sBlue = Integer.toHexString(this.getBlue());

		return ("#" + sRed + sGreen + sBlue).toUpperCase();
	}

	public CorRGB getGrayScale() {
		return new CorRGB(null, null, null, this.getLuminosidade(), this.getLuminosidade(), this.getLuminosidade());
	}

	public int formatoCor(Cor cor) {

		return 0;
	}

	public String getCodTipo() {
		return "R";
	}

}