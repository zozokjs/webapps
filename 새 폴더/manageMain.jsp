<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>판매자 목록 관리</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    
      //도넛
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['판매/구매회원 비율', '(명)'],
          ['판매자',     11],
          ['구매자',      2],
        ]);

        var options = {
          title: '판매/구매회원 비율',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
      
      //도넛2
      google.charts.setOnLoadCallback(drawChart2);
      function drawChart2() {
          var data = google.visualization.arrayToDataTable([
            ['등록된 장르 비율', '(개)'],
            ['발라드',  3 ],
            ['댄스',   4 ],
            ['락',     5 ],
            ['힙합',    6 ],
          ]);

          var options = {
            title: '등록된 장르 비율',
            pieHole: 0.4,
          };

          var chart = new google.visualization.PieChart(document.getElementById('donutchart2'));
          chart.draw(data, options);
        }
      
      
      
      var data = google.visualization.arrayToDataTable([
          ['Element', 'Density', { role: 'style' }],
          ['Copper', 8.94, '#b87333'],            // RGB value
          ['Silver', 10.49, 'silver'],            // English color name
          ['Gold', 19.30, 'gold'],

        ['Platinum', 21.45, 'color: #e5e4e2' ], // CSS-style declaration
       ]);
      
      
    
      
      
      
    </script>
</head>
<body>
<%
	System.out.println("--확인용-- manageMain.jsp 진입");


%>
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


	
	<table border = "1">
	<caption>판매자가 '승인 대기 중'인 경우 상세보기를 통해 판매 승인을 해줘야만 판매를 시작하게 할 수 있습니다</caption>
		<tr>
			<th>판매자 아이디</th> <th>판매자 이름</th> <th>사업자 번호</th> <th>쪽지 보내기</th> <th>상세보기</th>
		</tr>
			
		<c:forEach var = "seller" items = "${member}">
		<tr>		
				<td><input type = "text" value = "${seller.mid}" name = "mid"></td>
				<td><input type = "text" value = "${seller.mname}" name = "mname"></td>
				
					<c:choose>			
						<c:when test ="${seller.mopnum == 0}">
							<td>승인 대기 중</td>			
						</c:when>
							
						<c:when test ="${seller.mopnum != 0}">
							<td>${seller.mopnum}</td>			
						</c:when>
					</c:choose>	
										
					
				 <td>
					<input type = "button" value = "쪽지 보내기" name = "sendMessage" 
						onclick = "location.href = 'MFServlet?command=SendMessage&mid=${seller.mid}'" >
				 </td>
				<td>
					 <input type= "button" value = "상세보기" name = "detail" 
					onclick = "location.href ='MFServlet?command=ManageSeller&mid=${seller.mid}'">
				</td>						
		</tr>		
	 	</c:forEach>		
		
	
	</table>
	
	
	
	<table>
		<tr>
			<td>
				<div id="donutchart" style="width: 600px; height: 300px;"></div>
			</td>
			<td>
				 <div id="donutchart2" style="width: 600px; height: 300px;"></div>
			</td>
		</tr>
	
	
		 
	
	</table>

	
	







</body>
</html>