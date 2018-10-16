package kookdo.com.board.tripreport;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TripReportWriteController
 */
@WebServlet("/tripreportwrite.do")
public class TripReportWriteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String URL="jdbc:mysql://localhost:3306/xodxod12345?serverTimezone=UTC";
		//String USER="root"; //로컬테스트 
		//String PASS="pass123"; //로컬테스트
		String USER="xodxod12345"; //개발테스트
		String PASS="Ekdmsdl123!"; //개발테스트
		
		String errorTest = "";
		String note = "";
		String remark = "";
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			rs= stmt.executeQuery("select * from kdboardtest");

			
			while(rs.next()){

				note = rs.getString("note");
				remark = rs.getString("remark");

				System.out.println("내용 : " + note + "비고" + remark);		

			}
			errorTest = "no error";

		} catch(SQLException | ClassNotFoundException e){
			errorTest = "occur error";
			request.setAttribute("errorTest", errorTest);
			e.printStackTrace();
		} finally{
			if(rs != null) try{rs.close();} catch(SQLException ex){}
			if(stmt != null) try{stmt.close();} catch(SQLException ex){}
			if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
		
		request.setAttribute("note", note);
		request.setAttribute("remark", remark);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("views/board/businesstripreport_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
