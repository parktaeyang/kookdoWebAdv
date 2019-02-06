<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<jsp:include page="../../commonHeader.jsp" />
<link rel="stylesheet" href="<c:url value="/resources/css/entp/entp.css" />" >
<body>
    <!-- START: 본문 내용 -->
    <section class="content">
    <div class="probootstrap-main">

  <section class="probootstrap-section">
    <div class="content">
		<!--span class="title_line"></span>
		<h3>변화를 두려워하지않는<br/>고객만족을 위한 창조적 정신</h3-->
		<div>
			<dl>
				<dt><img src="resources/img/entp/group_1.JPG" alt=""/></dt>
			</dl>
			<dl>
				<dt>
				<div id="map" style="width:500px;height:400px;"></div> <!--// 지도가 표시될 크기 지정  -->
				<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=757ef067d548ee74f663aa11f632cc0a">
				// 지도 스크립트 다운로드 및 appkey등록
				</script>
				<script>
					var container = document.getElementById('map');
					var options = { // 옵션 확인
						center: new daum.maps.LatLng(36.35320043832783, 127.38944907757022), // 지도 중심 설정
						level: 14
					};
			
					var map = new daum.maps.Map(container, options);

					var positions = [
					    {
					        title: '카카오', 
					        latlng: new daum.maps.LatLng(33.450705, 126.570677)
					    },
					    {
					        title: '수정구청', 
					        latlng: new daum.maps.LatLng(37.45038065918457, 127.14562245746106)
					    }
				    ];
					for (var i = 0; i < positions.length; i ++) {
					    
					    // 마커를 생성합니다
					    var marker = new daum.maps.Marker({
					        map: map, // 마커를 표시할 지도
					        position: positions[i].latlng, // 마커를 표시할 위치
					        title : positions[i].title, // 마커의 타이틀, 마커에 마우스를 올리면 타이틀이 표시됩니다
					    });
					}
					// 마커가 지도 위에 표시되도록 설정합니다
					//marker.setMap(map);
				</script>
				</dt>
			</dl>
		</div>
	</div>
  </section>
  <!-- END section -->
</div>
    </section>
    <!-- END: 본문 내용 -->
<jsp:include page="../../commonFooter.jsp" />

</body>
</html>