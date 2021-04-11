package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestServiceClient {

    @Test
    public void testIgdbSearchJSON() throws Exception {
        String search = "Hades";
        String fields = "id, age_ratings, aggregated_rating, aggregated_rating_count, cover, first_release_date";
        String sort = "rating_count_desc";
        String params = "?search=" + search + "&fields=" + fields + "&sort=" + sort;
        String url = "https://api.igdb.com/v4/games" + params;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        builder.header("Client-Id", "bdm989e3d9fgsslcn2l9d9hktacpq3");
        builder.header("Authorization", "Bearer 7pslgqjjgluo8ci4vslr0gsm4uvavq");
        builder.header("Accept", "application/json");
        String response = builder.get(String.class);
assertEquals("???", response);
//        ObjectMapper mapper = new ObjectMapper();
//        Games[] games = mapper.readValue(response, Games[].class);
//        String expectedName = "Hades";
//        assertEquals(expectedName, games[0].getName());
//        client.close();

    }
}