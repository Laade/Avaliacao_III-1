package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.TipoCor;
import model.Cor;
import controll.CorDAOFile;

public class JMapaUI extends JFrame implements ActionListener {

	// private ContabilLogicaIF logica;
	private Collection<String> nomeCores;

	private JButton btnAnalisarArquivo;
	private JTextField txtEnviarArquivo;
	private JTextField txtSelecionarTipo;
	private JComboBox<String> cmbEnviarArquivoo;
	private JComboBox<String> cmbSelecionarTipo;
	private JTextField txtValor;

	public void JMapaUI() throws Exception {
		// abrir pesquisa de cores?
	}

	protected void montar() {
		JPanel jPanelCenter = new JPanel();
		jPanelCenter.setLayout(new GridLayout(3, 2));
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		this.btnAnalisarArquivo = new JButton("Analisar!"); 
		this.btnAnalisarArquivo.addActionListener(this);
		jPanelCenter.add(new JPanel());
		jPanelCenter.add(new JPanel());
		
		//INCLUIR UM INPUT PARA BUSCAR AQUIVO NO EXPLORER
		jPanelCenter.setLayout(new GridLayout(6, 2));
		jPanelCenter.add(new JLabel("Informe o caminho do arquivo para avaliação:"));
		this.txtEnviarArquivo = new JTextField(); 
		jPanelCenter.add(this.txtEnviarArquivo);
		
		//CHAMAR DO BANCO OS SIMBOLOS NO DROPDOWN
		jPanelCenter.add(new JLabel("Selecione o tipo de elemento:"));
		this.cmbSelecionarTipo = new JComboBox<String>();
		
		this.getContentPane().setLayout(new BorderLayout());
		this.getContentPane().add(jPanelCenter, BorderLayout.CENTER);
		//this.getContentPane().add(jPanelSouth, BorderLayout.SOUTH);
		
		this.setTitle("Adicionar Imagem");
		this.setSize(800, 600);
	}

	public void run() {
		this.montar();
		this.setVisible(true);
	}
	
	private void loadCombo(JComboBox combo) {
		/*
		 * for(String nomeCor : this.nomeCor) combo.addItem(nomeCor);
		 */
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) throws Exception {
		(new JMapaUI()).run();  
	}
}
