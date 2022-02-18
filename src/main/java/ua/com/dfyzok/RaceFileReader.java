package ua.com.dfyzok;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class RaceFileReader {

    private static final String FILE_ABBREVIATIONS = "c:/workspace/lesson_6_java_8_api/abbreviations.txt";
    private static final String FILE_START_LAPS = "c:/workspace/lesson_6_java_8_api/start.log";
    private static final String FILE_END_LAPS = "c:/workspace/lesson_6_java_8_api/end.log";

    public List<String> readAbbreviationsFromFile() throws IOException {
        List<String> readAbbreviations = Files.lines(Paths.get(FILE_ABBREVIATIONS)).collect(Collectors.toList());
        return readAbbreviations;
    }

    public List<String> readStartFromFile() throws IOException {
        List<String> readStart = Files.lines(Paths.get(FILE_START_LAPS)).collect(Collectors.toList());
        return readStart;
    }

    public List<String> readEndFromFile() throws IOException {
        List<String> readEnd = Files.lines(Paths.get(FILE_END_LAPS)).collect(Collectors.toList());
        return readEnd;
    }
}
