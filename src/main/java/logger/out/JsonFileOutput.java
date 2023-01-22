package logger.out;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import logger.model.LogLevel;
import logger.model.LogMessage;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;

public class JsonFileOutput implements LoggerOutput{

    @Override
    public void outputLogs(List<LogMessage> messages) {
        Map<LogLevel, List<String>> grouped = messages.stream()
                .collect(groupingBy(LogMessage::getLevel, mapping(LogMessage::getMessage, Collectors.toList())));
        String json = null;
        try {
            json = new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(grouped);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        try {
            FileWriter writer = new FileWriter("./output/loggerOutput.json");
            writer.write(json);
            writer.close();
        } catch (IOException e) {
            System.err.println("JsonFileOutput:outputLogs() - Couldn't create a file");
            e.printStackTrace();
        }
    }
}
