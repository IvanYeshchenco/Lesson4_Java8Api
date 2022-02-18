package ua.com.dfyzok;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class ResultPrinterTest {

    @Test
    public void resultPrinterShouldReturnResultStringWhenInputAbbreviationsAndTimeLaps() {
        ResultPrinter resultPrinter = new ResultPrinter();

        List<String> abbreviations = new ArrayList<String>();
        abbreviations.add("PGR_Pierre_SCUDERIA HONDA");
        abbreviations.add("NTS_Gasly_TORO ROSSO HONDA");

        List<Integer> timeLap = new ArrayList<Integer>();
        timeLap.add(123123);
        timeLap.add(133);

        String expected = "1. Pierre | SCUDERIA HONDA   | 0:00.133\n2. Gasly  | TORO ROSSO HONDA | 2:03.123\n";
        String actual = resultPrinter.prepareResult(abbreviations, timeLap);
        assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void resultPrinterShouldThrowsArrayIndexOutOfBoundsExceptionWhenInputWrongString() {
        ResultPrinter resultPrinter = new ResultPrinter();

        List<String> abbreviations = new ArrayList<String>();
        abbreviations.add("Pierre_SCUDERIA HONDA");
        abbreviations.add("NTS_Gasly_TORO ROSSO HONDA");

        List<Integer> timeLap = new ArrayList<Integer>();
        timeLap.add(123123);
        timeLap.add(133);

        String expected = "1. Pierre  | SCUDERIA HONDA    | 0:00.133\n2. Gasly   | TORO ROSSO HONDA  | 2:03.123\n";
        String actual = resultPrinter.prepareResult(abbreviations, timeLap);
        assertEquals(expected, actual);
    }

    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void resultPrinterShouldThrowsArrayIndexOutOfBoundsExceptionWhenInputWrongStringList() {
        ResultPrinter resultPrinter = new ResultPrinter();

        List<String> abbreviations = new ArrayList<String>();
        abbreviations.add("");
        abbreviations.add(" ");

        List<Integer> timeLap = new ArrayList<Integer>();
        timeLap.add(123123);
        timeLap.add(133);

        String expected = "1. Pierre  | SCUDERIA HONDA    | 0:00.133\n2. Gasly   | TORO ROSSO HONDA  | 2:03.123\n";
        String actual = resultPrinter.prepareResult(abbreviations, timeLap);
        assertEquals(expected, actual);
    }

}
