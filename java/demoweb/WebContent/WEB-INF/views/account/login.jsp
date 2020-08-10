<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="utf-8" />
	<title>로그인</title>
	<link rel="Stylesheet" href="/demoweb/styles/default.css" />
	<link rel="Stylesheet" href="/demoweb/styles/input.css" />	
</head>
<body>
	
	<div id="pageContainer">

		<jsp:include page="/WEB-INF/views/module/header.jsp" /> <%-- 다른 곳의 jsp 호출(함수 호출하는 것 처럼 불러다 씀) --%>
			
		<div id="inputcontent">
			<br /><br />
		    <div id="inputmain">
		        <div class="inputsubtitle">로그인정보</div>
		        
		        <form action="login.action" method="post"> <!-- 처리하는 servlet만들어야 한다. -->
		       
		        <table>
		            <tr>
		                <th>아이디(ID)</th>
		                <td>
		                    <input type="text" name="memberId" style="width:280px" />
		                </td>
		            </tr>
		            <tr>
		                <th>비밀번호</th>
		                <td>
		                	<input type="password" name="passwd" style="width:280px" />
		                </td>
		            </tr>
		        </table>
		        
		        <div class="buttons">
		        	<input type="submit" value="로그인" style="height:25px" />
		        	<input type="button" id="btn-cancel" value="취소" style="height:25px" />
		        </div>
		        </form>
		        
		    </div>
		</div>   	
	
	</div>
	<script type="text/javascript">
	//window.addEventListener('load', ...) : main 함수 역할(시작점)
	window.addEventListener('load', function(event) {
		var btnCancel = document.querySelector('#btn-cancel') //# (btn-cancel을 부름) id가 btn-cancel인것 
		btnCancel.addEventListener('click', function(event) { // 클릭하면 눌러주세요
			// location.href="/demoweb/home.action"; // location.href : 브라우저의 주소 입력창 내용
			
			
			// 절대 경로 사용할 경우
			// location.href="/demoweb/home.action"; // /애플리케이션이름/경로
		
			// 현재 경로 사용할 경우
			// login.jsp의 현재 경로는 /demoweb/account/login.action
			
			//상대 경로 사용할 경우
			location.href = "../home.action";
		});
	});
	</script>


</body>
</html>