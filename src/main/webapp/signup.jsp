<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: signup.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings - Sign Up"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>

      <form action="signup" method="GET" class="needs-validation" novalidate>

        <h2>Sign Up</h2>

        <div class="form-group">
          <label class="bold" for="username">Username</label>
          <input type="text" id="username" placeholder="Username" name="userName"
                 class="form-control" pattern="^.{1,255}$" required>
          <div class="invalid-feedback">Username is required (up to 255 characters)</div>
        </div>

        <div class="form-group">
          <label class="bold" for="email">Email</label>
          <input type="email" id="email" placeholder="Email" name="email"
                 class="form-control" pattern="^.{1,255}$" required>
          <div class="invalid-feedback">Email must be a valid address (up to 255 characters)</div>
        </div>

        <div class="form-group">
          <label class="bold" for="password">Password</label>
          <input type="password" id="password" placeholder="Password" name="password"
                 class="form-control" pattern="^.{1,255}$" required>
          <div class="invalid-feedback">Password is required (up to 255 characters)</div>
        </div>

        <div class="form-group">
          <label class="bold" for="confirmPassword">Confirm Password</label>
          <input type="password" id="confirmPassword" placeholder="Confirm Password" name="password"
                 class="form-control" pattern="^.{1,255}$" required>
          <span id="message"></span>
          <div class="invalid-feedback">Incorrect Confirm Password</div>
        </div>

        <div class="form-group">
          <button type="submit" class="btn btn-success">Create Account</button>
        </div>

      </form>
    </main>


    <!-- <div class="row" data-w3-include-html="footer.html"></div> -->
  </div>
  <script>
      // Add confirm password functionality
      $(`#password, #confirmPassword`).on('keyup', function () {
          if ($('#password').val() === $('#confirmPassword').val()) {
              $('#message').html('Matching').css('color', 'green');
          } else
              $('#message').html('Not Matching').css('color', 'red');
      });

      // Disable form submissions if there are invalid fields
      (function() {
          'use strict';
          window.addEventListener('load', function() {
              // Get the forms we want to add validation styles to
              let forms = document.getElementsByClassName('needs-validation');
              // Loop over them and prevent submission
              let validation = Array.prototype.filter.call(forms, function (form) {
                  form.addEventListener('submit', function (event) {
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
