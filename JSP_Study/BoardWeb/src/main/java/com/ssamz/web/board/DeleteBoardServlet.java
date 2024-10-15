package com.ssamz.web.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssamz.biz.board.BoardDAO;
import com.ssamz.biz.board.BoardVO;

/**
 * Servlet implementation class DeleteBoardServlet
 */
@WebServlet("/deleteBoard.do")
public class DeleteBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		//System.out.println("---> DeleteBoardServlet -> doGet() 메소드 호출");
		
		// 0. 상태 정보 체크
		/*
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		
		if (userId == null) {
			response.sendRedirect("/");
		}
		*/
		
		// 0. 상태 정보 체크
		/*Cookie[] cookieList = request.getCookies(); 
		
		if (cookieList == null) {
			response.sendRedirect("/login.html");
		} else {
			
			String userId = null;
			
			for (Cookie cookie : cookieList) {
				if (cookie.getName().equals("userId")) {
					userId = cookie.getValue();
				}
			}
			
			if (userId == null) {
				response.sendRedirect("/login.html");
			}
		
		}
		*/
		
		// 1. 사용자 입력 정보 추출
		String seq = request.getParameter("seq");
		
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSeq(Integer.parseInt(seq));
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.deleteBoard(vo);
		
		// 3. 화면 이동
		//response.sendRedirect("getBoardList.do");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/getBoardList.do");	
		dispatcher.forward(request, response);
		
	}

}
