package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns= {"/account/logout.action"})
public class LogoutServlet extends HttpServlet { // servlet과 연결 // get방식 // home.action에 요청이 들어오면 homesevlet으로 요청 들어온당
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 요청 처리(로그아웃 처리 -> 세션에서 데이터를 제거)
		HttpSession session = req.getSession();
		session.removeAttribute("loginuser");
		
			// JSP로 이동해서 응답 컨텐츠 생산 
		resp.sendRedirect("/demoweb/home.action");// redirect는 서버에 요청하지 않고 브라우저한테 주는거므로 애플리케이션 이름 써야 한다.

	}

}


