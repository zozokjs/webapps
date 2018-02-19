<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 	    
<!DOCTYPE html>
<html>
<head>

<!-- 통계로 만들거 머 만들까
1. 판매자 수/구매자 수와 비율(count member/grade)
select count(*) over() as seller from member where grade=2;
select count(*) over() as buyer from member where grade=3; 
멤버에서 숫자만 받아오면 됨. 
vo만들 필요 없이dao에서 그냥 숫자 리턴. 
2. 등록된 상품 수.
select count(*) over() as bcount from board;
보드에서 숫자만. vo만들 필요 없이dao에서 그냥 숫자 리턴. 22
3. 이때까지 들어온 주문건 수
select count(*) over() as bcount from product;
오더링에서 숫자만. vo만들 필요 없이dao에서 그냥 숫자 리턴. 33
4. 게시글 수 판매자 순위. 10명정도까지..?
select * from board order by ;; <<-- 여기 파티션 하면 댈거같음.
select 판매자 이름, rank() over(partition by 판매자 이름..?
아 어떻게하더라 이건 패스함
그러니까 가장 많은 판매글을 올린 판매자 순서대로 몇명 추리고 싶은데
쿼리문을 어떻게하드라 카운트도 해야하고 파티션도 나눠야할거같은디

chartDAO 에 임시로 놔둠.


 -->
 <%
 	int seller = request.get~ "sellc" 
 	int buyer = request.get~ "buyc"
 	
 	int pc = request.get~ "pcount"
 	
 	int oc = request.get~ "ocount"
 
 
 
 %>
 
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
      google.charts.load("current", {packages:["corechart"]});
      google.charts.setOnLoadCallback(drawChart);
      function drawChart1() {
        var data = google.visualization.arrayToDataTable([
          ['Task', 'Hours per Day'],
          ['판매자',     <%=seller %>],
          ['구매자',      <%=buyer %>],

        ]);

        var options = {
          title: '판매자/구매자 비율',
          pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
      }
      

      
    </script>
    
    
    
    
    

<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	  <div id="donutchart" style="width: 900px; height: 500px;"></div>
	  
	  이때까지 등록된 상품 수 : <%=pc %>
	  이때까지 들어온 주문 수 : <%=oc %>
	  
	  게시글 많은 판매자 순위
	
</body>
</html>