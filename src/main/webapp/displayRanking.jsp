<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: displayRanking.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Budget Game Rankings - Display Ranking"/>

<html>
<%@include file="head.jsp"%>

<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <section>
        <form action="displayRankingAction" method="GET">
          <h2>Choose a Ranking Configuration</h2>
          <select class="form-select" name="rankConfigId" id="rankConfigSelect">
            <option selected>Choose...</option>
            <c:forEach var="rankConfig" items="${rankConfigs}">
              <option value="${rankConfig.id}">${rankConfig.configurationName}</option>
            </c:forEach>
          </select>
          <button type="submit" class="btn btn-success">Display Ranking</button>
        </form>
      </section>
      <section>
        <h3>${chosenRankConfig.configurationName}</h3>
        <table id="rankingsTable" class="table table-striped table-bordered" style="width:100%">
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
          <c:forEach var="rankedGame" items="${rankedGames}">
            <tr>
              <td>${rankedGame.name}</td>
              <td>${rankedGame.value}</td>
              <td>${rankedGame.rating}</td>
              <td>${rankedGame.price}</td>
              <td>
                <a href="${rankedGame.url}" target="_blank">igdb</a>
                <c:forEach var="website" items="${rankedGame.websites}">
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
              <td><a href="addWishedGame?gameNameToAdd=${rankedGame.name}&igdbIdToAdd=${rankedGame.igdbId}">add to wishlist</a></td>
            </tr>
          </c:forEach>
          </tbody>
        </table>
      </section>
<%-- TODO: Make remove actions for RankingConfig and WishedGames--%>

    </main>

    <!-- footer -->
  </div>
  <script type="text/javascript" class="init">
      $(document).ready( function() {
          $('#rankingsTable').DataTable( {
              "order": [[ 1, "desc" ]]
          } );
      } );
  </script>
</body>
</html>
