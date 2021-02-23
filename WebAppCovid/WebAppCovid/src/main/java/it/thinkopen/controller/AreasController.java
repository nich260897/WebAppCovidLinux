package it.thinkopen.controller;

import com.google.gson.Gson;
import it.thinkopen.model.ResponseAreas;
import it.thinkopen.model.ResponsePeriod;
import it.thinkopen.repository.AreasRepository;
import it.thinkopen.repository.AreasRepositoryImpl;
import it.thinkopen.repository.PeriodRepository;
import it.thinkopen.repository.PeriodRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/areasController")
public class AreasController extends HttpServlet {
    private AreasRepository areasRepository = new AreasRepositoryImpl();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


        switch(action){
            case "globe": {

                ResponseAreas responseAreas = new ResponseAreas();
                responseAreas.setCountries(areasRepository.countries());
                responseAreas.setNum_search(areasRepository.numSearch());

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(gson.toJson(responseAreas));

                break;
            }
        }
    }
}
