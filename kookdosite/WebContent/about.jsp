<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<html>
<jsp:include page="commonHeader.jsp" />
<body>
    <!-- START: 본문 내용 -->
    <section class="content">
    <div class="probootstrap-main">

 <section class="probootstrap-section-half probootstrap-no-hover">
    <div class="probootstrap-image" style="background-image: url({% static 'homepage/img/image_2.jpg' %})"></div>
    <div class="probootstrap-text">
      <div class="probootstrap-inner probootstrap-animate">
        <h1 class="heading">About Us</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Perspiciatis hic dicta consectetur. Praesentium deleniti, modi. Alias sit possimus inventore, ullam soluta modi tempore reprehenderit, voluptate consectetur ab quis iusto animi.</p>
      </div>
    </div>
  </section>
  <!-- END section -->


  <section class="probootstrap-section">
    <div class="container">
      <div class="row mb70 probootstrap-animate" data-animate-effect="fadeIn">
        <div class="col-md-6">
          <h2>How We Started</h2>
          <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
          <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
        </div>
        <div class="col-md-6">
          <h2>History</h2>
          <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
          <p>A small river named Duden flows by their place and supplies it with the necessary regelialia. It is a paradisematic country, in which roasted parts of sentences fly into your mouth.</p>
        </div>
      </div>

      <div class="row">
        <div class="col-md-12 section-heading text-center probootstrap-animate">
          <h2 class="mb70">CEO</h2>
        </div>
      </div>
      <div class="row">
        <div class="col-md-4 probootstrap-animate mb50">
          <div class="probootstrap-card probootstrap-person text-center">
            <div class="probootstrap-card-media">
              <img src="{% static 'homepage/img/person_1.jpg' %}" class="img-responsive" alt="Free HTML5 Template by uicookies.com">
            </div>
            <div class="probootstrap-card-text">
              <h2 class="probootstrap-card-heading mb0">Jeremy Slater</h2>
              <p><small>Web Designer</small></p>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
              <ul class="probootstrap-social">
                <li><a href="#"><i class="icon-facebook2"></i></a></li>
                <li><a href="#"><i class="icon-twitter"></i></a></li>
                <li><a href="#"><i class="icon-dribbble"></i></a></li>
                <li><a href="#"><i class="icon-instagram2"></i></a></li>
              </ul>
            </div>
          </div>
        </div>

        <!-- CEO part -->
        <div class="col-md-4 probootstrap-animate mb50">
          <div class="probootstrap-card probootstrap-person text-center">
            <div class="probootstrap-card-media">
              <img src="{% static 'homepage/img/person_2.jpg' %}" class="img-responsive" alt="Free HTML5 Template by uicookies.com">
            </div>
            <div class="probootstrap-card-text">
              <h2 class="probootstrap-card-heading mb0">James Butterly</h2>
              <p><small>Web Developer</small></p>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
              <ul class="probootstrap-social">
                <li><a href="#"><i class="icon-facebook2"></i></a></li>
                <li><a href="#"><i class="icon-twitter"></i></a></li>
                <li><a href="#"><i class="icon-github"></i></a></li>
                <li><a href="#"><i class="icon-instagram2"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
        <div class="col-md-4 probootstrap-animate mb50">
          <div class="probootstrap-card probootstrap-person text-center">
            <div class="probootstrap-card-media">
              <img src="{% static 'homepage/img/person_3.jpg' %}" class="img-responsive" alt="Free HTML5 Template by uicookies.com">
            </div>
            <div class="probootstrap-card-text">
              <h2 class="probootstrap-card-heading mb0">James Smith</h2>
              <p><small>Web Designer</small></p>
              <p>Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean.</p>
              <ul class="probootstrap-social">
                <li><a href="#"><i class="icon-facebook2"></i></a></li>
                <li><a href="#"><i class="icon-twitter"></i></a></li>
                <li><a href="#"><i class="icon-dribbble"></i></a></li>
                <li><a href="#"><i class="icon-instagram2"></i></a></li>
              </ul>
            </div>
          </div>
        </div>
      </div>

    </div>
  </section>
  <!-- END section -->
</div>
    </section>
    <!-- END: 본문 내용 -->

    <!-- START: footer --><!-- 나중에 싸이트맵 include 하기-->
    <footer class="probootstrap-footer">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <p>&copy; 2018 <a href="#">KD Machine</a>. All Rights Reserved. <br> Designed &amp; Developed by <a href="#">반미정박태양박우주우헤헤</a></p>
          </div>
        </div>
      </div>
    </footer>
    <!-- END: footer -->

    <!-- 맨 위로 버튼 -->
    <div class="gototop js-top">
      <a href="#" class="js-gotop"><i class="icon-chevron-thin-up"></i></a>
    </div>

    <!-- 로그인모달 -->
    <!--<div class="modal fade" id="logInModal" role="dialog">
      {% if form.errors %}
      <p>Your username and password didn't match. Please try again.</p>
      {% endif %}
      
      {% if next %}
          {% if user.is_authenticated %}
          <p>Your account doesn't have access to this page. To proceed,
          please login with an account that has access.</p>
          {% else %}
          <p>Please login to see this page.</p>
          {% endif %}
      {% endif %}
      <div class="modal-dialog">
        <div class="loginmodal-container">
            <h1>Login</h1><br>
          <form method="post" action="{% url 'login' %}">
            {% csrf_token %}
            <input type="text" name="username" placeholder="Username">
            <input type="password" name="password" placeholder="Password">
            <input type="submit" name="login"> <!-- value="Login" 
            <input type="hidden" name="next" value="{{ next }}" />
          </form>
        <div class="login-help">
            <a href="#">Register</a> - <a href="#">Forgot Password</a>
        </div>
        </div>
      </div>
    </div> -->

    <!-- Javascript -->
    <script src="<c:url value="/resources/js/scripts.min.js" />"></script>
    <script src="<c:url value="/resources/js/main.min.js" />"></script>
    <script src="<c:url value="/resources/js/custom.js" />"></script>
   <!--  <script>
      $(document).ready(function(){
          $("#btnLogin").click(function(){
              $("#logInModal").modal();
          });
      });
    </script>
    -->
</body>
</html>