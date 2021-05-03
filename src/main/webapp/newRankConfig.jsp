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

<body>
<div class="container">
  <div class="row"><jsp:include page="headerAndNav.jsp"/></div>

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
      <form action="saveRankConfig" method="POST" class="needs-validation" novalidate>

        <h3>Platforms</h3>
        <p>
          Either search with all platforms or choose from the options below.
          The default checked boxes have games with a price assigned.
          In general, games that are also on PC will have the best value.
        </p>

        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="allPlatforms" id="choosePlatforms" checked
              onclick="disablePlatforms(false)" value="no">
          <label class="form-check-label bold" for="choosePlatforms">Choose Platforms</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="allPlatforms" id="allPlatforms"
              onclick="disablePlatforms(true)" value="yes">
          <label class="form-check-label bold" for="allPlatforms">All Platforms</label>
        </div>

        <fieldset id="platforms">
          <table class="table table-borderless">
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
                <input type="checkbox" id="pc" name="p1" value="6" checked>
                <label for="pc" class="bold">PC (Windows)</label>
              </td>
              <td>
                <input type="checkbox" id="ps5" name="p2" value="167" checked>
                <label for="ps5" class="bold">PlayStation 5</label>
              </td>
              <td>
                <input type="checkbox" id="switch" name="p3" value="130" checked>
                <label for="switch" class="bold">Nintendo Switch</label>
              </td>
              <td>
                <input type="checkbox" id="oculus" name="p4" value="162" checked>
                <label for="oculus" class="bold">Oculus VR</label>
              </td>
              <td>
                <input type="checkbox" id="android" name="p5" value="34">
                <label for="android" class="bold">Android</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="mac" name="p6" value="14">
                <label for="mac" class="bold">Mac OS (Apple)</label>
              </td>
              <td>
                <input type="checkbox" id="xboxSeries" name="p7" value="169" checked>
                <label for="xboxSeries" class="bold">Xbox Series X/S</label>
              </td>
              <td>
                <input type="checkbox" id="ps4" name="p8" value="48" checked>
                <label for="ps4" class="bold">PlayStation 4</label>
              </td>
              <td>
                <input type="checkbox" id="steamVR" name="p9" value="163" checked>
                <label for="steamVR" class="bold">Steam VR</label>
              </td>
              <td>
                <input type="checkbox" id="iOS" name="p10" value="39">
                <label for="iOS" class="bold">iOS (iPhone)</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="linux" name="p11" value="3">
                <label for="linux" class="bold">Linux OS</label>
              </td>
              <td>
                <input type="checkbox" id="stadia" name="p12" value="170">
                <label for="stadia" class="bold">Google Stadia</label>
              </td>
              <td>
                <input type="checkbox" id="xboxOne" name="p13" value="49" checked>
                <label for="xboxOne" class="bold">Xbox One</label>
              </td>
              <td>
                <input type="checkbox" id="playstationVR" name="p14" value="165" checked>
                <label for="playstationVR" class="bold">Playstation VR</label>
              </td>
              <td>
                <input type="checkbox" id="3ds" name="p15" value="37">
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
                <input type="checkbox" id="wiiU" name="p16" value="41">
                <label for="wiiU" class="bold">Nintendo Wii U</label>
              </td>
              <td>
                <!-- empty -->
              </td>
              <td>
                <input type="checkbox" id="vita" name="p17" value="46">
                <label for="vita" class="bold">Playstation Vita</label>
              </td>
            </tr>
            </tbody>
          </table>
        </fieldset>

        <h3>Genres</h3>
        <p>
          Either search with all genres or choose from the options below.
          These are all possible genres in the igdb.com database.
        </p>

        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="allGenres" id="chooseGenres" checked
                 onclick="disableGenres(false)" value="no">
          <label class="form-check-label bold" for="chooseGenres">Choose Genres</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="allGenres" id="allGenres"
                 onclick="disableGenres(true)" value="yes">
          <label class="form-check-label bold" for="allGenres">All Genres</label>
        </div>

        <fieldset id="genres">
          <table class="table table-borderless">
            <tr>
              <td>
                <input type="checkbox" id="adventure" name="g1" value="31">
                <label for="adventure" class="bold">Adventure</label>
              </td>
              <td>
                <input type="checkbox" id="arcade" name="g2" value="33">
                <label for="arcade" class="bold">Arcade</label>
              </td>
              <td>
                <input type="checkbox" id="beatEmUp" name="g3" value="25">
                <label for="beatEmUp" class="bold">Beat 'em Up</label>
              </td>
              <td>
                <input type="checkbox" id="cardGame" name="g4" value="35">
                <label for="cardGame" class="bold">Card & Board Game</label>
              </td>
              <td>
                <input type="checkbox" id="fighting" name="g5" value="4">
                <label for="fighting" class="bold">Fighting</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="indie" name="g6" value="32">
                <label for="indie" class="bold">Indie</label>
              </td>
              <td>
                <input type="checkbox" id="moba" name="g7" value="36">
                <label for="moba" class="bold">MOBA</label>
              </td>
              <td>
                <input type="checkbox" id="music" name="g8" value="7">
                <label for="music" class="bold">Music</label>
              </td>
              <td>
                <input type="checkbox" id="pinball" name="g9" value="30">
                <label for="pinball" class="bold">Pinball</label>
              </td>
              <td>
                <input type="checkbox" id="platformer" name="g10" value="8">
                <label for="platformer" class="bold">Platformer</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="point_and_click" name="g11" value="2">
                <label for="point_and_click" class="bold">Point-and-Click</label>
              </td>
              <td>
                <input type="checkbox" id="puzzle" name="g12" value="9">
                <label for="puzzle" class="bold">Puzzle</label>
              </td>
              <td>
                <input type="checkbox" id="quiz" name="g13" value="26">
                <label for="quiz" class="bold">Quiz/Trivia</label>
              </td>
              <td>
                <input type="checkbox" id="racing" name="g14" value="10">
                <label for="racing" class="bold">Racing</label>
              </td>
              <td>
                <input type="checkbox" id="rts" name="g15" value="11">
                <label for="rts" class="bold">Real Time Strategy</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="rpg" name="g16" value="12">
                <label for="rpg" class="bold">Role-Playing Game</label>
              </td>
              <td>
                <input type="checkbox" id="shooter" name="g17" value="5">
                <label for="shooter" class="bold">Shooter</label>
              </td>
              <td>
                <input type="checkbox" id="simulator" name="g18" value="13">
                <label for="simulator" class="bold">Simulator</label>
              </td>
              <td>
                <input type="checkbox" id="sport" name="g19" value="14">
                <label for="sport" class="bold">Sport</label>
              </td>
              <td>
                <input type="checkbox" id="strategy" name="g20" value="15">
                <label for="strategy" class="bold">Strategy</label>
              </td>
            </tr>
            <tr>
              <td>
                <input type="checkbox" id="tactical" name="g21" value="24">
                <label for="tactical" class="bold">Tactical</label>
              </td>
              <td>
                <input type="checkbox" id="tbs" name="g22" value="16">
                <label for="tbs" class="bold">Turn-Based Strategy</label>
              </td>
              <td>
                <input type="checkbox" id="visualnovel" name="g23" value="34">
                <label for="visualnovel" class="bold">Visual Novel</label>
              </td>
            </tr>
          </table>
        </fieldset>

        <div class="row">
          <div class="col-md">
            <h3>Release Span</h3>
            <p>Enter a number value for oldest release date in years ago. (example: 1 year ago or 2.5 years ago)</p>
            <div class="form-group">
              <label class="bold" for="releaseSpan">Release Span (years)</label>
              <input type="text" id="releaseSpan" placeholder="Release Span" name="releaseSpan"
                     class="form-control" pattern="^\d*\.?\d*$" required value="1.5">
            </div>
          </div>
