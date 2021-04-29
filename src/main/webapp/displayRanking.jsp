<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: displayRanking.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="BGR - Display Ranking"/>

<html>
<%@include file="head.jsp"%>

<body>
<div class="container">
  <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

  <main>
    <h2>Your Ranking</h2>

    <form action="">
      <div class="form-group">
        <label class="bold" for="ranking">Choose a ranking:</label>
        <select id="ranking" name="ranking">
          <c:forEach var="ranking" items="${rankingConfigurations}">

          </c:forEach>
        </select>
      </div>
      <div class="form-group">
        <button type="submit" class="btn btn-success">Create Account</button>
      </div>
    </form>

    <table id="gamesTable" class="table table-striped table-bordered" style="width:100%">
      <thead>
        <tr>
          <th>Game Name</th>
          <th>Value</th>
        </tr>
      </thead>

      <tbody>
      <c:forEach var="game" items="${games}">
        <tr>
          <td>${game.name}</td>
          <td>${game.value}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </main>

  <!-- footer -->
</div>
</body>
</html>

<script type="text/javascript" class="init">
    $(document).ready( function() {
        $('#gamesTable').DataTable( {
                "order": [[1, "desc"]]
        } );
    } );
</script>