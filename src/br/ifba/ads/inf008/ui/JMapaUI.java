package inf008.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
//import java.io.IOException;
//import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import JMapaSistemaUI.JMapaSistemaUI;

import javax.swing.JFileChooser;

//import inf008.model.TipoCor;
//import inf008.model.Cor;

public class JMapaUI extends JFrame implements ActionListener{
	
	// private ContabilLogicaIF logica;
	//private Collection<String> nomeCores;
	
	private static final long serialVersionUID = 1L;
	private JButton btnAnalisarArquivo;
	private JButton btnBuscarArquivo;
	private JComboBox<String> cmbEnviarArquivo;	
	private JTextField txtEnviarArquivo;
		
	/*
	public JavaUI() throws Exception {
		
	}
	*/
	
	private void montar(){
		// Botoes
		this.btnAnalisarArquivo = new JButton("Pesquisar");
		this.btnBuscarArquivo = new JButton("Verificar"); 
		
		// TextFilds
		this.txtEnviarArquivo = new JTextField(); 
		
		this.cmbEnviarArquivo = new JComboBox<String>();
		//this.loadCombo(this.cmbSimbolos); 
		
    }
	
protected void configLayout(){
		
		// Incluindo areas da tela
		JPanel jPanelCenter = new JPanel();
		JPanel jPanelSouth = new JPanel();
		
		
		jPanelCenter.setLayout(new GridLayout(7, 4));
		
		// espaçamento superior
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		
		// Inclusor do caminho da imagem
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JLabel("Informe o caminho do arquivo para analise:"));
		jPanelCenter.add(this.txtEnviarArquivo);
		jPanelCenter.add(btnBuscarArquivo);
		
		// espaçamento central
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		
		
		// Incluindo dropdown elementos
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JLabel("Selecione o tipo de elemento:"));
		this.cmbEnviarArquivo = new JComboBox<String>();
		jPanelCenter.add(this.cmbEnviarArquivo);
		jPanelCenter.add(new JPanel());
		
		// espaçamento final
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		
		
		//Montando o panel na area sul onde vai ancorar o botão
		jPanelSouth.setLayout(new GridLayout(2, 2));
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(new JPanel());
		jPanelSouth.add(btnAnalisarArquivo);
		jPanelSouth.add(new JPanel());
		
		// Setando layout
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		this.getContentPane().add(jPanelSouth, BorderLayout.SOUTH);
		this.setTitle("Verificar Mapa");
		this.setSize(800, 600);	
	}
	//private void loadCombo(JComboBox combo) {
	
	//}
	
	protected void configEvents() {
		this.btnAnalisarArquivo.addActionListener(this);
		this.btnBuscarArquivo.addActionListener(this);
	}

	public void run() {
		this.montar();
        this.configEvents();
        this.configLayout();
		this.setVisible(true);
	}
public void actionPerformed(ActionEvent args0) {
		
		if( args0.getSource() == this.btnBuscarArquivo){
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
			int result = fileChooser.showOpenDialog(this);
			if (result == JFileChooser.APPROVE_OPTION) {
			    File selectedFile = fileChooser.getSelectedFile();
			    this.txtEnviarArquivo.setText(selectedFile.getAbsolutePath());
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		(new JMapaUI()).run();  
	}
}