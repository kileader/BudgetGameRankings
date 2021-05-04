package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.entity.database.RankingConfiguration;
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
import java.util.List;

/**
 * Deletes a wished game
 */
@WebServlet(
        name = "DeleteWishedGame",
        urlPatterns = {"/deleteWishedGame"}
)
public class DeleteWishedGame extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao wishedGameDao;

    @Override
    public void init() {
        logger.debug("run DeleteWishedGame.init()");
        userDao = new GenericDao(User.class);
        wishedGameDao = new GenericDao(WishedGame.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run DeleteWishedGame.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);
        req.setAttribute("user", user);

        int gameToDeleteId = Integer.parseInt(req.getParameter("gameToDeleteId"));
        WishedGame wishedGameToDelete = (WishedGame) wishedGameDao.getById(gameToDeleteId);

        // Prevent sneaky deletes to other users
        if (wishedGameToDelete.getUser().toString().equals(user.toString())) {
            wishedGameDao.delete(wishedGameToDelete);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wishlist");
        dispatcher.forward(req, resp);
    }

}
