package com.kevinleader.bgr.persistence;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kevinleader.bgr.entity.steam.AppListItem;
import com.kevinleader.bgr.entity.steam.PriceOverview;
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
    static AppListItem[] apps;

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

        apps = mapper.readValue(json, AppListItem[].class);
        client.close();
        return apps;
    }

    public int findSteamIdFromName(String gameName) throws Exception {
        logger.debug("run findSteamIdFromName({})", gameName);
        SteamDao steamDao = new SteamDao();
        if (apps == null) {
            apps = steamDao.loadSteamIds();
        }
        for (AppListItem app : apps) {
            String retrievedAppName = app.getName();
            if (retrievedAppName.equals(gameName)) {
                return app.getAppid();
            }
        }
        return -1;
    }

    public PriceOverview getPriceOverviewFromId(int steamId) throws Exception {
        logger.debug("run getPriceOverviewFromId({})", steamId);
        String priceOverview;
        PriceOverview appPrice;

        String stringId = String.valueOf(steamId);
        String url = "https://store.steampowered.com/api/appdetails?appids=" + stringId + "&currency=USD";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        JsonNode node2 = node1.get(stringId);
        JsonNode data = node2.get("data");

        if ((data != null) && (data.findValue("price_overview") != null)) {
            priceOverview = data.get("price_overview").toString();
            appPrice = mapper.readValue(priceOverview, PriceOverview.class);
        } else { //TODO: change this?
            appPrice = new PriceOverview("", 0, 0, "", "", 0);
        }
        client.close();
        return appPrice;
    }

}