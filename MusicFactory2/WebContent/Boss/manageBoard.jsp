<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 관리자의 게시글 관리를 위한 페이지
일반 게시글과 보는게 동일하지만 삭제 또는 경고 버튼이 있다. -->

				<table border="1" align="center" width="50%">		
					<tr>
						<td align="center" name="jang" value="제목">번호</td>
						<td>${requestScope.bnumber}</td>
						<input type = "hidden" name = "command" value="S_SellerBoardEdit">		
						<input type = "hidden" name = "bnumber" value="${requestScope.bnumber}">
					</tr>
					<tr>
						<td align="center" name="jang1" value="상품이름">이름</td>
						<td>${requestScope.btitle}</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">가격</td>
						<td>${requestScope.bprice}</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">저자</td>
						<td>${requestScope.bauthor}</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">장르</td>
						<td>${requestScope.bjanre}</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">등록날짜</td>
						<td>${requestScope.bdate}</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">평점</td>
						<td>${requestScope.bscore}</td>
					</tr>					
				</table>		
				
				<input type="button" value="경고"> <!-- 삭제 부분은 그대로 둘 것인지 아니면 관리자 전용 페이지로 만들 것인지 생각해보아야함 -->
				<input type= "button" value = "삭제" 
				onclick = "location.href= 'MFServlet?command=S_SellerBoardDelete&bnumber='+${requestScope.bnumber}">
		


</body>
</html>