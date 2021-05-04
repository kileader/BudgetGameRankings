<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: wishlist.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings - Wishlist"/>

<html>

<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <h2>Your Wishlist</h2>

      <table id="gamesTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
          <tr>
            <th>Game Name</th>
            <th>Value (Rating/USD)</th>
            <th>igdb.com Rating</th>
            <th>Current Price (USD)</th>
            <th>Websites</th>
            <th></th>
          </tr>
        </thead>

        <tbody>
        <c:forEach var="game" items="${wishedGames}">
          <tr>
            <td>${game.name}</td>
            <td>${game.value}</td>
            <td>${game.rating}</td>
            <td>${game.price}</td>
            <td>
              <a href="${game.url}" target="_blank">igdb</a>
              <c:forEach var="website" items="${game.websites}">
                <c:choose>
                  <c:when test="${website.category == '1'}">
                    <a href="${website.url}" target="_blank">official</a>
                  </c:when>
                  <c:when test="${website.category == '3'}">
                    <a href="${website.url}" target="_blank">wikipedia</a>
                  </c:when>
                  <c:when test="${website.category == '13'}">
                    <a href="${website.url}" target="_blank">steam</a>
                  </c:when>
                </c:choose>
              </c:forEach>
            </td>
            <td>
              <a href="deleteWishedGame?gameToDeleteIgdbId=${game.igdbId}">delete from wishlist</a>
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