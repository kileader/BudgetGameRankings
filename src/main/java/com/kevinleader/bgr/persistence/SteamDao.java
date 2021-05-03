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
import java.util.ArrayList;
import java.util.List;

/**
 * DAO for use with the steampowered.com web service
 *
 * @author Kevin Leader
 */
public class SteamDao {

    private final Logger logger = LogManager.getLogger(this.getClass());
    /**
     * The Apps.
     */
    static AppListItem[] apps;

    /**
     * Load steam ids app list item [ ].
     *
     * @return the app list item [ ]
     * @throws Exception the exception
     */
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

//    /**
//     * Find steam id from name int.
//     *
//     * @param gameName the game name
//     * @return the int
//     * @throws Exception the exception
//     */
//    public int findSteamIdFromName(String gameName) throws Exception {
//        logger.debug("run findSteamIdFromName({})", gameName);
//        SteamDao steamDao = new SteamDao();
//        if (apps == null) {
//            apps = steamDao.loadSteamIds();
//        }
//        for (AppListItem app : apps) {
//            String retrievedAppName = app.getName();
//            if (retrievedAppName.equals(gameName)) {
//                return app.getAppid();
//            }
//        }
//        return -1;
//    }

    /**
     * Gets price overviews from ids.
     *
     * @param steamIds the steam ids
     * @return the price overviews from ids
     * @throws Exception the exception
     */
    public List<PriceOverview> getPriceOverviewsFromIds(List<Integer> steamIds) throws Exception {
        logger.debug("run getPriceOverviewsFromIds({})", steamIds);
        List<PriceOverview> appPrices = new ArrayList<>();
        String stringIds = "";

        for (int id : steamIds) {
            stringIds += String.valueOf(id);
            stringIds += ",";
        }
        String finalStringIds = stringIds.substring(0,stringIds.length()-1);

        String url = "https://store.steampowered.com/api/appdetails?appids="
                + finalStringIds + "&currency=USD&filters=price_overview";

        Client client = ClientBuilder.newClient();
        WebTarget target = client.target(url);
        Invocation.Builder builder = target.request(MediaType.APPLICATION_JSON);
        String response = builder.get(String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode node1 = mapper.readTree(response);
        for (int id : steamIds) {
            PriceOverview appPrice;
            JsonNode node2 = node1.get(Integer.toString(id));
            JsonNode data = node2.get("data");
            if ((data != null) && (data.findValue("price_overview") != null)) {
                String priceOverview = data.get("price_overview").toString();
                appPrice = mapper.readValue(priceOverview, PriceOverview.class);
            } else {
                appPrice = new PriceOverview("", 0, 0, "", "", 0);
            }
            appPrices.add(appPrice);
        }
        return appPrices;
    }

}