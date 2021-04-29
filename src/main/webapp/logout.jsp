<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: logout.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="BGR - Logged Out"/>
<% session.invalidate(); %>

<html>

<head>
  <title>${title}</title>

  <!-- Meta tags for Bootstrap -->
  <meta charset="utf-8"/>
  <meta name="viewport" content="width=device-width, initial-scale=1"/>

  <!-- Bootstrap and jQuery Stylesheets and Scripts -->
  <!-- Latest compiled and minified CSS -->
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"/>
  <!-- jQuery library -->
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <!-- Popper JS -->
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
  <!-- Latest compiled JavaScript -->
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

  <!-- jQuery Data Tables -->
  <link rel="stylesheet" href="//cdn.datatables.net/1.10.24/css/jquery.dataTables.min.css"/>
  <script src="//cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>

  <!-- Local Stylesheet -->
  <link rel="stylesheet" href="css/bgr.css"/>

  <!-- Refresh page after 5 seconds -->
  <meta http-equiv="refresh" content="5;url=index.jsp" />
</head>


<body>
  <div class="container">
    <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

    <main>
      <section>
        <h2>
          User '<%=request.getRemoteUser()%>' has been logged out.
          You should be redirected to home in a few seconds. If not,
          <a href="index.jsp">click here.</a>
        </h2>
      </section>
    </main>

    <!-- <div class="row">footer</div> -->
  </div>
</body>
</html>
