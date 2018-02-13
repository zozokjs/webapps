<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 
	게시글 관리 / 판매자 관리 / 통계 확인 페이지 3개가 필요함.
	
	게시글 관리 : 상품 정보 페이지랑 똑같은데 삭제/경고 보낼 수 있는 권한이 더 추가되는 것.
	
	판매자 관리 : 목록들 
	판매자 이름 / 쪽지보내기 / 경고횟수 출력하기 / 경고주기 / 정지먹이기 / 사업자번호 확인 / 판매자 승인 
	
	통계 확인 : (구글API 쓸거임)
	오픈마켓 통계
	등록된 게시글 수
	판매자 수
	구매자 수
-->



	<table>
		<tr>
			<th>판매자 아이디</th> <th>판매자 이름</th> <th>사업자 번호</th> <th>쪽지 보내기</th> <th>상세보기</th> <th>승인여부</th>
		</tr>
		
		<tr>
		
		<c:forEach var = "member" items = "${requestScope.member}" begin="1" end="20">
				<tr>
					<td><input type = "text" value = "${member.mid}" name = "id"></td>
					<td><input type = "text" value = "${member.mname}" name = "name"></td>
					<td><input type = "text" value = "${member.mopnum}" name = "opnum"></td>
								
					
					<td><input type = "button" value = "쪽지 보내기" name = "sendMessage" 
						onclick = "location.href = 'controller?command=SendMessage&mid=${member.mid}'" ></td>
					<td><input type= "button" value = "상세보기" name = "detail" 
					onclick = "location.href ='controller?command=ManageSeller&mid=${member.mid}'"></td>
					<td>승인/비승인 표시 보이도록 자바스크립트, 또는  %</td>
					
								
				</tr>
	 		</c:forEach>		
	
	
	</table>







</body>
</html>