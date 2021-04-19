package com.kevinleader.bgr.persistence;

import javax.ws.rs.client.*;
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
    private String fields = "id,aggregated_rating,aggregated_rating_count,cover,first_release_date," +
            "genres,name,platforms,rating,rating_count,storyline,summary,total_rating," +
            "total_rating_count,url";

    public Game[] searchFromGameName(String gameName) throws JsonProcessingException {
        logger.debug("run searchFromName({})", gameName);

        String params = "?search=" + gameName.replaceAll(" ", "_") + "&fields=" + fields;
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

    public Game[] loadGamesToRank(String whereConditions) throws JsonProcessingException {
        logger.debug("run loadGamesToRank({})", whereConditions);

        String url = "https://api.igdb.com/v4/games";
        String body = "fields " + fields + "; limit 500; where rating_count > 0 " +
                "& aggregated_rating_count > 0" + whereConditions + "; sort total_rating desc;";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        builder.header("Client-Id", "bdm989e3d9fgsslcn2l9d9hktacpq3");
        builder.header("Authorization", "Bearer 7pslgqjjgluo8ci4vslr0gsm4uvavq");
        builder.header("Accept", "application/json");
        String response = builder.post(Entity.entity(body, MediaType.APPLICATION_JSON), String.class);
        ObjectMapper mapper = new ObjectMapper();
        Game[] games = mapper.readValue(response, Game[].class);
        client.close();
        return games;
    }

    public int getReleaseDateEpoch(int releaseSpan) {
        long currentTimestamp = System.currentTimeMillis();
        int currentTimeSec = (int) (currentTimestamp / 1000);
        return currentTimeSec - releaseSpan;
    }

}
