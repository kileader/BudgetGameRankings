<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: wishlist.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="BGR - Wishlist"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNavLoggedIn.jsp"/></div>

    <main>
      <h2>Your Wishlist</h2>

      <table id="gamesTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
          <tr>
            <th>WishedGame ID</th>
            <th>Game Name</th>
            <th>IGDB Game ID</th>
            <th>Steam ID</th>
          </tr>
        </thead>

        <tbody>
        <c:forEach var="game" items="${games}">
          <tr>
            <td>${game.id}</td>
            <td>${game.gameName}</td>
            <td>${game.igdbGameId}</td>
            <td>
              <c:choose>
                <c:when test="${game.steamId eq -1}">
                  N/A
                </c:when>
                <c:otherwise>
                  ${game.steamId}
                </c:otherwise>
              </c:choose>
            </td>
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
        $('#gamesTable').DataTable();
    } );
</script>