package by.epam.javawebtraining.gayduknikita.webproject.controller.servlet;

import by.epam.javawebtraining.gayduknikita.webproject.controller.command.CMDManager;
import by.epam.javawebtraining.gayduknikita.webproject.exception.CommandExecutingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.UnsupportedCommandException;
import by.epam.javawebtraining.gayduknikita.webproject.model.dal.connectionpool.BaseDBConnectionPool;
import by.epam.javawebtraining.gayduknikita.webproject.exception.InitializationException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 26.04.2019
 */
public class Controller extends HttpServlet {
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public void init() throws ServletException {
        try {
            BaseDBConnectionPool.getInstance().init();
            CMDManager.getInstance().init();
        } catch (InitializationException exc) {
            throw new ServletException(exc);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("get");
        processRequest(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().print("post");
        processRequest(req,resp);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String command = request.getParameter(Constants.REQUEST_COMMAND_PARAMETER);
            CMDManager.getInstance().getCommand(command).execute(request, response);
        } catch (UnsupportedCommandException exc) {
            throw new ServletException(exc);
        }catch (CommandExecutingException exc) {
            LOGGER.error(exc);
            throw new ServletException(exc);
        }
    }
}
