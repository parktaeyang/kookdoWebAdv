package kookdo.com.user;

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
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;

/**
 * Servlet implementation class AboutController
 */
@WebServlet("/join.do")
public class JoinController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	/**
	 * @see HttpServlet#doProcess(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String URL="jdbc:mysql://localhost:3306/xodxod12345?autoReconnect=true&serverTimezone=UTC&userSSL=true";
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
			
		String USER="root"; //로컬테스트 
		String PASS="password123!"; //로컬테스트
		//String USER="xodxod12345"; //개발테스트
		//String PASS="Ekdmsdl123!"; //개발테스트
		String errorTest = "";
		Connection conn =null;
		Statement stmt = null;
		JSONObject json = new JSONObject();
		int rs = 0;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			String type = request.getParameter("type");
			String company = request.getParameter("company");
			String address = request.getParameter("address");
			String email = request.getParameter("email");
			String mobile = request.getParameter("mobile");
			String tel = request.getParameter("tel");
			System.out.println("INSERT INTO user_info values( '" + userId + "','" + password + "','" + email + "','" + address + "','" +
									mobile + "','" + type + "','" + company + "','" + tel + "', 'wait');" );
			rs= stmt.executeUpdate("INSERT INTO user_info values( '" + userId + "','" + password + "','" + email + "','" + address + "','" +
									mobile + "','" + type + "','" + company + "','" + tel + "', 'wait');" );
			errorTest = "no error";

		} catch(SQLException | ClassNotFoundException e){
			errorTest = "occur error";
			request.setAttribute("errorTest", errorTest);
			e.printStackTrace();
		} finally{
//				if(rs != 1) try{error = "tets";} catch(SQLException ex){}
				if(stmt != null) try{stmt.close();} catch(SQLException ex){}
				if(conn != null) try{conn.close();} catch(SQLException ex){}
		}
		if(rs == 1) {
			String code = "200";
			String message = "저장 되었습니다. 관리자 승인 후 로그인 가능합니다.";
			
			json.put("code", code);
			json.put("message", message);
			
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
		} else {
			String code = "500";
			String message = "서버 오류 입니다.";
			
			json.put("code", code);
			json.put("message", message);
			
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
		}
	}

}
