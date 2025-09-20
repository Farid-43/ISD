// Enum for Log Levels
enum LogLevel {
    INFO, DEBUG, ERROR
}

// Logger Interface (Strategy)
interface Logger {
    void log(LogLevel level, String message);
}

// Console Logger
class ConsoleLogger implements Logger {
    @Override
    public void log(LogLevel level, String message) {
        System.out.println("[" + level + "] " + message);
    }
}

// File Logger (simple simulation)
class FileLogger implements Logger {
    @Override
    public void log(LogLevel level, String message) {
        System.out.println("Writing to File -> [" + level + "] " + message);
    }
}

// Database Logger (simulation)
class DatabaseLogger implements Logger {
    @Override
    public void log(LogLevel level, String message) {
        System.out.println("Inserting into DB -> [" + level + "] " + message);
    }
}

// Logger Factory (creates different loggers)
class LoggerFactory {
    public static Logger getLogger(String type) {
        switch (type.toUpperCase()) {
            case "CONSOLE":
                return new ConsoleLogger();
            case "FILE":
                return new FileLogger();
            case "DB":
                return new DatabaseLogger();
            default:
                throw new IllegalArgumentException("Unknown logger type: " + type);
        }
    }
}

// Singleton LoggingSystem
class LoggingSystem {
    private static LoggingSystem instance;
    private Logger logger;

    private LoggingSystem(Logger logger) {
        this.logger = logger;
    }

    // Get single instance
    public static LoggingSystem getInstance(Logger logger) {
        if (instance == null) {
            instance = new LoggingSystem(logger);
        }
        return instance;
    }

    // Log messages
    public void log(LogLevel level, String message) {
        logger.log(level, message);
    }
}

// Main Class (Testing)
public class LoggingSys {
    public static void main(String[] args) {
        // Create Console Logger via Factory
        Logger consoleLogger = LoggerFactory.getLogger("CONSOLE");
        LoggingSystem loggingSystem1 = LoggingSystem.getInstance(consoleLogger);
        loggingSystem1.log(LogLevel.INFO, "This is an INFO message");
        loggingSystem1.log(LogLevel.ERROR, "This is an ERROR message");

        // Try to get another instance with File Logger (Singleton check)
        Logger fileLogger = LoggerFactory.getLogger("FILE");
        LoggingSystem loggingSystem2 = LoggingSystem.getInstance(fileLogger);

        // Verify same instance
        System.out.println("Same instance? " + (loggingSystem1 == loggingSystem2));

        // It will still use ConsoleLogger because Singleton prevents new instance
        loggingSystem2.log(LogLevel.DEBUG, "This DEBUG is still using Console Logger");
    }
}
