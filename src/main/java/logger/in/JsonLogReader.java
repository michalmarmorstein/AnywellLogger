package logger.in;

import com.fasterxml.jackson.databind.ObjectMapper;
import logger.model.LogMessage;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class JsonLogReader implements LogReader {

    @Override
    public List<LogMessage> getMessages(String fileName) {

        ObjectMapper mapper = new ObjectMapper();
        LogMessage[] messages = new LogMessage[0];
        try {
            messages = mapper.readValue(getClass().getResource(fileName), LogMessage[].class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return Arrays.asList(messages);
    }
}
