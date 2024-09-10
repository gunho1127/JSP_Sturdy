package com.ssamz.web.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssamz.biz.user.UserDAO;
import com.ssamz.biz.user.UserVO;



/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.do")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    //public LoginServlet(/*String servletName*/) {
        //super();
        // TODO Auto-generated constructor stub
    	//System.out.println("===> LoginServlet 생성");
    	//System.out.println("===> " + servletName + "  생성");
   // }
    
	//@Override
	//public void init() throws ServletException {
		// TODO Auto-generated method stub
		//super.init();
		//System.out.println("---> init() 호출");
	//}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		
		/*
		System.out.println("--------------------Start Line--------------------");
		String method = request.getMethod();
		String url = request.getRequestURI();
		String protocol = request.getProtocol();
		System.out.println(method + " " + url + " " + protocol);
		
		System.out.println("------------------Message Header------------------");
		System.out.println("Host : " + request.getHeader("host"));
		System.out.println("Connection : " + request.getHeader("connection"));
		System.out.println("User-Agent : " + request.getHeader("user-agent"));
		System.out.println("Accept : " + request.getHeader("accept"));
		System.out.println("Accept-Encoding : " + request.getHeader("accept-encoding"));
		System.out.println("Accept-Language : " + request.getHeader("accept-language"));
		*/
		
		//super.service(req, resp);
		//System.out.println("---> service() 호출");
		
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("===>  GET 방식의 요청 처리");
	//}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		//System.out.println(9/0);
		//System.out.println("===>  POST 방식의 요청 처리");
	//}

	//@Override
	//public void destroy() {
		// TODO Auto-generated method stub
		//super.destroy();
		//System.out.println("---> destroy() 호출");
		
	//}

}
