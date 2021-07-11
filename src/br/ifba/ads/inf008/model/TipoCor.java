package inf008.model;

// vai determinar qual é o tipo de cor
public enum TipoCor {
	CorRGB(1), CorCMYK(2);
    
    private int codTipo;
    
    TipoCor(int codTipo){
        this.codTipo = codTipo;
    }  
    
    public int value(){
        return codTipo;
    }    

}
