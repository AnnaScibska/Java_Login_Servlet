package servlet;

import db.DBManager;
import factory.UserFactory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet {

    @Override
    public void doPost (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        try {
            DBManager dbManager = new DBManager();
            UserFactory userFactory = new UserFactory();
            boolean updateSuccesfull = dbManager.addUser(userFactory.createUserFromRequest(req));
            res.setContentType("text/html");
            PrintWriter pageHTML = res.getWriter();
            pageHTML.println("<HTML><HEAD>");
            pageHTML.println(" <TITLE>Le resultat du calcul</TITLE>");
            pageHTML.println(" <HEAD>");
            pageHTML.println(" <BODY>");
            if (updateSuccesfull) {
                pageHTML.println("<H1>GREAT SUCCESS!!!</H1>");
            } else {
                pageHTML.println("<H1>DUPA!!!</H1>");
            }
            pageHTML.println(" </BODY>");
            pageHTML.println("</HTML>");
            pageHTML.close();
        } catch (NumberFormatException e) {
            res.setContentType("text/html");
            PrintWriter pageHTML = res.getWriter();
            pageHTML.println("<HTML><HEAD>");
            pageHTML.println(" <TITLE>James Blond</TITLE>");
            pageHTML.println(" <HEAD>");
            pageHTML.println(" <BODY>");
            pageHTML.println(" DUPSON!!!");
            pageHTML.println(" </BODY>");
            pageHTML.println("</HTML>");
        }
    }
}
