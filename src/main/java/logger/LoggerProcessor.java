package logger;

import logger.in.CSVLogReader;
import logger.in.JsonLogReader;
import logger.in.LogReader;
import logger.model.LogMessage;
import logger.out.ConsoleOutput;
import logger.out.JsonFileOutput;
import logger.out.LoggerOutput;

import java.util.List;

public class LoggerProcessor {

    public static void main(String[] args) {
        processLogs(new JsonLogReader(), new ConsoleOutput(), "/logs.json");
        processLogs(new CSVLogReader(), new ConsoleOutput(), "/logs.csv");
//        processLogs(new JsonLogReader(), new JsonFileOutput(), "/logs.json");
        processLogs(new CSVLogReader(), new JsonFileOutput(), "/logs.csv");
    }

    public static void processLogs(LogReader in, LoggerOutput out, String inputFileName){
        List<LogMessage> messages = in.getMessages(inputFileName);
        out.outputLogs(messages);
    }
}
