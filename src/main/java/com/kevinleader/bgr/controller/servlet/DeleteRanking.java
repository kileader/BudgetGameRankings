package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.entity.database.RankingConfiguration;
import com.kevinleader.bgr.entity.database.User;
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
 * Deletes a ranking configuration and reloads /configList
 *
 * @author Kevin Leader
 */
@WebServlet(
        name = "DeleteRanking",
        urlPatterns = {"/deleteRanking"}
)
public class DeleteRanking extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao rankingConfigurationDao;

    @Override
    public void init() {
        logger.debug("run DeleteRanking.init()");
        userDao = new GenericDao(User.class);
        rankingConfigurationDao = new GenericDao(RankingConfiguration.class);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run DeleteRanking.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);
        req.setAttribute("user", user);

        int configToDeleteId = Integer.parseInt(req.getParameter("configToDelete"));
        RankingConfiguration configToDelete = (RankingConfiguration) rankingConfigurationDao.getById(configToDeleteId);

        // Prevent sneaky deletes to other users
        if (configToDelete.getUser().toString().equals(user.toString())) {
            rankingConfigurationDao.delete(configToDelete);
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/configList");
        dispatcher.forward(req, resp);
    }

}
