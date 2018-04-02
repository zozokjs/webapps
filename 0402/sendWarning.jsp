<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	
<!DOCTYPE html>
<html>
<head>
<script>	

	function closeMessageBox(){
		self.close();
	}
	
</script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='MFServlet?command=SendWarning&mid='${requestScope.mid} method="get" name="frm">
	경고를 받을 판매자 : ${requestScope.mid} <br>

	경고 메세지를 입력해주세요.<br>
	<input type="text" name="content" width="30">
	<br> 
	<br>
	<input type="submit" value="보내기" onclick="closeMessageBox()">
	<input type="button" value="닫기" onclick="closeMessageBox()">
	<input type="hidden" value="mid" value= "${requestScope.mid}" />
	
	
</form>

</body>
</html>