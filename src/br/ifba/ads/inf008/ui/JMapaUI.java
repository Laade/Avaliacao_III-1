package inf008.ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
//import java.io.IOException;
//import java.util.Collection;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import inf008.controll.CorDAOFile;
import inf008.controll.CorDAOSQL;
import inf008.controll.SimboloDAOSQL;
import inf008.model.Cor;
import inf008.model.Simbolo;
import javax.swing.JFileChooser;


public class JMapaUI extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JButton btnAnalisarArquivo;
	private JButton btnBuscarArquivo;
	private JComboBox<String> simboloComboBox;
	private JTextField txtEnviarArquivo;
	private String caminhoArquivo;// variavel para guardar o que o usuario selecionou

	private void montar() {
		// Botoes
		this.btnAnalisarArquivo = new JButton("Pesquisar");
		this.btnBuscarArquivo = new JButton("Verificar");

		// TextFilds
		this.txtEnviarArquivo = new JTextField();

		this.simboloComboBox = new JComboBox<String>();
		// this.loadCombo(this.cmbSimbolos);

	}

	protected void configLayout() {

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
		this.simboloComboBox = new JComboBox<String>();
		try {
			SimboloDAOSQL simboloDAO = new SimboloDAOSQL();
			ArrayList<Simbolo> simbolos = simboloDAO.findAll();

			for (Simbolo simbolo : simbolos) {
				simboloComboBox.addItem(simbolo.getDescricao());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		jPanelCenter.add(this.simboloComboBox);
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

		// Montando o panel na area sul onde vai ancorar o botão
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

		if (args0.getSource() == this.btnBuscarArquivo) {
			//pegar o caminho absoluto do arquivo
			caminhoArquivo = txtEnviarArquivo.getText();

		} else if(args0.getSource() == this.btnAnalisarArquivo) {
			
			String simboloSelecionado = (String) this.simboloComboBox.getSelectedItem();
			
			try {
				CorDAOSQL coresSQL = new CorDAOSQL();
				
				ArrayList<Cor> coresPorSimbolo = (ArrayList<Cor>) coresSQL.findBySimbolo(simboloSelecionado);
				
				CorDAOFile coresDAO = new CorDAOFile(caminhoArquivo);
				
				int porcentagem = 0;
				
				for (Cor cor : coresPorSimbolo) {
					porcentagem += coresDAO.pesquisarCor(cor);
				}
				
				JOptionPane.showMessageDialog(this, "Para o simbolo " +simboloSelecionado+" a porcentagem encontrada é de " + porcentagem);
				
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			
			
			
		}
	}

	public static void main(String[] args) throws Exception {
		(new JMapaUI()).run();
	}
}