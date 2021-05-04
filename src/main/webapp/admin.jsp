<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: admin.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings - Administration"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <h2>All Users</h2>

      <table id="usersTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
          <tr>
            <th>User ID</th>
            <th>User Name</th>
            <th>Email</th>
            <th></th>
          </tr>
        </thead>
        <tbody>
        <c:forEach var="user" items="${users}">
          <tr>
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email}</td>
            <td><a href="deleteUser?userToDeleteId=${user.id}">Delete User</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </main>

<%--    <div class="row">footer</div>--%>
  </div>
</body>
</html>
