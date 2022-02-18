package ua.com.dfyzok;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ResultPrinter {

    private static final int NUMBER_RASERS_TO_NEXT_QUALIFICATION = 15;

    public String prepareResult(List<String> abbreviationsList, List<Integer> resultTimeLap) {
        List<Racer> rasers = formatRacerList(abbreviationsList, resultTimeLap);
        return formationResultString(rasers);
    }

    private List<Racer> formatRacerList(List<String> abbreviationsList, List<Integer> resultTimeLap) {
        List<Racer> racers = new ArrayList<Racer>();
        List<String> racersAbbreviations = abbreviationsList.stream().sorted().collect(Collectors.toList());
        int j = 0;
        for (String abbreviation : racersAbbreviations) {
            List<String> racerData = Arrays.asList(abbreviation.split("_"));
            racers.add(new Racer(racerData.get(0), racerData.get(1), racerData.get(2), resultTimeLap.get(j)));
            j++;
        }
        return sortRacers(racers);
    }

    private List<Racer> sortRacers(List<Racer> inputList) {
        return inputList.stream().sorted(Comparator.comparingInt(Racer::getTimeLap)).collect(Collectors.toList());
    }

    private String formationResultString(List<Racer> racersList) {
        StringBuilder resultString = new StringBuilder();
        FormattingContext formatingContext = new FormattingContext();
        List<String> racersName = racersList.stream().map(Racer::getName).collect(Collectors.toList());
        List<String> racersTeam = racersList.stream().map(Racer::getTeam).collect(Collectors.toList());
        formatingContext.setMaxLengthName(calculateMaxLength(racersName));
        formatingContext.setMaxLengthTeam(calculateMaxLength(racersTeam));
        formationLines(resultString, racersList, formatingContext);
        return resultString.toString();
    }

    private void formationLines(StringBuilder resultString, List<Racer> rasersList,
            FormattingContext formatingContext) {
        for (Racer racer : rasersList) {
            formatingContext.setTime(convertMillisecondsToTime(racer.getTimeLap()));
            formatingContext.setName(racer.getName());
            formatingContext.setTeam(racer.getTeam());
            resultString.append(formatingContext.getPosition() + ". " + formatingContext.getName());
            addSpaces(resultString, formatingContext.calculateLengthGapName());
            resultString.append(" | " + formatingContext.getTeam());
            addSpaces(resultString, formatingContext.calculateLengthGapTeam());
            resultString.append(" | " + formatingContext.getTime() + "\n");
            if (formatingContext.getPosition() == 1) {
                formatingContext.setLineLength(resultString.length() - 1);
            }
            if (formatingContext.getPosition() == NUMBER_RASERS_TO_NEXT_QUALIFICATION) {
                dashSeparatingPositions(resultString, formatingContext.getLineLength());
            }
            formatingContext.nextPosition();
        }
    }

    private static final String TIME_FORMAT = "m:ss.SSS";

    private String convertMillisecondsToTime(int input) {
        return new SimpleDateFormat(TIME_FORMAT).format(input);
    }

    private int calculateMaxLength(List<String> input) {
        return input.stream().mapToInt(String::length).max().orElse(0);
    }

    private StringBuilder dashSeparatingPositions(StringBuilder input, int length) {
        for (int i = 0; i < length; i++) {
            input.append("-");
        }
        input.append("\n");
        return input;
    }

    private StringBuilder addSpaces(StringBuilder input, int length) {
        for (int i = 0; i < length - 1; i++) {
            input.append(" ");
        }
        return input;
    }

}
