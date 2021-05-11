package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.entity.database.Role;
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
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Deletes a user and reloads admin page.
 *
 * @author Kevin Leader
 */
@WebServlet(
        name = "DeleteUser",
        urlPatterns = {"/deleteUser"}
)
public class DeleteUser extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private Set<Role> currentUserRoles;

    @Override
    public void init() {
        logger.debug("run DeleteUser.init()");
        userDao = new GenericDao(User.class);
        currentUserRoles = new HashSet<>();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run DeleteUser.doGet()");

        // Grab user from login
        String username = req.getUserPrincipal().getName();
        List<User> users = userDao.getByPropertyEqual("userName", username);
        int userId = users.get(0).getId();
        User user = (User) userDao.getById(userId);
        req.setAttribute("user", user);

        int userToDeleteId = Integer.parseInt(req.getParameter("userToDeleteId"));
        User userToDelete = (User) userDao.getById(userToDeleteId);

        userDao.delete(userToDelete);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/admin");
        dispatcher.forward(req, resp);
    }

}
