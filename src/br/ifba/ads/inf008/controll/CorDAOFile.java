package inf008.controll;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.StringTokenizer;

import inf008.model.Cor;


public class CorDAOFile implements CorDAOIF {

	private String caminhoArquivo;	
	public List<Cor> cores;

	  public CorDAOFile() throws ClassNotFoundException, IOException {
		this.cores = new ArrayList<Cor>();
		try {
			this.readFileCor();
		}catch(FileNotFoundException ex) {
			
		}
  	}
  
	  private void readFileCor() throws IOException, ClassNotFoundException{
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
	  
	  
	  public void salvar(Cor cor) throws IOException{
		  this.cores.add(cor);
		  this.writeFileCor();
	  } 

	   
	  
	  public Collection<Cor> findAll() {
		  return this.cores;
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
	
// private boolean isRGB() throws IOException {
        
//         String caminhoArquivo = null;
// 		FileReader reader = new FileReader(caminhoArquivo); 
//         BufferedReader leitor = new BufferedReader(reader);

//         String amostraImagem = null;

//         while(leitor.readLine() != ";") {
//             amostraImagem = leitor.readLine();
//         }   

//         // RGB (0,0,0) - (255,255,255)
//         // HEX 	#000000 - #FFFFFF
//         // CMYK (0,0,0,1) - (0,0,0,0)

//         // rgb min 4, mx 10
//         // hex tamnho = 6
//         // cmyk tamho = 6

//         if( amostraImagem.length() >= 4  && amostraImagem.length() <= 10) {
//             return true;
//         }

//         if(amostraImagem.substring(0, 1) == "#") {
//                 // é hexa
//             } else {
//                 // é CMYK
//             }

        
        

//         return true;

        
//         }
	
}