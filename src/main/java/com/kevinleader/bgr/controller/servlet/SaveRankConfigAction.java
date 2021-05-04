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
 * Saves a rank config
 */
@WebServlet(
        name = "SaveRankConfig",
        urlPatterns = {"/saveRankConfig"}
)
public class SaveRankConfigAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private GenericDao rankingConfigurationDao;
    private RankingConfiguration newRankingConfiguration;

    @Override
    public void init() {
        userDao = new GenericDao(User.class);
        rankingConfigurationDao = new GenericDao(RankingConfiguration.class);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run SaveRankConfig.doPost()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);

        // Grab configuration name from form
        String configurationName = req.getParameter("configurationName");

        // Create a string of comma separated integers of platform IDs from form
        String platforms = "";
        if (req.getParameter("allPlatforms").equals("yes")) {
            platforms = "Any";
        } else {
            boolean first = true;
            for (int i = 1; i < 18; i++) {
                if (req.getParameter("p" + i) != null) {
                    if (first) {
                        platforms += req.getParameter("p" + i);
                        first = false;
                    } else {
                        platforms += "," + req.getParameter("p" + i);
                    }
                }
            }
        }

        // Create a string of comma separated integers of genre IDs from form
        String genres = "";
        if (req.getParameter("allGenres").equals("yes")) {
            genres = "Any";
        } else {
            boolean first = true;
            for (int i = 1; i < 24; i++) {
                if (req.getParameter("g" + i) != null) {
                    if (first) {
                        genres += req.getParameter("g" + i);
                        first = false;
                    } else {
                        genres += "," + req.getParameter("g" + i);
                    }
                }
            }
        }

        // Create a release span in seconds from number of years
        int releaseSpan = (int) (Double.parseDouble(req.getParameter("releaseSpan")) * 31556926);

        newRankingConfiguration = new RankingConfiguration(user,configurationName,platforms,genres,releaseSpan);
        int id = rankingConfigurationDao.insert(newRankingConfiguration);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
    }

}
