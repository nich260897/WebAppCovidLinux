package it.thinkopen.filter;

import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken;
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.gson.Gson;
import it.thinkopen.config.Config;
import it.thinkopen.dto.Response;
import it.thinkopen.jwtTokenUtil.JwtTokenUtil;
import it.thinkopen.model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;

@WebFilter(value = "/userController")
public class JwtFilter implements Filter {

    private Gson gson = new Gson();
    private JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        //casting ServletRequest, ServletResponse to HttpServletRequest and HttpServletResponse
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        HttpServletResponse httpServletResponse = (HttpServletResponse) response;

        String requestTokenHeader = null;
        String token;
        GoogleIdToken idToken;
        boolean tokenIsValid = false;

        System.out.println(httpServletRequest.getHeader("Authorization"));

        if (httpServletRequest.getHeader("Authentication") != null && httpServletRequest.getHeader("Authentication").startsWith("Bearer ") &&
                httpServletRequest.getParameter("action") != null && httpServletRequest.getParameter("action").equals("validate")) {

            requestTokenHeader = httpServletRequest.getHeader("Authentication");
            token = requestTokenHeader.substring(7);

            NetHttpTransport transport = new NetHttpTransport();
            JacksonFactory jacksonFactory = new JacksonFactory();

            GoogleIdTokenVerifier verifier = new GoogleIdTokenVerifier.Builder(transport, jacksonFactory)
                    .setAudience(Arrays.asList(Config.getConfig().getProperty("client_id")))
                    .build();

            idToken = GoogleIdToken.parse(verifier.getJsonFactory(), token);

            try{
                tokenIsValid = (idToken != null) && verifier.verify(idToken);
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            }

            if(idToken!=null && tokenIsValid){

                Response resp = new Response();
                User user = new User();

                user.setNome((String) idToken.getPayload().get("given_name"));
                user.setCognome((String) idToken.getPayload().get("family_name"));
                user.setEmail(idToken.getPayload().getEmail());

                HttpSession session = ((HttpServletRequest) request).getSession();
                session.setMaxInactiveInterval(-1);
                session.setAttribute("idToken", idToken);

                resp.setCode(200);
                resp.setMessage("Login: success!");
                resp.setJwt(jwtTokenUtil.generateToken(user));

                httpServletResponse.setContentType("application/json");
                httpServletResponse.setCharacterEncoding("UTF-8");

                httpServletResponse.getWriter().write(gson.toJson(resp));
                chain.doFilter(httpServletRequest, httpServletResponse);

            } else {
                responseFail(httpServletResponse);
                return;
            }

        } else if(httpServletRequest.getHeader("Authorization") != null && httpServletRequest.getHeader("Authorization").startsWith("Bearer ")) {
            String jwtToken = httpServletRequest.getHeader("Authorization").substring(7);

            if(jwtTokenUtil.validateToken(jwtToken)) {
                chain.doFilter(httpServletRequest,httpServletResponse);

            } else {
                responseFail(httpServletResponse);

                return;
            }

        } else if(httpServletRequest.getParameter("action").equals("logout")) {
            String jwtToken = httpServletRequest.getHeader("Authorization").substring(7);




            if (jwtTokenUtil.unvalidateToken(jwtToken)) {
                chain.doFilter(httpServletRequest, httpServletResponse);

            } else {
                responseFail(httpServletResponse);

                return;
            }
        }
    }

    private Response responseFail(HttpServletResponse httpServletResponse) throws IOException {
        Response response = new Response();
        response.setCode(401);
        response.setMessage("Not Authorized");

        httpServletResponse.setContentType("application/json");
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(gson.toJson(response));

        return response;
    }
}
