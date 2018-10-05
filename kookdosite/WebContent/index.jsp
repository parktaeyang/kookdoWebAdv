<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page session="false" %>
<% String ctx = request.getContextPath(); %>
<html>
<jsp:include page="commonHeader.jsp" />

    <!-- START: 본문 내용 -->
    <section class="content">
      <div class="probootstrap-main">
      
  <section class="probootstrap-section-half">
    <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(<c:url value="/resources/img/image_3.jpg" />)"></div>
    <div class="probootstrap-text">
      <div class="probootstrap-inner probootstrap-animate">
        <h1 class="heading">회사 소개 파트test</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Ipsum asperiores dicta tempore dolores odit eveniet, vel itaque recusandae sunt consequuntur quod dolor sint non accusamus et a, sequi. Vitae, necessitatibus!</p>
        <p><a href="single-page.html" class="btn btn-primary">Learn More</a></p>
      </div>
    </div>
  </section>
  <!-- END section -->
  <section class="probootstrap-section-half probootstrap-reverse">
    <div class="probootstrap-image probootstrap-animate"  data-animate-effect="fadeIn" style="background-image: url(<c:url value="/resources/img/image_2.jpg" />)"></div>
    <div class="probootstrap-text">
      <div class="probootstrap-inner probootstrap-animate">
        <h1 class="heading">제품명</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Eligendi eaque ut commodi est, voluptate iusto illum dolore placeat, omnis sit velit asperiores nobis nulla aut quibusdam in ipsum officia rerum.</p>
        <p><a href="single-page.html" class="btn btn-primary">Learn More</a></p>
      </div>
    </div>
  </section>
  <!-- END section -->
  <section class="probootstrap-section-half">
    <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(<c:url value="/resources/img/image_3.jpg" />)"></div>
    <div class="probootstrap-text">
      <div class="probootstrap-inner probootstrap-animate">
        <h1 class="heading">제품명</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nihil optio libero magni dolor! Dicta obcaecati, fugit ab voluptatum consequatur ex! Provident fugiat cum explicabo illo sed dolore autem ea vero.</p>
        <p><a href="single-page.html" class="btn btn-primary">Learn More</a></p>
      </div>
    </div>
  </section>
  <!-- END section -->
  <section class="probootstrap-section-half probootstrap-reverse">
    <div class="probootstrap-image probootstrap-animate" data-animate-effect="fadeIn" style="background-image: url(<c:url value="/resources/img/image_4.jpg" />)"></div>
    <div class="probootstrap-text">
      <div class="probootstrap-inner probootstrap-animate">
        <h1 class="heading">제품명</h1>
        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Est excepturi itaque qui odio, consectetur veniam quisquam asperiores dolores repellat fugiat maiores repellendus laborum recusandae voluptatibus, quis eum nisi id dolor.</p>
        <p><a href="single-page.html" class="btn btn-primary">Learn More</a></p>
      </div>
    </div>
  </section>
    </section>
    <!-- END: 본문 내용 -->


<jsp:include page="commonFooter.jsp" />
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
