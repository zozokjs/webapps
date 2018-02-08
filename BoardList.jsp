<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="mainPage.css">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">


		<!-- header -->

		<header>
			<div class="top">
				<ul>
					<li><a href="로그인 페이지">로그인</a></li>
					<li><a href="회원가입 페이지 ">회원가입</a></li>
				</ul>
				<a href="main.jsp"> <img src="mainTitle.png"
					style="height: 70px;"></a>
				<form action="main.jsp">
					<input type="text" name="find" value="원하는것을 검색하시오" size=100px;>
					<input type="submit" name="serch" value="검색">
				</form>
			</div>
		</header>



		<!-- nav(카테고리) -->
		<nav>
			<div class="category">
				<ul>
					<li><a href="로그인 페이지">국내음반</a></li>
					<li><a href="회원가입 페이지 ">회원가입</a></li>
					<li><a href="클래식 페이지">클래식</a></li>
					<li><a href="DVD-BLU-RAY 페이지 ">회원가입</a></li>
					<li><a href="우리만의차트 페이지">우리만의차트</a></li>
					<li><a href="공지사항 페이지 ">공지사항</a></li>
				</ul>
			</div>
		</nav>


		<!-- 선택한 장르표시 -->
		<div class="choice">
			<table>
				<tr>
					<td align="center">선택한장르</td>
				</tr>
			</table>
		</div>


		<!--session -->
		<section>

			<table border="1" align="center" style="width: 100%">
				<tr>
					<td>장르</td>
					<td>물품이름</td>
					<td>가수</td>
					<td>가격</td>
					<td>판매자</td>
					<td>상세보기</td>
				</tr>
				<!-- 목록을 나타내는 for문입니다.  -->>
				<c:forEach var="main" items="${oh}">
					<tr>
						<td>가요</td>
						<td>좋은날</td>
						<td>아이유</td>
						<td><a href="${main.pk}">50000</a></td>
						<td><a href="${main.pk}">오정섭</a></td>
						<td><a href="${main.pk}">상세보기</a></td>
					</tr>

					<tr>
						<td>가요</td>
						<td>바람인가요</td>
						<td>브라운아이드소울</td>
						<td><a href="${main.pk}">909999</a></td>
						<td><a href="${main.pk}">김준성</a></td>
						<td><a href="${main.pk}">상세보기</a></td>
					</tr>

					<tr>
						<td>팝</td>
						<td>endless love</td>
						<td>머라이어캐리</td>
						<td><a href="${main.pk}">1000000</a></td>
						<td><a href="${main.pk}">김영하</a></td>
						<td><a href="${main.pk}">상세보기</a></td>
					</tr>
				</c:forEach>
			</table>


		</section>



		<!-- article -->

		<article></article>


		<!-- footer -->
		<footer>
			<div class="final">
				<table border="0"; align="center"; width="50%">
					<tr>
						<b><td>주소 shopmaster@synnara.com Copyrightⓒ2012 Media
								SYNNARA Co.,Ltd. All Right Reserved.Norton SECURED : 노턴 시큐어드
								씰클릭하시면 이니시스 결제시스템의 유효성을 확인하실 수 있습니다. 클릭하시면 이니시스 결제시스템의 유효성을 확인하실
								수 있습니다.</td></b>
					</tr>
				</table>
			</div>

		</footer>

	</div>

</body>
</html>
