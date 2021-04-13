package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.igdb.Game;
import com.kevinleader.bgr.steampowered.AppDetails;
import com.kevinleader.bgr.steampowered.GetAppListItem;
import org.junit.Test;

import javax.ws.rs.client.*;
import javax.ws.rs.core.MediaType;

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

        GetAppListItem[] apps = mapper.readValue(json, GetAppListItem[].class);
        for (GetAppListItem app : apps) {
            appName = app.getName();
            if (appName.equals(gameName)) {
                appId = app.getAppid();
                assertEquals(1145360, appId);
                break;
            }
        }
        client.close();
    }


    @Test
    public void testFindSteamGameDetailsFromId() throws Exception {
//        String steamId = String.valueOf(892970); // Valheim, an early access game with no Metacritic score
        String steamId = String.valueOf(1145360); // Hades, a released game

        String url = "https://store.steampowered.com/api/appdetails?appids=" + steamId;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        JsonNode node2 = node1.get(steamId);
        JsonNode data = node2.get("data");

        String priceOverview = "\"price_overview\":" + data.get("price_overview").toString();
        String platforms = "\"platforms\":" + data.get("platforms").toString();
        String metacritic = "\"metacritic\":" + data.get("metacritic").toString();
        String categories = "\"categories\":" + data.get("categories").toString();
        String genres = "\"genres\":" + data.get("genres").toString();
        String releaseDate = "\"release_date\":" + data.get("release_date").toString();
        String recommendations = "\"recommendations\":" + data.get("recommendations").get("total").toString();

        String json = "{" + priceOverview + "," + platforms + "," + metacritic + "," + categories + "," +
                genres + "," + releaseDate + "," + recommendations + "}";

        AppDetails app = mapper.readValue(json, AppDetails.class);

        assertEquals(93, app.getMetacritic().getScore());

        client.close();
    }

}