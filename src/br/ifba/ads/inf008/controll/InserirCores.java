package inf008.controll;

import java.sql.SQLException;

import inf008.model.CorCMYK;
import inf008.model.CorRGB;
import inf008.controll.CorDAOSQL;

public class InserirCores {
    
    public void TabelaCores() throws Exception{
    	CorDAOSQL corDAO = new CorDAOSQL();
    	    	
	    corDAO.salvar(new CorRGB("01", "AGUAS E CHARCOS","AZUL ESCURO", 0,0,139));
		corDAO.salvar(new CorRGB("02", "AGUAS E CHARCOS","AZUL MEDIO", 0,0,205));
		corDAO.salvar(new CorRGB("03", "AGUAS E CHARCOS","AZUL ", 0,0,255));
		corDAO.salvar(new CorCMYK("04", "AGUAS E CHARCOS","AZUL CLARO", 25, 6, 0, 10));
		
		corDAO.salvar(new CorRGB("05", "VEGETACAO","VERDE ESCURO", 0,100,0));
    		corDAO.salvar(new CorRGB("06", "VEGETACAO","SELVA VERDE", 41, 171, 135));
    		corDAO.salvar(new CorCMYK("07", "VEGETACAO","VERDE CLARO", 41, 0, 48, 24));

		corDAO.salvar(new CorRGB("08", "FORMAS DO TERRENO","MARROM", 92,64,51));
		corDAO.salvar(new CorCMYK("09", "FORMAS DO TERRENO","MARROM", 0,30,45,64));
		
		corDAO.salvar(new CorRGB("10", "PEDRAS E ROCHAS","PRETO", 0, 0, 0));
		corDAO.salvar(new CorRGB("11", "PEDRAS E ROCHAS","CINZA", 128,128,128));
	
		corDAO.salvar(new CorRGB("12", "FEITOS PELO HOMEM","PRETO", 255, 0, 0));
		corDAO.salvar(new CorCMYK("13", "FEITOS PELO HOMEM","CINZA", 0, 0, 16, 50));
	
		corDAO.salvar(new CorRGB("14", "AREA ISOLADA","VERMELHO", 255, 0, 0));
		corDAO.salvar(new CorCMYK("15", "AREA ISOLADA","VERMELHO", 0, 100, 100, 0));
	
	    
    }

}
