package util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoggerUtil {
    private static final Logger LOGGER = Logger.getLogger(LoggerUtil.class.getName());

    public static void info(String mensaje) {
        LOGGER.log(Level.INFO, mensaje);
    }

    public static void error(String mensaje, Throwable error) {
        LOGGER.log(Level.SEVERE, mensaje, error);
    }
}
