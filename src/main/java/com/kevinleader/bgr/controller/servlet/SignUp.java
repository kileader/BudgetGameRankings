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

/**
 * Serves indexSignUpSuccess.jsp
 */
@WebServlet(
        name = "SignUp",
        urlPatterns = {"/SignUp"}
)
public class SignUp extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private GenericDao userDao;
    private User receivedUser;
    private User newUser;
    private Role newRole;

    @Override
    public void init() {
        userDao = new GenericDao(User.class);
        receivedUser = new User();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run SignUp.doGet()");

        receivedUser.setUserName(req.getParameter("userName"));
        receivedUser.setEmail(req.getParameter("email"));
        receivedUser.setPassword(req.getParameter("password"));

        newUser = new User(receivedUser.getUserName(), receivedUser.getEmail(), receivedUser.getPassword());
        logger.debug("Add user: {}", newUser);

        newRole = new Role(newUser, "user", newUser.getUserName());
        newUser.addRole(newRole);

        int id = userDao.insert(newUser);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/indexSignUpSuccess.jsp");
        dispatcher.forward(req, resp);
    }

}
