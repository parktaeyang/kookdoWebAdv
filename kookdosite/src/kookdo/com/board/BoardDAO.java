package kookdo.com.board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import kookdo.conn.model.ReportTripVO;

public class BoardDAO {
	String URL="jdbc:mysql://localhost:3306/xodxod12345?serverTimezone=UTC";
	//String USER="root"; //로컬테스트 
	//String PASS="pass123"; //로컬테스트
	String USER="xodxod12345"; //개발테스트
	String PASS="Ekdmsdl123!"; //개발테스트
	
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
	
	public int getTotalCount() {
		try {
			dbConnect();
			String sql = "select count(1) cnt from board_tripreport";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			rs.next();
			int totalCount = rs.getInt("cnt");
			return totalCount;
		} catch (Exception e) {
			e.printStackTrace();
			return -1;
		} finally {
			close();
		}
	}
	
	public int insertTripReport(ReportTripVO reporttrip) {
		try {
			dbConnect();
			
			int boardSeq = 0;
			String sqlCountSeq = "select count(1)+1 as board_seq from board_tripreport";
			ps = conn.prepareStatement(sqlCountSeq);
			rs = ps.executeQuery();
			rs.next();
			boardSeq = rs.getInt("board_seq");
			
			String sql = "insert into board_tripreport values(?, ? ,? "
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?"
					+ ", ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, boardSeq); 
			ps.setString(2, reporttrip.getTrip_schedule()); 
			ps.setString(3, reporttrip.getTrip_member());
			
			ps.setString(4, reporttrip.getTrip_write_date()); 	ps.setString(5, reporttrip.getTrip_customer());	 	ps.setString(6, reporttrip.getTrip_addr()); 
			ps.setString(7, reporttrip.getTrip_phone()); 		ps.setString(8, reporttrip.getTrip_tel()); 			ps.setString(9, reporttrip.getTrip_fax());
			ps.setString(10, reporttrip.getTrip_consum_time()); ps.setString(11, reporttrip.getTrip_distance()); 	ps.setString(12, reporttrip.getTrip_etc());
			
			ps.setString(13, reporttrip.getTrip_meal_fee()); 
			ps.setString(14, reporttrip.getTrip_oil_fee()); 	ps.setString(15, reporttrip.getTrip_total_price()); ps.setString(16, reporttrip.getTrip_part_fee());
			ps.setString(17, reporttrip.getTrip_toll_fee()); 	ps.setString(18, reporttrip.getTrip_remark()); 		ps.setString(19, reporttrip.getTrip_goods());
			ps.setString(20, reporttrip.getTrip_standard()); 	ps.setString(21, reporttrip.getTrip_division()); 	ps.setString(22, reporttrip.getTrip_manufacturer());
			
			ps.setString(23, reporttrip.getTrip_controller()); 
			ps.setString(24, reporttrip.getTrip_serial_num()); 				ps.setString(25, reporttrip.getTrip_machine_cause()); 		ps.setString(26, reporttrip.getTrip_machine_action());
			ps.setString(27, reporttrip.getTrip_hydraulics_cause()); 		ps.setString(28, reporttrip.getTrip_hydraulics_action()); 	ps.setString(29, reporttrip.getTrip_electric_field_cause());
			ps.setString(30, reporttrip.getTrip_electric_field_action()); 	ps.setString(31, reporttrip.getTrip_mold_cause()); 			ps.setString(32, reporttrip.getTrip_mold_action());
			
			ps.setString(33, reporttrip.getTrip_etc_cause()); 
			ps.setString(34, reporttrip.getTrip_etc_action()); 	ps.setString(35, reporttrip.getTrip_x_servo()); 	ps.setString(36, reporttrip.getTrip_x_ballscrew());
			ps.setString(37, reporttrip.getTrip_x_bolleoteu()); ps.setString(38, reporttrip.getTrip_x_belt()); 		ps.setString(39, reporttrip.getTrip_x_lm());
			ps.setString(40, reporttrip.getTrip_r_servo()); 	ps.setString(41, reporttrip.getTrip_r_ballscrew()); ps.setString(42, reporttrip.getTrip_r_bolleoteu());
			
			ps.setString(43, reporttrip.getTrip_r_belt()); 
			ps.setString(44, reporttrip.getTrip_r_lm()); 			ps.setString(45, reporttrip.getTrip_mortor()); 			ps.setString(46, reporttrip.getTrip_pump());
			ps.setString(47, reporttrip.getTrip_chc_ler()); 		ps.setString(48, reporttrip.getTrip_scale());	 		ps.setString(49, reporttrip.getTrip_action_detail());
			ps.setString(50, reporttrip.getTrip_add_schedule()); 	ps.setString(51, reporttrip.getTrip_fee_quotation()); 	ps.setString(52, reporttrip.getTrip_free_reason());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close();
		}
		
		return 0;
	}
	
	public ArrayList<ReportTripVO> selectAllBoardTripreport(int start,  int end) {
		try {
			dbConnect();
//			String sql = "select * from ("
//					+ " select rownum rn, a.* from ("
//					+ " (select * from board_tripreport order by board_seq desc) a"
//					+ " )"
//					+ " )"
//					+ " where rn between "+start+" and "+end;
			String sql = "select @RNUM := @RNUM + 1 AS rowno, a.* from board_tripreport a, ( SELECT @RNUM := 0 ) b" + 
					" limit "+(start-1)+","+(end);
			
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			return makeList(rs);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			close();
		}
	}
	
	private ArrayList<ReportTripVO> makeList(ResultSet rs) throws SQLException {
		ArrayList<ReportTripVO> arr = new ArrayList<ReportTripVO>();
		
		ReportTripVO record;
		
		while (rs.next()) {
			record = new ReportTripVO();
			
			record.setBoard_seq(rs.getInt("board_seq"));
			record.setTrip_schedule(rs.getString("trip_schedule"));
			
			arr.add(record);
		}
		return arr;
	}
	
}
