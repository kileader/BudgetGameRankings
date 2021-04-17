<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: logout.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="BGR - Logged Out"/>
<% session.invalidate(); %>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <section>
        <h2>
          User '<%=request.getRemoteUser()%>' has been logged out.
        </h2>
      </section>
    </main>

    <!-- <div class="row">footer</div> -->
  </div>
</body>
</html>
