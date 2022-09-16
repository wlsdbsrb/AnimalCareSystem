package servlet;

import animal.Animal;
import animal.AnimalDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AniInfoServlet", urlPatterns = "/servlet/animal/info")
public class AniInfoServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.getParameter("UTF-8");

        List<Animal> animalList = new ArrayList<Animal>();
        AnimalDAO dao = new AnimalDAO();

        String Type = request.getParameter("Type");
        animalList = dao.AnimalOrder(Type);

        request.setAttribute("animalList",animalList);



        String viewPath = "/view/findAni.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
    }
}