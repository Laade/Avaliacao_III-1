package inf008.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import inf008.model.Cor;
import inf008.model.CorCMYK;
import inf008.model.CorRGB;
import inf008.model.Simbolo;
import inf008.model.TipoCor;

public class CorDAOSQL implements CorDAOIF {

	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "dexter";

	private static final String COR_SELECT_ALL = "SELECT * FROM COR";
	private static final String COR_INSERT = "INSERT INTO COR(ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
														" GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
														" KEYBLACK, TIPOCOR)\r\n" + 
														" VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String COR_SELECT_BY_SIMBOLO = "SELECT ID, DESCRICAO, SIMBOLO, RED,\r\n" + 
														" GREEN, BLUE, CYAN, MAGENTA, YELLOW,\r\n" + 
														" KEYBLACK, TIPOCOR\r\n" + 
														" FROM COR \r\n" +
														" WHERE SIMBOLO = ? \r\n";


	public CorDAOSQL() throws SQLException {
		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	}

	private Connection getConn() throws SQLException {
		return DriverManager.getConnection(CorDAOSQL.URI, CorDAOSQL.USER, CorDAOSQL.PWD);
	}

	@Override
	public Collection<Cor> findAll() throws Exception {
		ArrayList<Cor> cores = new ArrayList<Cor>();
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_ALL);
		ResultSet rSet = pStmt.executeQuery();

		while (rSet.next()) {
			cores.add(setCor(rSet));
		}
		return cores;
	}

	@Override
	public void salvar(Cor c) throws Exception {
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_INSERT);
		pStmt.setString(1, c.getId());
		pStmt.setString(2, c.getDescricao());
		pStmt.setInt(3, c.getSimbolo().getId());
		this.setCoresTipo(pStmt, c);
		pStmt.executeUpdate();
	}

	

	// Existir�o v�rias cores diferentes que ir�o possuir o mesmo s�mbolo
	@Override
	public Collection<Cor> findBySimbolo(String simbolo) throws Exception {
		Set<Cor> cores = new HashSet<Cor>();
		PreparedStatement pStmt = this.getConn().prepareStatement(COR_SELECT_ALL);
		pStmt.setString(1, simbolo);
		ResultSet rSet = pStmt.executeQuery();

		while (rSet.next()) {
			cores.add(setCor(rSet));
		}
		return cores;
	}

	private void setCoresTipo(PreparedStatement pStmt, Cor c) throws Exception {
		if (c instanceof CorRGB) {
			CorRGB cor = (CorRGB) c;
			pStmt.setInt(4, cor.getRed());
			pStmt.setInt(5, cor.getGreen());
			pStmt.setInt(6, cor.getBlue());
			pStmt.setInt(7, 0);
			pStmt.setInt(8, 0);
			pStmt.setInt(9, 0);
			pStmt.setInt(10, 0);
			pStmt.setInt(11, TipoCor.CorRGB.value());
		} else {
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

		SimboloDAOSQL sDAO = new SimboloDAOSQL();
		int simbolo = rSet.getInt("simbolo");
		Simbolo oSimbolo = sDAO.findById(simbolo);
		
		int tipoCor = rSet.getInt("tipo_cor");

		if (tipoCor == TipoCor.CorRGB.value()) {
			int red = rSet.getInt("red");
			int green = rSet.getInt("green");
			int blue = rSet.getInt("blue");

			return c = new CorRGB(id, sDescricao, oSimbolo, red, green, blue);

		} else if (tipoCor == TipoCor.CorCMYK.value()) {
			int cyan = rSet.getInt("cyan");
			int magente = rSet.getInt("magente");
			int yellow = rSet.getInt("yellow");
			int key = rSet.getInt("key");

			return c = new CorCMYK(id, sDescricao, oSimbolo, cyan, magente, yellow, key);
		}

		return c;
	}


}