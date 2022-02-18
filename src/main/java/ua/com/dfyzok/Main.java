package ua.com.dfyzok;

import java.io.IOException;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws IOException, ParseException {
        RaceAnalyzer raceAnalyze = new RaceAnalyzer();
        System.out.print(raceAnalyze.analyzeRace());
    }
}
