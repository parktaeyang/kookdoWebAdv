<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" import="kookdo.conn.model.*" %>
<% 
String ctx = request.getContextPath();
%>
<head>
	<meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>국도머신(주)</title>
	
	<!-- CSS -->
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400" rel="stylesheet">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles-merged.css" />" >
    <link rel="stylesheet" href="<c:url value="/resources/css/style.min.css" />" >
    <link rel="stylesheet" href="<c:url value="/resources/css/custom.css" />" >
    
    <script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
	
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>
  <!-- START: header -->
    <div class="probootstrap-loader"></div>

    <header role="banner" class="probootstrap-header">
      <div class="container">
          <a href="index.do" class="probootstrap-logo"  style="color: red"><img src="resources/img/kd_logo.JPG" class="img-responsive"></a>

          <a href="#" class="probootstrap-burger-menu visible-xs" ><i>Menu</i></a>
          <div class="mobile-menu-overlay"></div>

          <nav role="navigation" class="probootstrap-nav hidden-xs">
            <ul class="probootstrap-main-nav">
              <li class="dropdown"><button class="dropbtn"><a>기업 프로필</a></button>
              	<span class="dropdown-content">
                  <a href="entp_ceo.do">대표이사 인사말</a>
                  <a href="entp_vision.do">기업 비전</a>
                  <a href="entp_history.do">연혁</a>
                  <a href="entp_group.do">조직도</a>
                  <a href="entp_contactus.do">오시는 길</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>제품소개</a></button>
                <span class="dropdown-content">
                  <a href="#">하이브리드CNC절곡기</a>
                  <a href="#">유압식 CNC절곡기</a>
                  <a href="#">유압식 NC절곡기(상향식)</a>
                  <a href="#">유압식 NC절곡기(상향식)</a>
                  <a href="#">유압식 NC절단기</a>
                  <a href="#">절단/절곡 로봇시스템</a>
                  <a href="#">유압식 CNC V컷팅기</a>
                  <a href="#">유압식 코너 샤링기</a>
                  <a href="#">기타 제품</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>기술 제휴 현황</a></button>
                <span class="dropdown-content">
                  <a href="#">CNC 컨트롤러</a>
                  <a href="#">유압 시스템</a>
                  <a href="#">TOOLING SYSTEMS</a>
                  <a href="#">로봇 시스템</a>
                  <a href="#">기타</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>갤러리/영상</a></button>
                <span class="dropdown-content">
                  <a href="#">하이브리드CNC절곡기</a>
                  <a href="#">유압식 CNC절곡기</a>
                  <a href="#">유압식 NC절곡기(상향식)</a>
                  <a href="#">유압식 NC절곡기(상향식)</a>
                  <a href="#">유압식 NC절단기</a>
                  <a href="#">절단/절곡 로봇시스템</a>
                  <a href="#">유압식 CNC V컷팅기</a>
                  <a href="#">유압식 코너 샤링기</a>
                  <a href="#">기타 제품</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>자금안내</a></button>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>재고 리스트</a></button>
                <span class="dropdown-content">
                  <a href="#">신제품</a>
                  <a href="#">중고제품</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn"><a>고객지원</a></button>
                <span class="dropdown-content">
                  <a href="#">제품 카달로그</a>
                  <a href="#">금형 도면 다운로드</a>
                  <a href="#">설명서 다운로드</a>
                  <a href="#">프로그램 다운로드</a>
                </span>
              </li>
              <c:if test="${empty sessionScope.loginUser}">
			  	<li class="dropdown"><a href="goLogin.do"><button class="dropbtn" id="btnLogin">Login</button></a>
			  </c:if>
              <c:if test="${not empty sessionScope.loginUser}">
				<li class="dropdown"><a href="goLogout.do"><button class="dropbtn" id="btnLogin">Logout</button></a>
					<span class="dropdown-content">
	                  <a href="#">거래처 등록/조회</a>
	                  <a href="tripreport_list.do">A/S 출장 보고서 등록</a>
	                  <a href="#">매입처 등록/조회</a>
	                  <a href="#">출장스케줄링</a>
	                  <a href="#">절곡/절단 능력조회</a>
	                  <a href="#">직원 명단 조회</a>
	                  <a href="goUserManagement.do">회원 관리</a>
	                </span>
			  	</li>			  </c:if>
                <!--
                <span class="dropdown-content">
                  <a href="#">Link1</a>
                  <a href="#">Link2</a>
                </span>
              -->
              </li>

              <!-- 선택적 메뉴들 -->
              <!--
              <li class="dropdown"><button class="dropbtn">Support</button>
                <span class="dropdown-content">
                  <a href="#">절곡 계산기</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn">My Pages</button>
                <span class="dropdown-content">
                  <a href="#">출장 보고서</a>
                  <a href="#">스케줄</a>
                  <a href="#">거래처 등록</a>
                  <a href="#">수주보고서</a>
                </span>
              </li>
              <li class="dropdown"><button class="dropbtn">CEO page</button>
                <span class="dropdown-content">
                  <a href="#">미정</a>
                </span>
              </li>
            -->
            </ul>
            <div class="extra-text visible-xs">
              <a href="#" class="probootstrap-burger-menu"><i>Menu</i></a>
              <h5>Address</h5>
              <p>198 West 21th Street, Suite 721 New York NY 10016</p>
              <h5>Connect</h5>
              <ul class="social-buttons">
                <li><a href="#"><i class="icon-twitter"></i></a></li>
                <li><a href="#"><i class="icon-facebook2"></i></a></li>
                <li><a href="#"><i class="icon-instagram2"></i></a></li>
              </ul>
            </div>
          </nav>
      </div>
    </header>
</body>