package inf008.controll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import inf008.model.Cor;

public class CorDAOFile implements CorDAOIF {

	private String caminhoArquivo;
	public List<Cor> cores;

	public CorDAOFile(String caminhoArquivo) throws ClassNotFoundException, IOException {
		this.cores = new ArrayList<Cor>();
		try {
			this.readFileCor(caminhoArquivo);
		} catch (FileNotFoundException ex) {

		}
	}

	private void readFileCor(String caminhoArquivo) throws IOException, ClassNotFoundException {
		FileInputStream in = new FileInputStream(caminhoArquivo);
		ObjectInputStream ois = new ObjectInputStream(in);
		this.cores = (List<Cor>) ois.readObject();

		ois.close();
		in.close();
	}

	private void writeFileCor() throws IOException {
		FileOutputStream out = new FileOutputStream(caminhoArquivo);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(this.cores);
		oos.close();
		out.close();
	}

	public int pesquisarCor(Cor cor) throws ClassNotFoundException, IOException {
		this.cores = new ArrayList<Cor>();
		
		int count = 0;

		for (Cor colors : this.cores) {
			if (colors.equals(cor)) {
				count++;
			}
		}
		return (count / cores.size() * 100);
		// retornando a porcentagem
	}

	public void salvar(Cor cor) throws IOException {
		this.cores.add(cor);
		this.writeFileCor();
	}

	public Collection<Cor> findAll() {
		return this.cores;
	}
	
	@Override
	public Collection<Cor> findBySimbolo(String s) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}