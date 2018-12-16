package kookdo.com.user;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
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
@WebServlet("/idCheck.do")
public class IdCheckController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheckController() {
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
		String te ="jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
			
		String USER="root"; //로컬테스트 
		String PASS="password123!"; //로컬테스트
		//String USER="xodxod12345"; //개발테스트
		//String PASS="Ekdmsdl123!"; //개발테스트
		String errorTest = "";
		String loginUser = "";
		Boolean duplicated = false;
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		JSONObject json = new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			String userId = request.getParameter("userId");
			rs= stmt.executeQuery("select * from user_info where id = '" + userId + "'");
			while(rs.next()){
				loginUser = rs.getString("id");
				if(loginUser.equals(userId)) {
					System.out.println("아이디 중복");
					duplicated = true;
				} else {
					System.out.println("로그인 실패");
					duplicated = false;
				}
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
		if(duplicated) {
//			HttpSession session = request.getSession();
//			session.setAttribute("loginUser", loginUser);
			String code = "104";
			String message = "아이디가 중복 되었습니다.";
			
			json.put("code", code);
			json.put("message", message);
			
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
			
			
			//RequestDispatcher dispatcher = request.getRequestDispatcher("views/user/login.jsp");
			//dispatcher.forward(request, response);
		} else {
			//HttpSession session = request.getSession();
//			session.setAttribute("loginUser", loginUser);
			String code = "200";
			String message = "success";
			
			json.put("code", code);
			json.put("message", message);
			
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
		}
	}

}
