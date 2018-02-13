<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
<!-- 판매자 정보 표시 -->

	<table>
		<tr>
			<td>아이디</td> <td>${member.mid}</td>
		</tr>
		
		<tr>
			<td>이름</td> <td>${member.mname}</td>
		</tr>
		
		<tr>
			<td>사업자 번호</td> <td>${member.mopnum}</td>
		</tr>
				
		<tr>
			<td>연락가능번호</td> <td>${member.mphone}</td>
		</tr>
						
				
		<tr> 
			<td>현재 벌점</td> <td>${member.warning}</td>
		</tr>		
				
				
		<tr align="center"> 
			<td><input type="button" value="쪽지 보내기" onclick="어딘가로 보내버림ㅎㅎ"></td>
			<td><input type="button" value="경고 주기" onclick="경고를 줘버림ㅎㅎ"></td>
		</tr>
		
	</table>


<!-- 여기서 부터 해당 판매자가 올린 게시글 목록 -->

	<table border="1" align="center" style="width: 100%">
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
					<c:forEach var="product" items="${board}">
					<tr>
						<td>${product.bnumber}</td>
						<td>${product.bjanre}</td>
						<td>${product.btitle}</td>
						<td>${product.bauthor}</td>
						<td>${product.bprice}</td>
						<td>${product.mid}</td>						
						
						<td> <!-- 이부분도 삭제 가능하게??? -->
							<input type= "button" value ="상세보기" 
							onclick  = "location.href='MFServlet?command=S_SellerBoardDetail&bnumber=${product.bnumber}'">
						</td>
						
					</tr>
				</c:forEach>
			</table>





</body>
</html>