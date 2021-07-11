package model;

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
