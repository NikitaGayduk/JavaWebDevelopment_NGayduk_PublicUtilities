package by.epam.javawebtraining.gayduknikita.webproject.controller.command;

import by.epam.javawebtraining.gayduknikita.webproject.exception.InitializationException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.PropertiesLoadingException;
import by.epam.javawebtraining.gayduknikita.webproject.exception.UnsupportedCommandException;
import by.epam.javawebtraining.gayduknikita.webproject.util.Constants;
import org.apache.log4j.Logger;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author NikitaGayduk
 * @date 26.04.2019
 */
public class CMDManager {
    private static final Logger LOGGER;
    private static final CMDManager instance;

    private Map<String, Command> commands;

    static {
        LOGGER = Logger.getRootLogger();
        instance = new CMDManager();
    }

    public static CMDManager getInstance() {
        return instance;
    }

    public void init() throws InitializationException {
        commands = new HashMap<>();
        Properties property = new Properties();

        try (InputStream fis = this.getClass().getClassLoader().getResourceAsStream(Constants.COMMAND_PROPERTIES)) {
            property.load(fis);
            Set<String> propertyNames = property.stringPropertyNames();

            for (String key : propertyNames) {
                commands.put(key
                        , (Command) Class.forName(property.getProperty(key)).getDeclaredConstructor().newInstance());
            }

        } catch (FileNotFoundException exc) {
            LOGGER.fatal("Can't find command properties file", exc);
            throw new InitializationException(exc);
        } catch (IOException exc) {
            LOGGER.fatal("IOException while loading command properties file", exc);
            throw new InitializationException(exc);
        } catch (ClassNotFoundException exc) {
            LOGGER.fatal("Can't find class specified in command properties file", exc);
            throw new InitializationException(exc);
        } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException
                | InstantiationException exc) {
            LOGGER.fatal("Can't create command object", exc);
            throw new InitializationException(exc);
        }
    }

    // TODO: 27.04.2019 add exception type
    public Command getCommand(String commandName) throws UnsupportedCommandException {
        Command result = null;
        if ((result = commands.get(commandName)) == null) {
            LOGGER.error("Unsupported command: " + commandName);
            throw new UnsupportedCommandException();
        }
        return result;
    }
}
