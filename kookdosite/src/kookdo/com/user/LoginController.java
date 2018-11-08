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
		String URL="jdbc:mysql://localhost:3306/xodxod12345?serverTimezone=UTC";
		String te ="jdbc:mysql://localhost:3306/Peoples?autoReconnect=true&useSSL=false";
			
		String USER="root"; //로컬테스트 
		String PASS="password123!"; //로컬테스트
		//String USER="xodxod12345"; //개발테스트
		//String PASS="Ekdmsdl123!"; //개발테스트
		
		String errorTest = "";
		String loginUser = "";
		Boolean loginResult = false;
		Connection conn =null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(URL,USER,PASS);
			stmt = conn.createStatement();
			String userId = request.getParameter("userId");
			String password = request.getParameter("password");
			rs= stmt.executeQuery("select * from user_info where id = '" + userId + "' and password = '" + password + "'");
			
			while(rs.next()){

				loginUser = rs.getString("id");
				if(loginUser.equals(userId)) {
					System.out.println("로그인 성공");
					System.out.println("아이디 : " + loginUser);
					loginResult = true;
				} else {
					System.out.println("로그인 실패");
					loginResult = false;
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
		if(loginResult) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", loginUser);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/about.jsp");
			dispatcher.forward(request, response);
		} else {
			//noting
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
