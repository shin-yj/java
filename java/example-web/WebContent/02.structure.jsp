<%@ page import="java.util.Date" %>
<%@ page language="java" 
		 contentType="text/html; charset=utf-8"
    	 pageEncoding="utf-8" %>

<%!
	String getTimeString() {
		return new Date().toString();
	}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 서버 주석 (JSP 주석) : 서버에서 무시되는 영역 (처리하지 않는 영역) --%>
	<!-- HTML 주석 : 서버에서는 단순 문자열로 해석 (처리하는 영역), 
				       브라우저에서는 무시하는 영역 (처리하지 않는 영역) -->
				       
	<h2><% out.println( new Date().toString() ); %></h2>
	<h2><%= new Date().toString() %></h2>	
	<h2><%= getTimeString() %></h2>

</body>
</html>












