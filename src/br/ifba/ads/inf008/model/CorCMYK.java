package inf008.model;

public class CorCMYK extends Cor{

    public static final CorCMYK CIANO = new CorCMYK(null, "CIANO", null, 100,0,0,0);
    public static final CorCMYK MAGENTO = new CorCMYK(null, "MAGENTO", null, 0,100,0,0);
    public static final CorCMYK AMARELO = new CorCMYK(null, "AMARELO", null, 0,0,100,0);
    public static final CorCMYK PRETA = new CorCMYK(null, "PRETA", null, 0,0,0,100);
    public static final CorCMYK BRANCA = new CorCMYK(null, "BRANCA", null, 0,0,0,0);

    private int cyan;
    private int magente;
    private int yellow;
    private int keyBlack;
    
    // se construtor for vazio cria uma cor branca
    public CorCMYK() {
    	this(null, "PRETA", null, 0, 0, 0, 100);
    }

    public CorCMYK(String id, String descricao, Simbolo simbolo, int cyan, int magente, int yellow, int keyBlack) {
        super(id, descricao, simbolo);
    	this.setCyan(cyan);
        this.setMagente(magente);
        this.setYellow(yellow);
        this.setkeyBlack(keyBlack);
    }

    public CorCMYK(int cyan, int magente, int yellow, int keyBlack) {
        super(null, null, null);
    	this.setCyan(cyan);
        this.setMagente(magente);
        this.setYellow(yellow);
        this.setkeyBlack(keyBlack);
    }

    public int getCyan() {
        return this.cyan;
    }

    public int getMagente() {
        return this.magente;
    }

    public int getYellow() {
        return this.yellow;
    }

    public int getkeyBlack() {
        return this.keyBlack;
    }

    private void setCyan(int cyan) {
        this.cyan = validaCor(cyan);
    }

    private void setMagente(int magente) {
        this.magente = validaCor(magente);
    }
    private void setYellow(int yellow) {
        this.yellow = validaCor(yellow);
    }
    private void setkeyBlack(int keyBlack) {
        this.keyBlack = validaCor(keyBlack);
    }

    @Override
    public int getLuminosidade() {
        return (int)((this.getkeyBlack() * 255) / 100);
    }

    public boolean equals(CorCMYK cor){
        return ((this.getCyan() == cor.getCyan()) && (this.getMagente() == cor.getMagente()) && (this.getYellow() == cor.getYellow()) && (this.getkeyBlack() == cor.getkeyBlack()));
    }

    @Override
    protected int validaCor(int cor) {
        if(cor < 0){
            return 0;
          }
          if(cor > 100){
              return 100;
          }
          return cor; 
    };
    
	@Override
	public boolean equals(Object cor) {
		if(cor instanceof CorRGB) {
    		CorRGB corRgb = this.gerarCorRGB();
    		return corRgb.equals(cor);
    	}
    	else if(cor instanceof CorCMYK) {
    		return ((this.getCyan() ==((CorCMYK) cor).getCyan()) && (this.getMagente() == ((CorCMYK) cor).getMagente()) && (this.getYellow() == ((CorCMYK) cor).getYellow()) && (this.getkeyBlack() == ((CorCMYK) cor).getkeyBlack()));
    	} else {
    		return false;
    	}
	}

    public CorRGB gerarCorRGB(){
        
        CorRGB cor = new CorRGB(this.getId(),this.getDescricao(),this.getSimbolo(), 
                                (int)(255 * (1 - ((double)this.getCyan()/100)) *  (1-((double)this.getkeyBlack()/100))), 
                                (int)(255 * (1 - ((double)this.getMagente()/100)) *  (1-((double)this.getkeyBlack()/100))),
                                (int)(255 * (1 - ((double)this.getYellow()/100)) *  (1-((double)this.getkeyBlack()/100)))
                            );
        return cor;
    } 
    
	
	public String getCodTipo(){
        return "C";
    };
     
}