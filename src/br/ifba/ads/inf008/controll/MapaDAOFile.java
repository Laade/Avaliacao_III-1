package inf008.controll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import inf008.model.Mapa;

public class MapaDAOFile implements MapaDAOIF {

    public Mapa mapa;

    public MapaDAOFile(Mapa mapa, String caminhoArquivo) throws ClassNotFoundException, IOException {
        this.mapa = mapa;
        try {
            this.readFileMApa(caminhoArquivo);
        }catch(FileNotFoundException ex) {

        }
      }

     private void readFileMApa(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(caminhoArquivo + ".bin");
        ObjectInputStream ois = new ObjectInputStream(in);
        this.mapa = (Mapa) ois.readObject();
        ois.close();
        in.close();
    }

    private void writeFileMapa() throws IOException {
        String nomeArquivo = this.mapa.getDescricao();
        FileOutputStream out = new FileOutputStream("D:\\" + nomeArquivo + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(this.mapa);
        oos.close();
        out.close();
    }

    @Override
    public void salvar(Mapa m) throws IOException {
        this.mapa = m;
        this.writeFileMapa();
    }
    
}
