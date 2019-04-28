package by.epam.javawebtraining.gayduknikita.webproject.controller.requestobject;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author NikitaGayduk
 * @date 27.04.2019
 */
public class RequestObject {
    private Map<String, String> parameters;
    private Map<String, Object> attributes;
    private HttpSession session;

    public RequestObject(Map<String, String> parameters, Map<String, Object> attributes, HttpSession session) {
        this.parameters = parameters;
        this.attributes = attributes;
        this.session = session;
    }
}
