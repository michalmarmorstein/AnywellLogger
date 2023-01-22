package logger.out;

import logger.model.LogLevel;
import logger.model.LogMessage;

import java.util.HashMap;
import java.util.List;


public class ConsoleOutput implements LoggerOutput{

    public static final String TEXT_RED = "\u001B[31m";
    public static final String TEXT_GREEN = "\u001B[32m";
    public static final String TEXT_BLUE = "\u001B[34m";
    public static final String TEXT_RESET = "\u001B[0m";
    public static final String TEXT_YELLOW = "\u001B[33m";
    public static final String TEXT_BLACK = "\u001B[30m";


    public static final HashMap<LogLevel, String> levelColorMap = new HashMap();
    static{
        levelColorMap.put(LogLevel.DEBUG, TEXT_GREEN);
        levelColorMap.put(LogLevel.ERROR, TEXT_RED);
        levelColorMap.put(LogLevel.INFO, TEXT_BLUE);
        levelColorMap.put(LogLevel.WARNING, TEXT_YELLOW);
    }

    @Override
    public void outputLogs(List<LogMessage> messages) {
        for(LogMessage msg : messages){
            String color = levelColorMap.getOrDefault(msg.getLevel(), TEXT_BLACK);
            System.out.println(color + msg.getLevel() + ": " + msg.getMessage() + TEXT_RESET);
        }
    }
}
