package logger.out;

import logger.model.LogMessage;

import java.util.List;

public interface LoggerOutput {
    void outputLogs(List<LogMessage> messages);
}
