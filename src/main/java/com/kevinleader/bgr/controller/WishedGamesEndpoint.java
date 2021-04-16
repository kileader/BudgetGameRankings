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

@Path("/wished_games")
public class WishedGamesEndpoint {

    GenericDao userDao;
    GenericDao wishedGameDao;
    List<User> allUsers;
    List<WishedGame> wishedGamesForUser;
    String output;

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