package inf008.controll;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

import inf008.model.Mapa;

public class MapaDAOFile implements MapaDAOIF {

    public Mapa mapa;

    private void readFileMApa() throws IOException, ClassNotFoundException {

    }

    private void writeFileMapa() throws IOException {

    }

    @Override
    public void salvar(Mapa m) throws IOException {
        String nomeArquivo = m.getDescricao();
        FileOutputStream out = new FileOutputStream("D:\\" + nomeArquivo + ".bin");
        ObjectOutputStream oos = new ObjectOutputStream(out);
        oos.writeObject(m);
        oos.close();
    }

    @Override
    public Mapa ler(String caminhoArquivo) throws IOException, ClassNotFoundException {
        FileInputStream in = new FileInputStream(caminhoArquivo + ".bin");
        ObjectInputStream ois = new ObjectInputStream(in);
        Mapa mapa = (Mapa) ois.readObject();
        ois.close();

        return mapa;
    }
    
}
