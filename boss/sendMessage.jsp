<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" src="script/message.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action='MFServlet?command=SendMessage&mid='${requestScope.mid} name="frm">
	받는사람 : ${requestScope.mid}
	내용 : <textarea name="content">내용을 입력해주세요</textarea> <br>
	<input type="submit" value="보내기" onclick="closeMessageBox()">
	<input type="button" value="취소" onclick="closeMessageBox()">
	<input type="reset" value="다시쓰기">
</form>

</body>
</html>