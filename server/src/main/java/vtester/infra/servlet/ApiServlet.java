package vtester.infra.servlet;

import org.jsonbuddy.parse.JsonParser;
import org.jsonbuddy.pojo.JsonGenerator;
import org.jsonbuddy.pojo.PojoMapper;
import vtester.infra.db.DbApi;
import vtester.infra.db.ServiceLocator;
import vtester.infra.logger.OurLogger;
import vtester.loanrequest.LoanRequestCommand;
import vtester.loanrequest.LoanRequestRepo;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        List returnValue = LoanRequestRepo.getAll();
        response.getWriter().print(JsonGenerator.generate(returnValue).toJson());
        DbApi.commit();
        ServiceLocator.endThreadContext();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse response) throws ServletException, IOException {
        try {
            ServiceLocator.startThreadContext();
            response.setContentType("application/json");
            String requsetJson = req.getReader().readLine();  //TODO: accept Multiline
            OurLogger.logInputFromUser(requsetJson);

            doPostLogic(req.getPathInfo(),requsetJson);


            DbApi.commit();
            ServiceLocator.endThreadContext();
        }catch(Exception e){
            OurLogger.logErrorOnRequest(req,e);
            DbApi.rollBack();
            ServiceLocator.endThreadContext();
            response.sendError(500);
        }

    }

    private JsonToUser doPostLogic(String path, String requsetJson) {
        if(path.startsWith("/postLoanRequest"))return doLogic(LoanRequestCommand.class,requsetJson);
        throw new RuntimeException("Unknown Service "+path);
    }

    private JsonToUser doLogic(Class commandClass, String requsetJson) {
        Command command = (Command) PojoMapper.map(JsonParser.parseToObject(requsetJson), commandClass);
        return command.doYourThing();
    }


}
