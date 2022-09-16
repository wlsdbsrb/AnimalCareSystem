package servlet;

import animal.AnimalDAO;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



@WebServlet(name = "AniInsertServlet", urlPatterns = "/servlet/animal/insert")
public class AniInsertServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        String aniName = request.getParameter("aniName");
        String type = request.getParameter("type");
        String kind = request.getParameter("kind");
        String master = request.getParameter("master");
        String birth = request.getParameter("birth");
        String phone = request.getParameter("phone");

        if (request.getParameter("aniName") != null) {
            aniName = request.getParameter("aniName");
        }
        if (request.getParameter("birth") != null) {
            birth = request.getParameter("birth");
        }
        if (request.getParameter("type") != null) {
            type = request.getParameter("type");
        }
        if (request.getParameter("kind") != null) {
            kind = request.getParameter("kind");
        }
        if (request.getParameter("master") != null) {
            master = request.getParameter("master");
        }
        if (request.getParameter("phone") != null) {
            phone = request.getParameter("phone");
        }

        AnimalDAO dao = new AnimalDAO();
        int result = dao.postAniInfo(aniName, type, kind, master, birth, phone);
        if (result == 1) {
            String viewPath = "/view/findAni.jsp";
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
            dispatcher.forward(request, response);


        }
    }
}
