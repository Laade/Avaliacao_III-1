package inf008.controll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

import inf008.model.Simbolo;

public class SimboloDAOSQL {
	private static final String URI = "jdbc:hsqldb:hsql://localhost/";
	private static final String USER = "SA";
	private static final String PWD = "dexter";

	private static final String SIMBOLO_SELECT_ALL = "SELECT * FROM SIMBOLO";
	
	public SimboloDAOSQL() throws SQLException {
//		DriverManager.registerDriver(new org.hsqldb.jdbc.JDBCDriver());
	}

	private Connection getConn() throws SQLException {
		return DriverManager.getConnection(SimboloDAOSQL.URI, SimboloDAOSQL.USER, SimboloDAOSQL.PWD);
	}


	public Collection<Simbolo> findAll() throws Exception {
		ArrayList<Simbolo> simbolos = new ArrayList<Simbolo>();
		PreparedStatement pStmt = this.getConn().prepareStatement(SIMBOLO_SELECT_ALL);
		ResultSet rSet = pStmt.executeQuery();

		while (rSet.next()) {
			simbolos.add(setSimbolo(rSet));
		}
		return simbolos;
	}
	
	private Simbolo setSimbolo(ResultSet rSet) throws Exception {
		int id = rSet.getInt("id");
		String descricao = rSet.getString("descricao");

		return  new Simbolo(id, descricao);
	}

}
