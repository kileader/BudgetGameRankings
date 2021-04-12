package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.igdb.Game;
import com.kevinleader.bgr.steampowered.AppsItem;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

import java.io.*;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TestServiceClient {

    @Test
    public void testIgdbSearchFromName() throws Exception {
        String search = "Dark SoUls III".replaceAll(" ", "_");
        String fields = "id,aggregated_rating,aggregated_rating_count,cover,first_release_date," +
                "genres,name,platforms,rating,rating_count,storyline,summary,total_rating," +
                "total_rating_count,url";
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
        ObjectMapper mapper = new ObjectMapper();
        Game[] games = mapper.readValue(response, Game[].class);
        String expectedName = "Dark Souls III";
        assertEquals(expectedName, games[0].getName());
        client.close();
    }

    @Test
    public void testFindSteamIDFromName() throws Exception {
        String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/";
        String gameName = "Hades";
        int appId;
        String appName;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        JsonNode node2 = node1.get("applist");
        JsonNode node3 = node2.get("apps");
        String json = node3.toString();

        AppsItem[] appsItems = mapper.readValue(json, AppsItem[].class);
        for (AppsItem app : appsItems) {
            appName = app.getName();
            if (appName.equals(gameName)) {
                appId = app.getAppid();
                assertEquals(1145360, appId);
                break;
            }
        }
        client.close();
    }

//    @Test
//    public void testReadSteamIDJSON() throws JsonProcessingException {
////        String gameName = "Hades";
//        String result = "";
////        boolean containsValue = false;
//        try {
//            BufferedReader reader = new BufferedReader(new FileReader("steamIDs.json"));
//            StringBuilder builder = new StringBuilder();
//            String line = reader.readLine();
//            while (line != null) {
//                builder.append(line);
//                line = reader.readLine();
//            }
//            result = builder.toString();
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        ObjectMapper mapper = new ObjectMapper();
//        Map<String, Object> map
//                = mapper.readValue(result, new TypeReference<Map<String,Object>>(){});
//        assertEquals("???", map);
//
//    }
}