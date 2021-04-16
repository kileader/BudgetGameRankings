package com.kevinleader.bgr.controller;

import com.kevinleader.bgr.entity.User;
import com.kevinleader.bgr.entity.WishedGame;
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
 * Serves wishlist.jsp
 */
@WebServlet(
        name = "Wishlist",
        urlPatterns = {"/wishlist"}
)
public class Wishlist extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao wishedGameDao;
    private User user;
    private List<WishedGame> games;

    @Override
    public void init() {
        logger.debug("run Wishlist.init()");
        userDao = new GenericDao(User.class);
        wishedGameDao = new GenericDao(WishedGame.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        logger.debug("run Wishlist.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        user = (User) userDao.getById(userId);

        games = wishedGameDao.getByPropertyEqual("user", user);
        req.setAttribute("games", games);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/wishlist.jsp");
        dispatcher.forward(req, resp);
    }

}
