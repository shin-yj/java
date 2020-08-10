package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/account/login.action"}) // 사이트 그대로
public class LoginServlet extends HttpServlet { // sevlet과 연결 // get방식 // home.action에 요청이 들어오면 homesevlet으로 요청 들어온당
	
	@Override //
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 요청 처리(여기서는 특별히 할 것이 없음)
		
			// JSP로 forward 이동해서 응답 컨텐츠 생산 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/login.jsp"); // 요청을 전달하는 것 찾기
		dispatcher.forward(req, resp);
		
	}
	
	@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		// 1. 요청 데이터 읽기
			req.setCharacterEncoding("utf-8");
			String memberId = req.getParameter("memberId");
			String passwd = req.getParameter("passwd");
			
		// 2. 요청 처리(로그인 처리 - 세션에 데이터 저장)
			
			boolean login = false; // == else login = false;
			if (memberId.equals("iamuserone") && passwd.equals("hoseo")) {
				
				// JSP에서는 Session이 내장 객체이지만 서블릿에서는 직접 가져와야 합니다.
				
				HttpSession session = req.getSession();
				session.setAttribute("loginuser", memberId); // 로그인처리
				login = true;
				
			}
		// 3. 응답컨텐츠 생산 (JSP로 이동)
			if (login) { // 로그인 성공한 경우 
				// -> home 화면으로 이동
				resp.sendRedirect("/demoweb/home.action");
				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/views/home.jsp");
			//  rd.forward(req, resp); // 이건 맞지 않음, jsp로 가면 forward. 그리고 관련된 화면이어야 forward, 관련된 화면 아니므로 redirect
				// 위의 구문은 주소와 화면상의 불일치 일어남
				
			} else { // 로그인 실패한 경우
				// 다시 로그인 화면으로 이동
				resp.sendRedirect("/demoweb/account/login.action");
//				RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/account/login.jsp"); // 같은 화면 나오므로 틀림(특히 구매시 혼동)
//				rd.forward(req, resp);
			}
			
			
			System.out.println(memberId + " / " + passwd);
	}

}