<%--          <div class="col-sm">--%>
<%--            <h3>Lowest Price</h3>--%>
<%--            <p>Enter a price in USD for the lowest priced game to rank. (Greater than 0 suggested)</p>--%>
<%--            <div class="form-group">--%>
<%--              <label class="bold" for="lowestPrice">Lowest Price (US Dollars)</label>--%>
<%--              <input type="text" id="lowestPrice" placeholder="Lowest Price" name="lowestPrice"--%>
<%--                     class="form-control" pattern="^\d*\.?\d*$" required value="5.00">--%>
<%--            </div>--%>
<%--          </div>--%>
<%--          <div class="col-sm">--%>
<%--            <h3>Highest Price</h3>--%>
<%--            <p>Enter a price in USD for the highest priced game to rank.</p>--%>
<%--            <div class="form-group">--%>
<%--              <label class="bold" for="highestPrice">Highest Price (US Dollars)</label>--%>
<%--              <input type="text" id="highestPrice" placeholder="Highest Price" name="highestPrice"--%>
<%--                     class="form-control" pattern="^\d*\.?\d*$" required value="70.00">--%>
<%--            </div>--%>
<%--          </div>--%>
        </div>

        <h3>Configuration Name</h3>
        <p>
          Name your new ranking configuration.
        </p>
        <div class="form-group">
          <label class="bold" for="configurationName">Configuration Name</label>
          <input type="text" id="configurationName" placeholder="Configuration Name" name="configurationName"
                 class="form-control" pattern="^.+$" required value="New Rank Config">
        </div>

        <div class="form-group">
          <button type="submit" class="btn btn-success">Create New Rank Config</button>
        </div>

      </form>
    </section>

  </main>

  <!-- <div class="row" data-w3-include-html="footer.html"></div> -->
</div>
<script>
    function disablePlatforms(flag) {
        if (!flag) {
            document.getElementById("platforms").removeAttribute("disabled");
        } else {
            document.getElementById("platforms").setAttribute("disabled", "true");
        }
    }

    function disableGenres(flag) {
        if (!flag) {
            document.getElementById("genres").removeAttribute("disabled");
        } else {
            document.getElementById("genres").setAttribute("disabled", "true");
        }
    }

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
