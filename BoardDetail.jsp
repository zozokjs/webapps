<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" type="text/css" href="mainPage.css">
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
		<!-- aside -->
		<!-- 좌측 앨범이미지를 나타내는 것 -->
		<aside>
		<img  src="9.png" width="100%" hight="100%">
		</aside>


		<section>
			<form action="NewFile.jsp">
				<table border="" align="center" width="50%">
					<tr>
						<td align="center" name="jang" value="제목">제목</td>
						<td>asdlfjaosdfjaosdf</td>
					</tr>
					<tr>
						<td align="center" name="jang1" value="상품이름">이름</td>
						<td>asdlfjaosdfjaosdf</td>
					</tr>
					<tr>
						<td align="center" name="jang2" value="가격">가격</td>
						<td>asdlfjaosdfjaosdf</td>
					</tr>
					<input type="hidden" name="jang" value="제목" >
					<input type="hidden" name="jang" value="제목2" >
					<input type="hidden" name="jang" value="제목3" >
				</table>
				<input type="submit" value="장바구니넣기"> 

			</form>


		</section>
		<!-- article -->

		<article></article>


		<!-- footer -->
		<footer>
			<div class="final">
				<table border="0" ; align="center" ; width="50%">
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
