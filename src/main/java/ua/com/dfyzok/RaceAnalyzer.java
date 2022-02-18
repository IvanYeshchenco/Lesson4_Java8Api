package ua.com.dfyzok;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;

public class RaceAnalyzer {

    public String analyzeRace() throws IOException, ParseException {
        List<String> readAbbreviations = new RaceFileReader().readAbbreviationsFromFile();
        List<String> readStart = new RaceFileReader().readStartFromFile();
        List<String> readEnd = new RaceFileReader().readEndFromFile();

        QualificationCalculator resultQualification = new QualificationCalculator();
        List<Integer> resultTimeLap = resultQualification.calculateTimeLap(readStart, readEnd);

        ResultPrinter resultPrinter = new ResultPrinter();
        return resultPrinter.prepareResult(readAbbreviations, resultTimeLap);
    }
}
