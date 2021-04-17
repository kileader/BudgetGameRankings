package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.entity.steam.AppDetails;
import com.kevinleader.bgr.entity.steam.AppListItem;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

/**
 * DAO for use with the steampowered.com web service
 *
 * @author Kevin Leader
 */
public class SteamDao {

    private final Logger logger = LogManager.getLogger(this.getClass());

    public AppListItem[] loadSteamIds() throws Exception {
        logger.debug("run loadSteamIds()");
        String url = "https://api.steampowered.com/ISteamApps/GetAppList/v2/";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        JsonNode node2 = node1.get("applist");
        JsonNode node3 = node2.get("apps");
        String json = node3.toString();

        AppListItem[] apps = mapper.readValue(json, AppListItem[].class);
        client.close();
        return apps;
    }

    public int findSteamIdFromName(String gameName) throws Exception {
        SteamDao steamDao = new SteamDao();
        AppListItem[] apps = steamDao.loadSteamIds();

        for (AppListItem app : apps) {
            String retrievedAppName = app.getName();
            if (retrievedAppName.equals(gameName)) {
                return app.getAppid();
            }
        }
        return -1;
    }

    public AppDetails findSteamGameDetailsFromId(int steamId) throws Exception {
        String stringId = String.valueOf(steamId);
        String url = "https://store.steampowered.com/api/appdetails?appids=" + stringId;

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        JsonNode node2 = node1.get(stringId);
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
        client.close();
        return app;
    }

}