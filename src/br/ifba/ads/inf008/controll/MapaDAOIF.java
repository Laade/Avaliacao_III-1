package inf008.controll;

import java.io.IOException;

import inf008.model.Mapa;

public interface MapaDAOIF {
    
    public void salvar(Mapa m) throws IOException;
    public Mapa ler(String caminhoArquivo) throws IOException, ClassNotFoundException;

}
