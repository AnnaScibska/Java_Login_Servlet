package servlet;

import db.DBManager;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class ListUserServlet extends HttpServlet {

    @Override
    public void doGet (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            DBManager dbManager = new DBManager();
            List<User> usersList = dbManager.listUsers();
            res.setContentType("text/html");
            PrintWriter pageHTML = res.getWriter();
            pageHTML.println("<HTML><HEAD>");
            pageHTML.println(" <TITLE>Le resultat du calcul</TITLE>");
            pageHTML.println(" <HEAD>");
            pageHTML.println(" <BODY>");
            for (User user : usersList) {
                pageHTML.println("<DIV>" +user.getName() + " - " + user.getEmail() + "</DIV>");
            }
            pageHTML.println(" </BODY>");
            pageHTML.println("</HTML>");
            pageHTML.close();
        } catch (NumberFormatException e) {
            res.setContentType("text/html");
            PrintWriter pageHTML = res.getWriter();
            pageHTML.println("<HTML><HEAD>");
            pageHTML.println(" <TITLE>Erreur de saisie</TITLE>");
            pageHTML.println(" <HEAD>");
            pageHTML.println(" <BODY>");
            pageHTML.println(" Les nombres ne sont pas correctement saisis");
            pageHTML.println(" </BODY>");
            pageHTML.println("</HTML>");
        }
    }
}
