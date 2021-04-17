<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: index.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <section>
        <h2>
          Hi there. Rankings will display here eventually. If you have an account,
          please <a href="/BudgetGameRankings/login">log in</a> to check your wishlist.
          Otherwise, if you want to customize your experience, please <a href="signup.jsp">sign up.</a>
        </h2>
      </section>
    </main>

    <!-- <div class="row">footer</div> -->
  </div>
</body>
</html>
