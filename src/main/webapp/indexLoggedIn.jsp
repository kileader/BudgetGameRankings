<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: headerAndNavLoggedIn.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNavLoggedIn.jsp"/></div>

    <main>
      <section>
        <h2>
          Welcome, <%=request.getRemoteUser()%>. Rankings will display here eventually.
          You can check out <a href="/BudgetGameRankings/wishlist">your wishlist.</a>
        </h2>
      </section>
    </main>

    <!-- <div class="row">footer</div> -->
  </div>
</body>
</html>
