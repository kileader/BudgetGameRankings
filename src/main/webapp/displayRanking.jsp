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
      <section>
        <form action="displayRankingAction" method="GET">
          <h2>Choose a Ranking Configuration to Display</h2>
          <div class="form-group">
            <label for="rankConfigSelect">Choose Config</label>
            <select name="rankConfigId" id="rankConfigSelect">
              <c:forEach var="rankConfig" items="${rankConfigs}">
                <option value="${rankConfig.id}">${rankConfig.configurationName}</option>
              </c:forEach>
            </select>
          </div>
          <div class="form-group">
            <button type="submit" class="btn btn-success">Display Ranking</button>
          </div>
        </form>
      </section>

<%--      <h2>Your Ranking Configurations</h2>--%>

<%--      <table id="rankConfigsTable" class="table table-striped table-bordered" style="width:100%">--%>
<%--        <thead>--%>
<%--          <tr>--%>
<%--            <th>Rank Config ID</th>--%>
<%--            <th>Configuration Name</th>--%>
<%--            <th>Platforms</th>--%>
<%--            <th>Genres</th>--%>
<%--            <th>Release Span</th>--%>
<%--            <th></th>--%>
<%--          </tr>--%>
<%--        </thead>--%>

<%--        <tbody>--%>
<%--        <c:forEach var="rankConfig" items="${rankConfigs}">--%>
<%--          <tr>--%>
<%--            <td>${rankConfig.id}</td>--%>
<%--            <td>${rankConfig.configurationName}</td>--%>
<%--            <td>${rankConfig.platforms}</td>--%>
<%--            <td>${rankConfig.genres}</td>--%>
<%--            <td>${rankConfig.releaseSpan}</td>--%>
<%--            <td><a href="">remove</a></td>--%>
<%--&lt;%&ndash;            TODO: Make remove actions for RankingConfig and WIshedGame&ndash;%&gt;--%>
<%--          </tr>--%>
<%--        </c:forEach>--%>
<%--        </tbody>--%>
<%--      </table>--%>
    </main>

    <!-- footer -->
  </div>
</body>
</html>
