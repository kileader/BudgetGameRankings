package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.analyzer.Ranker;
import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.entity.database.WishedGame;
import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.ranker.RankedGame;
import com.kevinleader.bgr.persistence.GenericDao;
import com.kevinleader.bgr.persistence.IgdbDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Gets the user's wished games, generates a ranking list, then forwards to wishlist.jsp.
 *
 * @author Kevin Leader
 */
@WebServlet(
        name = "Wishlist",
        urlPatterns = {"/wishlist"}
)
public class Wishlist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao wishedGameDao;
    private IgdbDao igdbDao;
    private Ranker ranker;

    @Override
    public void init() {
        logger.debug("run Wishlist.init()");
        userDao = new GenericDao(User.class);
        wishedGameDao = new GenericDao(WishedGame.class);
        igdbDao = new IgdbDao();
        ranker = new Ranker();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        logger.debug("run Wishlist.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);

        List<WishedGame> wishedGames = wishedGameDao.getByPropertyEqual("user", user);
        List<Integer> igdbIds = new ArrayList<>();
        for (WishedGame game : wishedGames) {
            igdbIds.add(game.getIgdbGameId());
        }

        String whereCondition = igdbDao.createWhereConditionFromIds(igdbIds);

        Game[] games = igdbDao.loadGamesToRank(whereCondition);

        List<RankedGame> wishedGamesFull = null;
        try {
            wishedGamesFull = ranker.getRankedGameList(games);
        } catch (Exception e) {
            logger.error("exception: ", e);
        }

        req.setAttribute("wishedGames", wishedGamesFull);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wishlist.jsp");
        dispatcher.forward(req, resp);
    }

}
