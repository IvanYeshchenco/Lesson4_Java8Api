package ua.com.dfyzok;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class QualificationCalculatorTest {
    @Test
    public void qualificationCalculatorShouldReturnZeroWhenInputSameTimes() throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add("SVF2018-05-24_12:02:58.917");
        startList.add("MVF2018-05-24_12:01:58.917");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.917");
        endList.add("MVF2018-05-24_12:01:58.917");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(0);
        expected.add(0);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }

    @Test
    public void qualificationCalculatorReturnCorrectAnswerWhenInputTimes() throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add("SVF2018-05-24_12:02:58.917");
        startList.add("XVF2018-05-24_12:01:58.817");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.918");
        endList.add("XVF2018-05-24_12:01:58.918");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(101);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }

    @Test(expected = ParseException.class)
    public void qualificationCalculatorThrowParseException() throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add("2018-05-24_12:02:58.917");
        startList.add("05-24_12:01:58.817");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.918");
        endList.add("24_12:01:58.918");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(101);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void qualificationCalculatorThrowStringIndexOutOfBoundsException() throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add("");
        startList.add("XVF2018-05-24_12:01:58.817");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.918");
        endList.add("XVF2018-05-24_12:01:58.918");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(101);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }

    @Test(expected = StringIndexOutOfBoundsException.class)
    public void qualificationCalculatorThrowStringIndexOutOfBoundsExceptionWhenInputSpace()
            throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add(" ");
        startList.add("XVF2018-05-24_12:01:58.817");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.918");
        endList.add("XVF2018-05-24_12:01:58.918");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(101);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }

    @Test(expected = NullPointerException.class)
    public void qualificationCalculatorThrowStringIndexOutOfBoundsExceptionWhenInputNull()
            throws IOException, ParseException {
        QualificationCalculator qualificationCalculator = new QualificationCalculator();
        List<String> startList = new ArrayList<String>();
        startList.add(null);
        startList.add("XVF2018-05-24_12:01:58.817");
        List<String> endList = new ArrayList<String>();
        endList.add("SVF2018-05-24_12:02:58.918");
        endList.add("XVF2018-05-24_12:01:58.918");

        List<Integer> actual = new ArrayList<Integer>();
        List<Integer> expected = new ArrayList<Integer>();
        expected.add(1);
        expected.add(101);
        actual = qualificationCalculator.calculateTimeLap(startList, endList);
        assertEquals(expected, actual);
    }
}
