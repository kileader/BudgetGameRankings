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
      <table id="rankingsTable" class="table table-striped table-bordered" style="width:100%">
        <thead>
        <tr>
          <th>Game Name</th>
          <th>Value (Rating/USD)</th>
          <th></th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="game" items="${rankedGames}">
          <tr>
            <td>${game.name}</td>
            <td>${game.value}</td>
            <td><a href="">add to wishlist</a></td>
          </tr>
        </c:forEach>
        </tbody>
      </table>
    </section>
  </main>
</div>
</body>
</html>

<script type="text/javascript" class="init">
    $(document).ready( function() {
        $('#rankingsTable').DataTable( {
            "order": [[ 1, "desc" ]]
        } );
    } );
</script>