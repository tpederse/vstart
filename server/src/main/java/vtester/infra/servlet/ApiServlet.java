package vtester.infra.servlet;

import org.jsonbuddy.pojo.JsonGenerator;
import vtester.infra.db.ServiceLocator;
import vtester.loanrequest.LoanRequestRepo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/api/*")
public class ApiServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServiceLocator.startThreadContext();
        response.setContentType("application/json");
        LoanRequestRepo.addLoanRequest("Speta");
        List returnValue = LoanRequestRepo.getAll();
        response.getWriter().print(JsonGenerator.generate(returnValue).toJson());
        ServiceLocator.endThreadContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        ServiceLocator.startThreadContext();
        response.setContentType("application/json");
        System.out.println(req.getReader().readLine());

        ServiceLocator.endThreadContext();
    }
}
