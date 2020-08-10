package com.exampleweb.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = { "/model2" }) // 요청이 오면 model2 써라
// Httpservlet을 상속하는 것은 : Servlet Class가 구현해야 할 인터페이스를 자동으로 구현하는 것

public class Model2Servlet extends HttpServlet {
	
	// Get방식의 요청이 발생했을 때 호출되는 약속된 메서드
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 요청 처리
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd a hh:mm:ss"); // 날짜를 지정된 형식의 문자열로 변환하는 도구
		String dateString = sdf.format(new Date());
		
		Date d = new Date(); // 현재시간
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d); // 끝나는 시간용
		c2.set(Calendar.HOUR_OF_DAY, 18);
		c2.set(Calendar.MINUTE, 35);
		c2.set(Calendar.SECOND, 00); // jsp에 date만 넣어주면 된다.
		
		//초단위 시간 차
		Date d2 = c2.getTime();
		long diff = (d2.getTime() - d.getTime()) / 1000;// 끝나는 시간 차이(초단위)
		
		
		
		// jsp에서 사용할 수 있도록 데이터 전달 : request 객체에 데이터 저장
		req.setAttribute("date", dateString); // model2에 getattribute로 받는다
		req.setAttribute("diff", diff);
		
		// jsp로 forward 방식 이동
		// pageContext.forward("05.model2.jsp"); // 서블릿에는 pageContext가 없음
		RequestDispatcher rd = req.getRequestDispatcher("05.model2.jsp"); // 요청을 지정된 다른 곳으로 전달하는 도구
		rd.forward(req, resp); // model2로 data 주기
	}
	

}
