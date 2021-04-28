<!--
Budget Game Rankings
Author: Kevin Leader
Date: Spring 2021
Filename: newRankConfig.jsp
-->

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="BGR - Ranking Configuration"/>

<html>

<%@include file="head.jsp"%>

<<body>
<div class="container">
  <div class="row"><jsp:include page="headerAndNavLoggedIn.jsp"/></div>

  <main>
    <h2>Create a New Ranking Configuration</h2>

    <article>
      <h3>How the games are priced:</h3>
      <p>
        Games available on <a href="https://store.steampowered.com">PC through Steam</a>
        have exact pricing. The rest are valued at typical new game price.

        Exclusively <a href="https://en.wikipedia.org/wiki/Ninth_generation_of_video_game_consoles#Comparison">
        ninth generation games</a> are estimated at $69.99,
        and <a href="https://en.wikipedia.org/wiki/Eighth_generation_of_video_game_consoles#Comparison">
        eighth generation games</a> are estimated at $59.99.

        Exclusively mobile games for Android or iPhone are estimated as having
        a <a href="https://en.wikipedia.org/wiki/Freemium">freemium</a>, aka
        <a href="https://en.wikipedia.org/wiki/Free-to-play">free-to-play</a> pricing strategy.
        Any older games are assumed as out of production and vary too widely to estimate.
      </p>
    </article>

    <section>
      <form action="something" method="POST" class="needs-validation" novalidate>

        <h3>Platforms:</h3>
        <p>
          Either search for all games or choose from the options below.
          The default checked boxes have games with a price assigned.
          In general, games that are also on PC will have the best value.
        </p>

        </script>
        <div class="form-group">
          <label for="checkAll" class="bold">Check or Uncheck All Boxes</label>
          <input type="checkbox" id="checkAll" onclick="checkAll(this)">
        </div>

        <div class="form-group">
          <table id="platforms" class="table table-borderless">
            <thead>
              <tr>
                <th>Home Computer</th><th>Ninth Generation</th><th>Eighth Generation</th>
                <th>Virtual Reality</th><th>Mobile and Handheld</th>
              </tr>
            </thead>
            <tbody>
            <!-- The following values are the id numbers that igdb.com uses to represent each platform. -->
              <tr>
                <td>
                  <input type="checkbox" id="pc" name="platforms" value="6" checked>
                  <label for="pc" class="bold">PC (Windows)</label>
                </td>
                <td>
                  <input type="checkbox" id="ps5" name="platforms" value="167" checked>
                  <label for="ps5" class="bold">PlayStation 5</label>
                </td>
                <td>
                  <input type="checkbox" id="switch" name="platforms" value="130" checked>
                  <label for="switch" class="bold">Nintendo Switch</label>
                </td>
                <td>
                  <input type="checkbox" id="oculus" name="platforms" value="162" checked>
                  <label for="oculus" class="bold">Oculus VR</label>
                </td>
                <td>
                  <input type="checkbox" id="android" name="platforms" value="34">
                  <label for="android" class="bold">Android</label>
                </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" id="mac" name="platforms" value="14">
                  <label for="mac" class="bold">Mac OS (Apple)</label>
                </td>
                <td>
                  <input type="checkbox" id="xboxSeries" name="platforms" value="169" checked>
                  <label for="xboxSeries" class="bold">Xbox Series X/S</label>
                </td>
                <td>
                  <input type="checkbox" id="ps4" name="platforms" value="48" checked>
                  <label for="ps4" class="bold">PlayStation 4</label>
                </td>
                <td>
                  <input type="checkbox" id="steamVR" name="platforms" value="163" checked>
                  <label for="steamVR" class="bold">Steam VR</label>
                </td>
                <td>
                  <input type="checkbox" id="iOS" name="platforms" value="39">
                  <label for="iOS" class="bold">iOS (iPhone)</label>
                </td>
              </tr>
              <tr>
                <td>
                  <input type="checkbox" id="linux" name="platforms" value="3">
                  <label for="linux" class="bold">Linux OS</label>
                </td>
                <td>
                  <input type="checkbox" id="stadia" name="platforms" value="170">
                  <label for="stadia" class="bold">Google Stadia</label>
                </td>
                <td>
                  <input type="checkbox" id="xboxOne" name="platforms" value="49" checked>
                  <label for="xboxOne" class="bold">Xbox One</label>
                </td>
                <td>
                  <input type="checkbox" id="playstationVR" name="platforms" value="165" checked>
                  <label for="playstationVR" class="bold">Playstation VR</label>
                </td>
                <td>
                  <input type="checkbox" id="3ds" name="platforms" value="37">
                  <label for="3ds" class="bold">Nintendo 3DS</label>
                </td>
              </tr>
              <tr>
                <td>
                  <!-- empty -->
                </td>
                <td>
                  <!-- empty -->
                </td>
                <td>
                  <input type="checkbox" id="wiiU" name="platforms" value="41">
                  <label for="wiiU" class="bold">Nintendo Wii U</label>
                </td>
                <td>
                  <!-- empty -->
                </td>
                <td>
                  <input type="checkbox" id="vita" name="platforms" value="46">
                  <label for="vita" class="bold">Playstation Vita</label>
                </td>
              </tr>
            </tbody>
          </table>
        </div>

<%--        <div class="form-group">--%>
<%--          <label class="bold" for="email">Email</label>--%>
<%--          <input type="email" id="email" placeholder="Email" name="email"--%>
<%--                 class="form-control" pattern="^.{1,255}$" required>--%>
<%--          <div class="invalid-feedback">Email must be a valid address (up to 255 characters)</div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--          <label class="bold" for="password">Password</label>--%>
<%--          <input type="password" id="password" placeholder="Password" name="password"--%>
<%--                 class="form-control" pattern="^.{1,255}$" required>--%>
<%--          <div class="invalid-feedback">Password is required (up to 255 characters)</div>--%>
<%--        </div>--%>

<%--        <div class="form-group">--%>
<%--          <label class="bold" for="confirmPassword">Confirm Password</label>--%>
<%--          <input type="password" id="confirmPassword" placeholder="Confirm Password" name="password"--%>
<%--                 class="form-control" pattern="^.{1,255}$" required>--%>
<%--          <div class="invalid-feedback">Password is required (up to 255 characters)</div>--%>
<%--        </div>--%>

        <div class="form-group">
          <button type="submit" class="btn btn-success">Create Account</button>
        </div>

      </form>
    </section>

  </main>

  <!-- <div class="row" data-w3-include-html="footer.html"></div> -->
</div>
<script>
    // Disable form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Get the forms we want to add validation styles to
            let forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            let validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</body>
</html>
