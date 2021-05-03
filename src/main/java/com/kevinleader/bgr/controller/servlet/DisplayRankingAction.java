package com.kevinleader.bgr.controller.servlet;

import com.kevinleader.bgr.analyzer.Ranker;
import com.kevinleader.bgr.entity.database.RankingConfiguration;
import com.kevinleader.bgr.entity.database.User;
import com.kevinleader.bgr.entity.igdb.Game;
import com.kevinleader.bgr.entity.ranker.RankedGame;
import com.kevinleader.bgr.persistence.GenericDao;
import com.kevinleader.bgr.persistence.IgdbDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Displays rankings for displayRanking.jsp
 */
@WebServlet(
        name = "DisplayRankingAction",
        urlPatterns = {"/displayRankingAction"}
)
public class DisplayRankingAction extends HttpServlet {

    private final Logger logger = LogManager.getLogger(this.getClass());
    private RankingConfiguration rankConfig;
    private GenericDao rankConfigDao = new GenericDao(RankingConfiguration.class);
    private IgdbDao igdbDao;
    private Ranker ranker;

    @Override
    public void init() {
        logger.debug("run DisplayRankingAction.init()");
        igdbDao = new IgdbDao();
        ranker = new Ranker();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        logger.debug("run DisplayRankingAction.doGet()");

        int rankConfigId = Integer.valueOf(req.getParameter("rankConfigId"));
        rankConfig = (RankingConfiguration) rankConfigDao.getById(rankConfigId);

        String whereCondition = igdbDao.createWhereCondition(rankConfig);
        Game[] games = igdbDao.loadGamesToRank(whereCondition);
        
        List<RankedGame> rankedGames = null;
        try {
            rankedGames = ranker.getRankedGameList(games);
        } catch (Exception e) {
            e.printStackTrace();
        }

        req.setAttribute("rankedGames", rankedGames);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/actuallyDisplayRanking.jsp");
        dispatcher.forward(req, resp);
    }

}
