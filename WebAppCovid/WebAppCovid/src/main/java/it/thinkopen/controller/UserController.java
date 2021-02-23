package it.thinkopen.controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(urlPatterns = "/userController")
public class UserController extends HttpServlet {

    private String dispatch = null;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");

        switch (action) {

            case "validate": {
                String header = req.getHeader("Authentication").substring(7);
                String name = req.getParameter("name");

                System.out.println(header);
                break;
            }
            case "change": {
                String header = req.getHeader("Authorization").substring(7);
                String name = req.getParameter("name");

                System.out.println(header);
                break;
            }

            case "change_home": {
                String header = req.getHeader("Authorization").substring(7);
                String name = req.getParameter("name");


                break;
            }


            case "logout": {
                String header = req.getHeader("Authorization").substring(7);
                break;
            }


        }
    }
}
