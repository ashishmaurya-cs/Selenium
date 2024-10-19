package com.ashish;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log4jExample {

    // Create a logger instance
    private static final Logger logger = LogManager.getLogger(Log4jExample.class);

    public static void main(String[] args) {
        // Log messages at different levels
        logger.debug("This is a debug message");
        logger.info("This is an info message");
        logger.warn("This is a warning message");
        logger.error("This is an error message");
        logger.fatal("This is a fatal message");

        try {
            int result = 10 / 0;
        } catch (ArithmeticException e) {
            logger.error("ArithmeticException caught: " + e.getMessage(), e);
        }
    }
}

