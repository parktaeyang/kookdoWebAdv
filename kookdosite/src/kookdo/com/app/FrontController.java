package kookdo.com.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FrontController
 */
@WebServlet(urlPatterns = { "*.do" }, initParams = {
		@WebInitParam(name = "config", value = "D:/eclipse/workspace/kookdosite/WebContent//WEB-INF/movePath.properties") })
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> cmdMap = new HashMap<String, Object>();

	/**
	 * 서블릿 실행시 한 번만 호출되는 메소드 init() init-param에 기술되어 있는 config에 해당하는
	 * value값(Command.properties의 절대경로)을 얻어오자.
	 */
	@Override
	public void init(ServletConfig conf) throws ServletException {
		System.out.println("init()호출됨...");
		String props = conf.getInitParameter("config");
		System.out.println("props : " + props);
		Properties pr = new Properties();
		// Hashtable의 자식테이블, 키값과 value값을 매핑하여 저장하는 자료구조
		// Command.properties 파일에 매핑된정보를 Properties 자료구조에 옮기자
		try {

			FileInputStream fis = new FileInputStream(props);
			pr.load(fis);
			// Command.properties파일 정보를 Properties객체에 저장한다.
			if (fis != null)
				fis.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(pr.getProperty("/index.do"));
		// key값들만 추출
		Enumeration<Object> en = pr.keys();
		while (en.hasMoreElements()) {
			String cmd = en.nextElement().toString(); // key값
			String className = pr.getProperty(cmd);
			System.out.println("cmd : " + cmd);
			System.out.println("className : " + className);

			if(className!=null){
				className = className.trim();
			}
			
			try {
				Class cmdClass = Class.forName(className);
				Object cmdInstance = cmdClass.newInstance();
				//해당클래스를 객체화시켜 메모리에 올린다.
				
				/////////////////////////////☆
				cmdMap.put(cmd, cmdInstance);
				//이 객체들을 해시맵에 저장
				/////////////////////////////☆
			} catch (Exception e) {
				e.printStackTrace();
				throw new ServletException(e);
			}

		} // while
	}//init

	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		requestProcess(req, res);
	}

	private void requestProcess(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("FrontController실행");
		//1.클라이언트의 요청uri을 분석
		String uri = req.getRequestURI();
		String myctx = req.getContextPath();
		int len = myctx.length();
		String cmd = uri.substring(len);
		System.out.println("cmd : "+cmd);
		
		Object instance = cmdMap.get(cmd);
		
		AbstractAction action = (AbstractAction)instance;
		if(action==null){
			System.out.println("FrontController : action is null!");
			return;
		}
		//서브 컨트롤러(action)의 execute()를 호출
		try {
			//////////
			action.execute(req, res);
			System.out.println("FrontController : 서브 컨트롤러(action)의 execute()를 호출");
			//////////
			//이동할 뷰페이지 얻기
			String viewPage = action.getViewPage();
			if(viewPage==null){
				System.out.println("FrontController : viewPage is null!");
				viewPage = "index.jsp";
				//null이면 default page를 index로 지정
			}
			
			if(action.isRedirect()){
				//redirect이동인 경우
				res.sendRedirect(viewPage);
			} else {
				//forward이동인 경우
				RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
				dispatcher.forward(req, res);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		requestProcess(req, res);
	}

}













