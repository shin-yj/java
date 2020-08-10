package com.demoweb.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns= {"/account/register.action"}) // 사이트 그대로
public class RegisterServlet extends HttpServlet { // sevlet과 연결 // get방식 // home.action에 요청이 들어오면 homesevlet으로 요청 들어온당
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			// 요청 처리(여기서는 특별히 할 것이 없음)
		
			// JSP로 forward 이동해서 응답 컨텐츠 생산 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/account/register.jsp"); // 요청을 전달하는 것 찾기
		dispatcher.forward(req, resp);
		

	}

}

