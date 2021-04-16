<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: login.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<c:set var="title" value="BGR Login" />
<jsp:include page="head.jsp"/>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>

      <form action="j_security_check" method="post" class="needs-validation" novalidate>

        <h2>Sign In</h2>

        <div class="form-group">
          <label class="bold" for="username">Username</label>
          <input type="text" id="username" placeholder="Username" name="j_username"
                 class="form-control" pattern="^.{1,255}$" required>
          <div class="invalid-feedback">Username is required (up to 255 characters)</div>
        </div>

        <div class="form-group">
          <label class="bold" for="password">Password</label>
          <input type="password" id="password" placeholder="Password" name="j_password"
                 class="form-control" pattern="^.{1,255}$" required>
          <div class="invalid-feedback">Password is required (up to 255 characters)</div>
        </div>

        <div class="form-group">
          <button type="submit" class="btn btn-success">Log In</button>
        </div>

      </form>
    </main>

    <!-- <div class="row" data-w3-include-html="footer.html"></div> -->
  </div>
  <script>
    // Disable form submissions if there are invalid fields
    (function() {
      'use strict';
      window.addEventListener('load', function() {
        // Get the forms we want to add validation styles to
        var forms = document.getElementsByClassName('needs-validation');
        // Loop over them and prevent submission
        var validation = Array.prototype.filter.call(forms, function(form) {
          form.addEventListener('submit', function(event) {
            if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
            }
            form.classList.add('was-validated');
          }, false);
        });
      }, false);
    })();
  </script>
</body>
</html>
