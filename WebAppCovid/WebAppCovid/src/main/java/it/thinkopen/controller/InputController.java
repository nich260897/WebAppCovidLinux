package it.thinkopen.controller;

import com.google.gson.Gson;
import it.thinkopen.dto.Response;
import it.thinkopen.model.User;
import it.thinkopen.repository.UploadRepository;
import it.thinkopen.repository.UploadRepositoryImpl;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.*;
import java.nio.file.Paths;
import java.util.List;

@WebServlet(urlPatterns ="/inputController")
public class InputController extends HttpServlet {
    private UploadRepository uploadRepository;
    private Gson gson = new Gson();

    public void init() throws ServletException {
        this.uploadRepository = new UploadRepositoryImpl();
    }


    private static String dispatch = null;

        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            String action = request.getParameter("action");




            switch (action) {
                case "importArea": {

                    final String UPLOAD_DIRECTORY = "C:/updates";
                    String name = null;
                    if (ServletFileUpload.isMultipartContent(request)) {
                        try {
                            List<FileItem> multiparts = new ServletFileUpload(
                                    new DiskFileItemFactory()).parseRequest(request);
                            for (FileItem item : multiparts) {
                                if (!item.isFormField()) {
                                    File fileSaveDir = new File(UPLOAD_DIRECTORY);
                                    if (!fileSaveDir.exists()) {
                                        fileSaveDir.mkdir();
                                    }
                                    name = new File(item.getName()).getName();
                                    String path = UPLOAD_DIRECTORY + "/" + name;
                                    item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

                                }
                            }
                        } catch (Exception e) {
                            // exception handling
                        }

                    }
                    uploadRepository.uploadGeoAreas(UPLOAD_DIRECTORY + "/" + name);
                    Response resp = new Response();


                    resp.setCode(200);
                    resp.setMessage("Upload: success!");


                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    response.getWriter().write(gson.toJson(resp));
                    break;
                }

                case "importPeriod": {

                    final String UPLOAD_DIRECTORY = "C:/updates";
                    String name = null;
                    if (ServletFileUpload.isMultipartContent(request)) {
                        try {
                            List<FileItem> multiparts = new ServletFileUpload(
                                    new DiskFileItemFactory()).parseRequest(request);
                            for (FileItem item : multiparts) {
                                if (!item.isFormField()) {
                                    File fileSaveDir = new File(UPLOAD_DIRECTORY);
                                    if (!fileSaveDir.exists()) {
                                        fileSaveDir.mkdir();
                                    }
                                    name = new File(item.getName()).getName();
                                    String path = UPLOAD_DIRECTORY + "/" + name;
                                    item.write(new File(UPLOAD_DIRECTORY + File.separator + name));

                                }
                            }

                        } catch (Exception e) {
                            // exception handling
                        }

                    }
                    uploadRepository.uploadPeriod(UPLOAD_DIRECTORY + "/" + name);
                    Response resp = new Response();


                    resp.setCode(200);
                    resp.setMessage("Upload: success!");


                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");

                    response.getWriter().write(gson.toJson(resp));
                    break;
                }

            }
        }


}


