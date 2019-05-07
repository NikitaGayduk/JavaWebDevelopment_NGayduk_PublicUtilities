package by.epam.javawebtraining.gayduknikita.webproject.controller.filter;

import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import javax.servlet.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author NikitaGayduk
 * @date 07.05.2019
 */
public class EncodingFilter implements Filter {
    private String encoding = "utf-8";
    private static final Logger LOGGER = Logger.getRootLogger();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String encodingParam = filterConfig.getInitParameter("encoding");
        if (encodingParam != null) {
            encoding = encodingParam;
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        request.setCharacterEncoding(Constants.REQUEST_ENCODING);
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
