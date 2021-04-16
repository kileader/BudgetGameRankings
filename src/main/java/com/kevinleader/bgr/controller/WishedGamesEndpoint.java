package com.kevinleader.bgr.controller;

import com.kevinleader.bgr.entity.User;
import com.kevinleader.bgr.entity.WishedGame;
import com.kevinleader.bgr.persistence.GenericDao;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import java.util.List;

/**
 * The type Wished games endpoint.
 */
@Path("/wished_games")
public class WishedGamesEndpoint {

    /**
     * The User dao.
     */
    GenericDao userDao;
    /**
     * The Wished game dao.
     */
    GenericDao wishedGameDao;
    /**
     * The All users.
     */
    List<User> allUsers;
    /**
     * The Wished games for user.
     */
    List<WishedGame> wishedGamesForUser;
    /**
     * The Output.
     */
    String output;

    /**
     * Gets message.
     *
     * @param userName the user name
     * @param password the password
     * @return the message
     */
    @GET
    @Path("/{userName}/{password}")
    @Produces("application/text")
    public Response getMessage(
            @PathParam("userName") String userName,
            @PathParam("password") String password) {

        allUsers = userDao.getAll();

        for (User user : allUsers) {
            if (user.getUserName() == userName) {
                if (user.getPassword() == password) {
                    wishedGamesForUser = (List<WishedGame>) user.getWishedGames();
                } else {
                    break;
                }
            }
            if (user.getId() == allUsers.size()) {
                String output = "[]";
                return Response.status(418).entity(output).build();
            }
        }

        output = "{wished_games:[";
        int iteration = 0;

        for (WishedGame game : wishedGamesForUser) {
            output += "{game_name:" + game.getGameName() + "}";
            if (iteration != wishedGamesForUser.size()) {
                output += ",";
            }
            iteration++;
        }
        output += "]}";

        return Response.status(200).entity(output).build();
    }

}