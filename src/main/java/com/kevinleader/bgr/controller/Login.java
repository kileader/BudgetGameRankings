package com.kevinleader.bgr.controller;

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
 * Serves userIndex.jsp
 */
@WebServlet(
        name = "Login",
        urlPatterns = {"/login"}
)
public class Login extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        logger.debug("run Login.doGet()");

        RequestDispatcher dispatcher = req.getRequestDispatcher("/userIndex.jsp");
        dispatcher.forward(req, resp);
    }

}
