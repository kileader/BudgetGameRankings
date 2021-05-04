<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: headerAndNav.jsp
-->

<div class="col">
  <header class="jumbotron mb-0">
    <h1>Budget Game Rankings</h1>
  </header>

  <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand brand" href="index.jsp">BudgetGameRankings</a>

    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
      <span class="navbar-toggler-icon"></span>
    </button>

    <div class="collapse navbar-collapse" id="collapsibleNavbar">
      <ul class="navbar-nav">
        <li class="nav-item"><a class="nav-link" href="index.jsp">Home</a></li>
        <li class="nav-item"><a class="nav-link" href="displayRanking">Display Ranking</a></li>
        <%
          if (request.getRemoteUser() == null) {
        %>
          <li class="nav-item"><a class="nav-link" href="login">Log In</a></li>
          <li class="nav-item"><a class="nav-link" href="signup.jsp">Sign Up</a></li>
        <%
          } else {
        %>
          <li class="nav-item"><a class="nav-link" href="newRankConfig.jsp">New Rank Config</a></li>
          <li class="nav-item"><a class="nav-link" href="configList">Your Config List</a></li>
          <li class="nav-item"><a class="nav-link" href="wishlist">Your Wishlist</a></li>
          <li class="nav-item"><a class="nav-link" href="logout.jsp">Sign Out</a></li>
        <%
          }
        %>
      </ul>
    </div>
  </nav>
</div>