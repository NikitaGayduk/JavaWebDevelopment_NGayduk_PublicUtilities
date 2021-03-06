package by.epam.javawebtraining.gayduknikita.webproject.controller.filter;

import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ResourceBundle;

/**
 * @author NikitaGayduk
 * @date 26.05.2019
 */
public class LocalizationFilter implements Filter {

    @Override
    public void init(FilterConfig fConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        if (session.getAttribute(Constants.LANGUAGE_ATTRIBUTE) == null) {
            session.setAttribute(Constants.LANGUAGE_ATTRIBUTE, "en");
        }

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
