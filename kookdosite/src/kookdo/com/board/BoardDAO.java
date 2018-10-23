package kookdo.com.board;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import kookdo.conn.model.board.*;

public class BoardDAO {
	String URL="jdbc:mysql://localhost:3306/xodxod12345?serverTimezone=UTC";
	String USER="root"; //로컬테스트 
	String PASS="pass123"; //로컬테스트
	//String USER="xodxod12345"; //개발테스트
	//String PASS="Ekdmsdl123!"; //개발테스트
	
	private Connection conn =null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public void dbConnect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (ps != null)
				ps.close();
			if (conn != null)
				conn.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public int insertTripReport(ReportTrip reporttrip) {
		try {
			dbConnect();
			String sql = "insert into board_tripreport values(?, ? ,? "
					+ ", '1', '1', '1', '1', '1', '1', '1', '1', '1'"
					+ ", '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'"
					+ ", '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'"
					+ ", '1', '1', '1', '1', '1', '1', '1', '1', '1', '1'"
					+ ", '1', '1', '1', '1', '1', '1', '1', '1', '1', '1')";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, reporttrip.getBoard_seq());
			ps.setString(2, reporttrip.getTrip_schedule());
			ps.setString(3, reporttrip.getTrip_member());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return 0;
	}
}
