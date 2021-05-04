package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.entity.database.WishedGame;
import com.kevinleader.bgr.persistence.GenericDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Inserts a game into a user's wishlist
 */
@WebServlet(
        name = "AddWishedGame",
        urlPatterns = {"/addWishedGame"}
)
public class AddWishedGame extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao wishedGameDao;
    private Set<WishedGame> usersWishedGames;

    @Override
    public void init() {
        logger.debug("run AddWishedGame.init()");
        userDao = new GenericDao(User.class);
        wishedGameDao = new GenericDao(WishedGame.class);
        usersWishedGames = new HashSet<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run AddWishedGame.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);
        req.setAttribute("user", user);

        String gameNameToAdd = req.getParameter("gameNameToAdd");

        int igdbIdToAdd = Integer.parseInt(req.getParameter("igdbIdToAdd"));

        WishedGame newWishedGame = new WishedGame(user,gameNameToAdd,igdbIdToAdd);

        wishedGameDao.insert(newWishedGame);
//        // Check if it already exists before inserting
//        usersWishedGames = user.getWishedGames();
//        boolean foundId = false;
//        if (usersWishedGames != null) {
//            for (WishedGame game : usersWishedGames) {
//                if (game.getIgdbGameId() == igdbIdToAdd) {
//                    foundId = true;
//                }
//            }
//        }
//        if (!foundId) {
//            wishedGameDao.insert(newWishedGame);
//        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wishlist");
        dispatcher.forward(req, resp);
    }

}
