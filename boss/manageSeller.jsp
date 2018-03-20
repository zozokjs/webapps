<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	
<%@ page import = "com.mf.dto.MemberVO"  %>


<!DOCTYPE html>
<html>
<head>
<%
	System.out.println("--확인용-- manageSeller.jsp 진입");


%>
<script type="text/javascript">
	function openMessageBox(){
		var url = "MFServlet?command=SendMessage&mid="+${requestScope.member.mid};
		window.open(url, "_blank_1", "toolbar=no, menubar=no, scrollbars=yes, resizable=no",
		width="450", height="200");
				
	}
</script>

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<!-- 판매자 정보 표시 -->

	<table border = "1">
		<tr>
			<td>아이디</td> 
			<td>${requestScope.member.mid}</td>		
		</tr>
		
		<tr>
			<td>이름</td> <td>${member.mname}</td>
		</tr>
		
		<tr>
			<td>사업자 번호</td>
			
			<c:choose>			
				<c:when test ="${member.mopnum == 0}">
					<td>승인 대기 중</td>			
				</c:when>
						
				<c:when test ="${member.mopnum != 0}">
					<td>${member.mopnum}</td>			
				</c:when>
			</c:choose>	
		</tr>
				
		<tr>
			<td>연락가능번호</td> <td>${member.mphone}</td>
		</tr>
						
				
		<tr> 
			<td>받은 경고 횟수</td> <td>${member.mwarning}</td>
		</tr>		
								
		<tr align="center"> 	
			<td> 
				<input type="button" value="판매 승인/사업자번호 발급" onclick="location.href='MFServlet?command=ChangeOpnum&mid=${requestScope.member.mid}'">
			</td>
			<td> 
				<input type="button" value="판매 중지/사업자번호 삭제" onclick="location.href='MFServlet?command=ChangeOpnumZero&mid=${requestScope.member.mid}'">
			</td>
						
		</tr>
		
		<tr align="center"> 		
			<td><input type="button" value="쪽지 보내기" onclick="openMessageBox"></td>
			<td><input type="button" value="경고 주기" onclick=""></td>
		</tr>
		
		
	</table>


<!-- 여기서 부터 해당 판매자가 올린 게시글 목록 -->
	
	
		
	<table border="1" align="center" style="width: 100%">
	<caption>해당 판매자는 아래와 같은 판매 글을 올렸습니다.</caption>
				<tr>
					<td>등록 번호</td>
					<td>장르</td>
					<td>물품이름</td>
					<td>가수</td>
					<td>가격</td>
					<td>판매자</td>
					<td>상세보기</td>
				</tr>
		
					<!-- 목록을 나타내는 for문입니다.  -->
					<c:forEach var="mproduct" items="${product}">
					<tr>
						<td>${mproduct.pnumber}</td>
						<td>${mproduct.pjanre}</td>
						<td>${mproduct.pname}</td>
						<td>${mproduct.pauthor}</td>
						<td>${mproduct.pprice}</td>
						<td>${mproduct.mid}</td>						
						
						<td> <!-- 이부분도 삭제 가능하게??? -->
							<input type= "button" value ="상세보기" 
							onclick  = "location.href='MFServlet?command=S_SellerProductDetail&pnumber=${mproduct.pnumber}'">
						</td>
						
					</tr>
				</c:forEach>
			</table>





</body>
</html>