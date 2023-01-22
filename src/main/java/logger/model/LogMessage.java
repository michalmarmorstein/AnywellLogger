package logger.model;

public class LogMessage {

    private LogLevel level;
    private String message;

    public LogLevel getLevel() {
        return level;
    }

    public void setLevel(LogLevel level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "level='" + level + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
