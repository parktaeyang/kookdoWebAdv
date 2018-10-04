package kookdo.com.app;

import kookdo.common.AbstractAction;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AboutController extends AbstractAction{
	
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("AboutController execute");
		
		req.setAttribute("msg", "msg");
		
		this.setViewPage("/about.jsp");
		this.setRedirect(false);

	}
}
