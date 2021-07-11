package inf008.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import model.Cor;
import model.CorCMYK;
import model.CorRGB;
import model.TipoCor;

public class CorSQL implements CorDAOIF {
	
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	
	private static final String USUARIO = "sa";
	private static final String SENHA = "";
	
	//private static final int FORMATO_RGB = 0;
	//private static final int FORMATO_CMYK = 1;	
	
	private static final String INSERT = "INSERT INTO COR(id, descricao, simbolo, red, green, blue, cyan, magenta, yellow, keyblack) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	
	private final String CREATE = "CREATE TABLE COR " 
			  + "(id VARCHAR(25) NOT NULL," 
			  + " descricao VARCHAR(25) NOT NULL, " 
			  + " simbolo VARCHAR(35) NOT NUL, "
			  + " red INT, "
			  + " green INT, "
			  + " blue INT, "
			  + " cyan INT, "
			  + " magenta INT, "
			  + " yellow INT, "
			  + " keyblack INT, "
			  + " PRIMARY KEY (id))";
	
	private static final String CONSULTAR_DESCRICAO = "SELECT id, descricao, simbolo, red, green, blue, cyan, magenta, yellow, keyblack FROM COR WHERE descricao = ?";
	private static final String CONSULTAR_SIMBOLO = "SELECT id, descricao, simbolo, red, green, blue, cyan, magenta, yellow, keyblack FROM COR WHERE simbolo = ?";
	
	public CorSQL() {
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	}
	
	private Connection getConn() throws SQLException {
		return  DriverManager.getConnection(CorSQL.URI, CorSQL.USER, CorSQL.PWD); 
	}

	
	
	@Override
	public void adicionar(Cor c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(INSERT);
		pStmt.setString(1, c.getId());
		pStmt.setString(2, c.getDescricao());
		pStmt.setString(3, c.getSimbolo());

		if(c instanceof CorRGB) {
			CorRGB cor = (CorRGB) c;
			pStmt.setInt(4, cor.getRed());
			pStmt.setInt(5, cor.getGreen());
			pStmt.setInt(6, cor.getBlue());
			pStmt.setInt(7, 0);
			pStmt.setInt(8, 0);
			pStmt.setInt(9, 0);
			pStmt.setInt(10, 0);
		}
	else {
			CorCMYK cor = (CorCMYK) c;
			pStmt.setInt(4, 0);
			pStmt.setInt(5, 0);
			pStmt.setInt(6, 0);
			pStmt.setInt(7, cor.getCyan());
			pStmt.setInt(8, cor.getMagente());
			pStmt.setInt(9, cor.getYellow());
			pStmt.setInt(10, cor.getkeyBlack());
	}
		
		pStmt.executeUpdate();
	}
	
	private int getTipoCor(Cor c) {
		if(c instanceof CorRGB)
			return TipoCor.CorRGB.value();
		else if (c instanceof CorCMYK)
			return TipoCor.CorCMYK.value();
		else
			return -1;
	}
	
	public Cor findByDescricao(String descricao)  {
		//criar CONSULTAR_DESCRICAO
	}
	
	public Cor findBySimbolo(String descricao)  {
		//criar CONSULTAR_SIMBOLO
	}
	

	@Override
	public int pesquisarCor(Cor c) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}
