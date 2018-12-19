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
@WebServlet("/Login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
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
			
		//String USER="root"; //로컬테스트 
		//String PASS="pass123"; //로컬테스트
		String USER="xodxod12345"; //개발테스트
		String PASS="Ekdmsdl123!"; //개발테스트
		String errorTest = "";
		String loginId = "";
		String loginPassword = "";
		String loginResult = "";
		String regState = "";
		String code = "";
		String message = "";
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		JSONObject json = new JSONObject();
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			rs= stmt.executeQuery("select * from user_info where id = '" + userId + "'");
			while(rs.next()){
				loginId = rs.getString("id");
				if(loginId.equals(userId)) { // 비번빼고 아이디 검사하고 비번 체크해
					loginPassword = rs.getString("password");
					if(password.equals(loginPassword)) {
						regState = rs.getString("state");
						if(regState.equals("accept")) {
							loginResult = "accept";
							System.out.println("로그인 성공");
							System.out.println("아이디 : " + loginId);
						} else {
							System.out.println("관리자 승인 후");
							loginResult = "fail";
						}
					} else {
						loginResult = "notMatched";
					}
				} else {
					System.out.println("계정 없음");
					loginResult = "notFound";
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
		
		switch (loginResult) {
		case "accept":
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginId);
			code = "200";
			message = "success";
			json.put("code", code);
			json.put("message", message);
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
			break;
		case "fail":
			code = "106";
			message = "관리자 승인 후 로그인 가능합니다.";
			json.put("code", code);
			json.put("message", message);
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
			break;
		case "notFound": //계정없음
			code = "400";
			message = "로그인에 실패 했습니다.";
			json.put("code", code);
			json.put("message", message);
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
			break;
		case "notMatched": //비번 틀림
			code = "400";
			message = "로그인에 실패 했습니다.";
			json.put("code", code);
			json.put("message", message);
 			response.setContentType("application/json; charset=utf-8");
			response.getWriter().write(json.toString());
			break;
		}
	}

}
