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
import java.util.List;

@WebServlet(name = "AniFindServlet", urlPatterns = "/servlet/animal/find")
public class AniFindServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        request.getParameter("UTF-8");
        String aniName = request.getParameter("keyword");
        Animal dto = new Animal();
        dto.setAniName(aniName);
        AnimalDAO dao = new AnimalDAO();

        List<Animal> animals = dao.AnimalList(dto);



        request.setAttribute("animals", animals);


        String viewPath = "/view/aniInfo.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);

    }
}
