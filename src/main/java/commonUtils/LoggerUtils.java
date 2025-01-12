package commonUtils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggerUtils {

    private static final Logger logger = LoggerFactory.getLogger(LoggerUtils.class);

    public static void info(String message) {
        logger.info("<pre>{}</pre>", message);
    }

    public static void error(String message) {
        logger.error("<pre>{}</pre>", message);
    }
}
