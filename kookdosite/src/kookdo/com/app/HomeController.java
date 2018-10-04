package kookdo.com.app;

import kookdo.common.AbstractAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HomeController extends AbstractAction{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("HomeController execute");
		
		req.setAttribute("msg", "msg");
		
		this.setViewPage("/index.jsp");
		this.setRedirect(false);

	}
}
