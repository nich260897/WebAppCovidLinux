package it.thinkopen.controller;

import com.google.gson.Gson;
import it.thinkopen.model.ResponsePeriod;
import it.thinkopen.repository.PeriodRepository;
import it.thinkopen.repository.PeriodRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/periodController")
public class PeriodController extends HttpServlet {
    private PeriodRepository periodRepository = new PeriodRepositoryImpl();
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");


        switch(action){
            case "calendar": {


                List<Integer> num_search = periodRepository.numSearch();
                List<String> weeks = periodRepository.weeks();

                ResponsePeriod responsePeriod = new ResponsePeriod();
                responsePeriod.setWeeks(weeks);
                responsePeriod.setNum_search(num_search);

                resp.setContentType("application/json");
                resp.setCharacterEncoding("UTF-8");
                resp.getWriter().write(gson.toJson(responsePeriod));

                break;
            }
        }
    }



}
