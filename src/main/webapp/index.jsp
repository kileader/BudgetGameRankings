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
        <%
          if (request.getRemoteUser() == null) {
        %>
          <h2>Welcome</h2>
          <h3>
            Hi there. If you have an account, please <a href="login">log in</a>.
            Otherwise, please <a href="signup">sign up.</a>
          </h3>
          <p>
            (Using fake emails and super simple usernames and passwords is best at the moment.)
            A detailed user guide will display here once you are logged in.
          </p>
        <%
          } else {
        %>
          <h2>Welcome, <%=request.getRemoteUser()%>.</h2>
          <h3>Getting Started</h3>
          <p>
            Most of navigation through this site is done with the navbar at the top of the page.
            The meat-and-potatoes of this app is in the <a href="displayRanking">Display Ranking</a> section.
            You start off with one default ranking for all games for the past 5 years, but you will
            probably want to construct your own Ranking Configuration by
            selecting <a href="newRankConfig.jsp">New Rank Config</a>.
          </p>
          <h3>Viewing and Deleting From Your Lists</h3>
          <p>
            The <a href="configList">Your Config List</a> section displays all your currently created
            Ranking Configurations, and you may choose to delete one here. The <a href="wishlist">
            Your Wishlist</a> is used in the same way but for a list of games that you wish to keep tabs on.
          </p>
        <%
          }
        %>
      </section>
      <section>
        <form
      </section>
    </main>

    <!-- <div class="row">footer</div> -->
  </div>
</body>
</html>
