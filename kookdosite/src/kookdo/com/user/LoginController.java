//package kookdo.com.user;
//
//
//import javax.annotation.Resource;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.json.simple.JSONObject;
//
//import kookdo.conn.model.UserVO;
//import kookdo.conn.service.UserService;
//
//

//
//
//
//
//@Controller
//public class LoginController {
//	
//	//@Resource(name="kookdo.conn.service.BoardServiceImpl")
//		//@Autowired
//		@Resource(name="userService")
//		private UserService userService;
//
//		@RequestMapping(value = "loginPage", method = {RequestMethod.GET, RequestMethod.POST})
//		public String home(HttpServletRequest req, HttpServletResponse res) throws Exception {
//			
//			return execute(req, res);
//		}
//		
//		public String execute(HttpServletRequest req, HttpServletResponse res) throws Exception {
//			System.out.println("enter login page");
//
//			return "user/login";
//
//		}
//		
//		
//		@RequestMapping(value = "userLogin", method = RequestMethod.POST)
//		public void login(HttpServletRequest req, HttpServletResponse res) throws Exception {
//			UserVO user = new UserVO();
//			user.setUserId(req.getParameter("userId"));
//			user.setPassword(req.getParameter("password"));
//			checkLogin(user ,req, res);
//		}
//		
//		public void checkLogin(UserVO user, HttpServletRequest req, HttpServletResponse res) throws Exception {
//
//			
//			UserVO rslt = userService.login(user.getUserId());
//			
//			System.out.println(rslt.getUserId() + rslt.getPassword());
//			
//			JSONObject json = new JSONObject();
//			String retString =""; 	// �삤瑜� 硫붿떆吏�
//			String retType="";		// 濡쒓렇�씤 ���엯
////			json.put("retType", retType);
////			json.put("retString", retString);
//			
//			
//			
//			if (rslt == null ) {
//				retType  = "5001";
//				retString ="�빐�떦 怨꾩젙�씠 議댁옱�븯吏� �븡�뒿�땲�떎.";
//				json.put("retType", retType);
//				json.put("retString", retString);
//				
//			} else if  (rslt != null ) {
//				
//				// �븘�씠�뵒 �씪移� �뿬遺�
//				if( !rslt.getUserId().equalsIgnoreCase(user.getUserId())) {
//					retType  = "5002";
//					retString ="怨꾩젙(�븘�씠�뵒)�쓣(瑜�)  �떎�떆 �솗�씤�븯�꽭�슂";
//					json.put("retType", retType);
//					json.put("retString", retString);
//					// 鍮꾨�踰덊샇 �씪移� �뿬遺�
//				}  
//				else if ( !rslt.getPassword().equalsIgnoreCase(user.getPassword()) ) {
//					retType  = "5003";
//					retString ="鍮꾨�踰덊샇瑜� �떎�떆 �솗�씤�븯�꽭�슂";
//					json.put("retType", retType);
//					json.put("retString", retString);
//				} 
//				else {
//					// 沅뚰븳 蹂� 泥댄겕�썑 硫붾돱�씠�룞
//					retType  = "0000";		//�젙�긽
//					
//					//沅뚰븳蹂� 硫붾돱�꽕�젙
//					//retString =loginService.loginMenu(rslt);
//					retString = "home.do";
//					
//					// �꽭�뀡	
//					HttpSession session = req.getSession();
//					session.setAttribute("loginUser", rslt);
//		            
//		            //  濡쒓렇�씤濡쒓렇 ���옣
////		            rslt.setLoginIp(BaseUtil.getClientIP(request));
//		            //loginService.loginLog(rslt);
//					
//					json.put("retType", retType);
//					json.put("retString", retString);
//				}
//			}
//			res.setContentType("application/json; charset=utf-8");
//			res.getWriter().write(json.toString());
//		}
//		
//		/*			
//			List<UserVO> loginResult = userService.login();
//			
//			req.setAttribute("loginResult", loginResult);
//			//req.setAttribute("ab_totalCount", ab_totalCount);
//			//req.setAttribute("ab_pageCount", ab_pageCount);
//			//req.setAttribute("ab_cpage", ab_cpage);
//			*/
//		
//		@RequestMapping(value = "userLogout")
//		public String logout(HttpServletRequest req, HttpServletResponse res) throws Exception {
//			HttpSession session = req.getSession();
//			session.setAttribute("loginUser", null);
//			return "home";
//		}
//
//}
