package inf008.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import inf008.model.Cor;
import inf008.model.CorCMYK;
import inf008.model.CorRGB;
import inf008.model.TipoCor;

public class CorDAOSQL implements CorDAOIF {
	
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "";
	
	private static final String COR_INSERT = "INSERT INTO COR(ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
												" GREEN, BLUE, CYAN, MAGENTE, YELLOW,\r\n" + 
												" KEY, TIPO_COR)\r\n" + 
												" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

	private static final String COR_UPDATE = "UPDATE COR SET ID = ?, DESCRICAO = ?, SIMBOLO = ?, RED = ?,\r\n" + 
												" GREEN = ?, BLUE = ?, CYAN = ?, MAGENTE = ?, YELLOW = ?,\r\n" + 
												" KEY = ?, TIPO_COR = ?";
	
	private static final String COR_SELECT_BY_DESCRICAO = "SELECT ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
															" GREEN, BLUE, CYAN, MAGENTE, YELLOW,\r\n" + 
															" KEY, TIPO_COR\r\n" + 
															" FROM COR \r\n" +
															" WHERE DESCRICAO = ? \r\n";

	private static final String COR_SELECT_BY_SIMBOLO = "SELECT ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
															" GREEN, BLUE, CYAN, MAGENTE, YELLOW,\r\n" + 
															" KEY, TIPO_COR\r\n" + 
															" FROM COR \r\n" +
															" WHERE SIMBOLO = ? \r\n";

	private static final String COR_SELECT_ALL = "SELECT ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
													" GREEN, BLUE, CYAN, MAGENTE, YELLOW,\r\n" + 
													" KEY, TIPO_COR\r\n" + 
													" FROM COR";

	private static final String COR_SELECT_ALL_SIMBOLO = "SELECT SIMBOLO\r\n" + 
															" FROM COR";


	// public CorDAOSQL() throws SQLException {
	// 	DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	// }
	
	private Connection getConn() throws SQLException {
		return  DriverManager.getConnection(CorDAOSQL.URI, CorDAOSQL.USER, CorDAOSQL.PWD); 
	}

	@Override
	public void salvar(Cor c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_INSERT);
		this.preencheTodosOsCampos(pStmt, c);
	}

	@Override
	public void atualizar(Cor c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_UPDATE);
		this.preencheTodosOsCampos(pStmt, c);
	}
	
	@Override
	public Cor findByDescricao(String descricao) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_BY_DESCRICAO);
		pStmt.setString(1, descricao);
		ResultSet rSet = pStmt.executeQuery();

		if(!rSet.next())
			throw new CorInexistenteException(descricao);
		
		return setCor(rSet);
	}

	// Existirão várias cores diferentes que irão possuir o mesmo símbolo
	@Override
	public Collection<Cor> findBySimbolo(String simbolo) throws Exception {
		Set<Cor> cores = new HashSet<Cor>();
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_BY_SIMBOLO);
		pStmt.setString(1, simbolo);
		ResultSet rSet = pStmt.executeQuery();

		while(rSet.next()) {
			cores.add(setCor(rSet));
		}
		return cores;
	}

	

	@Override
	public Collection<Cor> findAll() throws Exception {
		Set<Cor> cores = new HashSet<Cor>();
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_ALL);
		ResultSet rSet = pStmt.executeQuery();

		while(rSet.next()) {
			cores.add(setCor(rSet));
		}
		return cores;
	}

	public Collection<String> findAllSimbolo() throws Exception {
		Set<String> simbolos = new HashSet<String>();
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_ALL_SIMBOLO);
		ResultSet rSet = pStmt.executeQuery();

		while(rSet.next()) {
			String simbolo = rSet.getString("simbolo");
			simbolos.add(simbolo);
		}

		return simbolos;
	}

	private void preencheTodosOsCampos(PreparedStatement pStmt, Cor c) throws Exception {
		pStmt.setString(1, c.getId());
		pStmt.setString(2, c.getDescricao());
		pStmt.setString(3, c.getSimbolo());
		this.setCoresTipo(pStmt, c);
		pStmt.executeUpdate();
		pStmt.close();
	}

	private void setCoresTipo(PreparedStatement pStmt, Cor c) throws Exception {
		if(c instanceof CorRGB) {
			CorRGB cor = (CorRGB) c;
			pStmt.setInt(4, cor.getRed());
			pStmt.setInt(5, cor.getGreen());
			pStmt.setInt(6, cor.getBlue());
			pStmt.setInt(7, 0);
			pStmt.setInt(8, 0);
			pStmt.setInt(9, 0);
			pStmt.setInt(10, 0);
			pStmt.setInt(11, TipoCor.CorRGB.value());
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
			pStmt.setInt(11, TipoCor.CorCMYK.value());
		}
	}

	private Cor setCor(ResultSet rSet) throws Exception {
		Cor c = null;

		String id = rSet.getString("id");
		String sDescricao = rSet.getString("descricao");
		String simbolo = rSet.getString("simbolo");
		int tipoCor = rSet.getInt("tipo_cor");

		if(tipoCor == TipoCor.CorRGB.value()) {
			int red = rSet.getInt("red");
			int green = rSet.getInt("green");
			int blue = rSet.getInt("blue");

			return c = new CorRGB(id, sDescricao, simbolo, red, green, blue);

		} else if (tipoCor == TipoCor.CorCMYK.value()){
			int cyan = rSet.getInt("cyan");
			int magente = rSet.getInt("magente");
			int yellow = rSet.getInt("yellow");
			int key = rSet.getInt("key");

			return c = new CorCMYK(id, sDescricao, simbolo, cyan, magente, yellow, key);
		}

		return c;
	}


	
}