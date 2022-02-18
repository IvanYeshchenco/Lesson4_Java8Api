package ua.com.dfyzok;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class QualificationCalculator {

    public List<Integer> calculateTimeLap(List<String> startLap, List<String> endLap)
            throws IOException, ParseException {

        List<String> startLapTime = startLap.stream().sorted().collect(Collectors.toList());
        List<String> endLapTime = endLap.stream().sorted().collect(Collectors.toList());
        return formattionTimeLapList(startLapTime, endLapTime);
    }

    private static final String TIME_FORMAT = "yyyy-MM-dd_HH:mm:ss.SSS";

    private List<Integer> formattionTimeLapList(List<String> startLapTime, List<String> endLapTime)
            throws IOException, ParseException {
        List<Integer> resultTimeLap = new ArrayList<Integer>();
        for (int i = 0; i < startLapTime.size(); i++) {
            SimpleDateFormat format = new SimpleDateFormat(TIME_FORMAT);
            String startString = startLapTime.get(i);
            String endString = endLapTime.get(i);
            Date start = format.parse(startString.substring(3));
            Date end = format.parse(endString.substring(3));
            int timeLap = (int) (end.getTime() - start.getTime());
            resultTimeLap.add(timeLap);
        }
        return resultTimeLap;
    }
}
