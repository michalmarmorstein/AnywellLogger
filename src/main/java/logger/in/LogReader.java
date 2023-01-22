package logger.in;

import logger.model.LogMessage;

import java.util.List;

public interface LogReader {
    List<LogMessage> getMessages(String fileName);
}
