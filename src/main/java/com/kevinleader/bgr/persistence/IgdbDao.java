package com.kevinleader.bgr.persistence;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.entity.igdb.Game;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A DAO for use with the Igdb.com web service
 *
 * @author Kevin Leader
 */
public class IgdbDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public Game[] searchFromGameName(String gameName) throws JsonProcessingException {
        logger.debug("run searchFromName({})", gameName);
        String fields = "id,aggregated_rating,aggregated_rating_count,cover,first_release_date," +
                "genres,name,platforms,rating,rating_count,storyline,summary,total_rating," +
                "total_rating_count,url";
        String sort = "rating_count_desc";
        String params = "?search=" + gameName.replaceAll(" ", "_") + "&fields=" + fields + "&sort=" + sort;
        String url = "https://api.igdb.com/v4/games" + params;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        builder.header("Client-Id", "bdm989e3d9fgsslcn2l9d9hktacpq3");
        builder.header("Authorization", "Bearer 7pslgqjjgluo8ci4vslr0gsm4uvavq");
        builder.header("Accept", "application/json");
        String response = builder.get(String.class);
        ObjectMapper mapper = new ObjectMapper();
        Game[] games = mapper.readValue(response, Game[].class);
        client.close();
        return games;
    }

}
