package controll;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import model.Cor;

public class CorDAOFile implements CorDAOIF {

	private static String COR_FILE_NAME = "D:\\COR.BIN"; 
	
	  public List<Cor> cores;
	  
	  
	  private void readFileCor() throws IOException, ClassNotFoundException{
		  FileInputStream in = new FileInputStream(CorDAOFile.COR_FILE_NAME);
		  ObjectInputStream ois = new ObjectInputStream(in);
		  this.cores = (List<Cor>) ois.readObject();
		  ois.close();
		  in.close();
	  }
	  
	  private void writeFileCor() throws IOException {
		  FileOutputStream out = new FileOutputStream(CorDAOFile.COR_FILE_NAME);
		  ObjectOutputStream oos = new ObjectOutputStream(out);
		  oos.writeObject(this.cores);
		  oos.close();
		  out.close();
	  }
	  
	  public CorDAOFile() throws ClassNotFoundException, IOException {
		    this.cores = new ArrayList<Cor>();
		    try {
		    	this.readFileCor();
		    }catch(FileNotFoundException ex) {
		    	
		    }
	  }
	  
	  public void salvar(Cor cor) throws IOException{
		  this.cores.add(cor);
		  this.writeFileCor();
	  } 

	   
	  
	  public Collection<Cor> findAll() {
		  return this.cores;
	  }

	  
	@Override
	  public void atualizar(Cor c) throws Exception {
		  int index = this.cores.indexOf(c);
		  if(index == -1)
			   throw new CorInexistenteException(c.toString());
		  this.cores.remove(index);
		  this.cores.add(c);
		  this.writeFileCor();
	  }
	  
	
	public int pesquisarCor (Cor cor) throws ClassNotFoundException, IOException {
		this.cores = new ArrayList<Cor>();
	      	this.readFileCor();
	      	
	    int count = 0;
	    
	    for(Cor colors : this.cores) {
	    	if(colors.isEqual(cor)) {
	    		count++;
	    	}
	    }
		return (count/cores.size() * 100);
		//retornando a porcentagem
		
		
	}
	
	
	
}
