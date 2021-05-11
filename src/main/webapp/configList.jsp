<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: configList.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings - Configuration List"/>

<html>

<%@include file="head.jsp"%>

<body>
<div class="container">
  <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

  <main>
    <h2>Your Ranking Configurations</h2>

    <table id="configsTable" class="table table-striped table-bordered" style="width:100%">
      <thead>
        <tr>
          <th>ID</th>
          <th>Configuration Name</th>
          <th>Platforms</th>
          <th>Genres</th>
          <th>Release Span</th>
          <th></th>
        </tr>
      </thead>

      <tbody>
      <c:forEach var="config" items="${rankConfigs}">
        <tr>
          <td>${config.id}</td>
          <td>${config.configurationName}</td>
          <td>${config.platforms}</td>
          <td>${config.genres}</td>
          <td>${config.releaseSpan}</td>
          <td><a href="deleteRanking?configToDelete=${config.id}">delete config</a></td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </main>

</div>
</body>
</html>

<script type="text/javascript" class="init">
    $(document).ready( function() {
        $('#configsTable').DataTable();
    } );
</script>