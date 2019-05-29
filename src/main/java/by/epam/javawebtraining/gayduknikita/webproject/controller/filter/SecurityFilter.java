package by.epam.javawebtraining.gayduknikita.webproject.controller.filter;

import by.epam.javawebtraining.gayduknikita.webproject.model.entity.Account;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class SecurityFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        String loginURI = request.getContextPath() + Constants.LOGIN_PATH;

        boolean loggedIn = (session != null) && (session.getAttribute(Constants.ACCOUNT_ATTRIBUTE) != null);
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        String command = request.getParameter(Constants.REQUEST_COMMAND_PARAMETER);

        boolean loginCommand = Constants.COMMAND_LOGIN.equals(command)
                || Constants.COMMAND_GET_REGISTRATION_PAGE.equals(command)
                || Constants.COMMAND_REGISTRATION.equals(command)
                ||Constants.COMMAND_CHANGE_LOCALE.equals(command);

        if (loggedIn || loginRequest || loginCommand) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(loginURI);
        }
    }


    @Override
    public void destroy() {

    }
}
