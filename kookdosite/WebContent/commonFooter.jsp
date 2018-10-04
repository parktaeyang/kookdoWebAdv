<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<% String ctx = request.getContextPath(); %>    
    <!-- START: footer --><!-- 나중에 싸이트맵 include 하기-->
    <footer class="probootstrap-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <p>&copy; 2018 <a href="#">KD Machine</a>. All Rights Reserved. <br> Designed &amp; Developed by <a href="#">반미정박태양박우주우헤헤 풋터적용함</a></p>
          </div>
        </div>
      </div>
    </footer>
    <!-- END: footer -->

    <!-- 맨 위로 버튼 -->
    <div class="gototop js-top">
      <a href="#" class="js-gotop"><i class="icon-chevron-thin-up"></i></a>
    </div>
    
    <!-- Javascript -->
    <script src="<c:url value="/resources/js/scripts.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.min.js" />"></script>
    <script src="<c:url value="/resources/js/custom.js" />"></script>