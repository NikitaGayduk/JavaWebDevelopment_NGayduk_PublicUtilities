package by.epam.javawebtraining.gayduknikita.webproject.controller.servlet;

import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 28.05.2019
 */
public class ExceptionHandler extends HttpServlet {
    private static final Logger logger = Logger.getRootLogger();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        Throwable throwable = (Throwable) request
                .getAttribute("javax.servlet.error.exception");
        Integer statusCode = (Integer) request
                .getAttribute("javax.servlet.error.status_code");
        String requestUri = (String) request
                .getAttribute("javax.servlet.error.request_uri");
        if (requestUri == null) {
            requestUri = "Unknown";
        }
        logger.warn(throwable.getMessage(), throwable);

        request.setAttribute("from_handler", true);
        request.setAttribute("statusCode", statusCode);
        request.setAttribute("exceptionName", throwable.getClass().getName());
        request.setAttribute("message", throwable.getMessage());
        request.setAttribute("requestUri", requestUri);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher(Constants.ERROR_PAGE_PATH);
        requestDispatcher.forward(request, response);
    }
}
