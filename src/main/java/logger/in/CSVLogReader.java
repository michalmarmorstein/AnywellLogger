package logger.in;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import logger.model.LogLevel;
import logger.model.LogMessage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CSVLogReader implements LogReader {

    @Override
    public List<LogMessage> getMessages(String fileName) {
        List<LogMessage> logsList = new ArrayList<>();
        try {
            CSVReader reader= new CSVReaderBuilder(new InputStreamReader(getClass().getResourceAsStream(fileName)))
                    .withSkipLines(1).build();
            logsList = reader.readAll().stream().map(data-> {
                LogMessage msg = new LogMessage();
                msg.setLevel(LogLevel.valueOf(data[0]));
                msg.setMessage(data[1]);
                return msg;
            }).collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
        return logsList;
    }
}
