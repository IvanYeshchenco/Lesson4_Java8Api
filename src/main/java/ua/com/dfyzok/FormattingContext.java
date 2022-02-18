package ua.com.dfyzok;

public class FormattingContext {
    private static final int LINE_TO_EDIT_GAP = 9;
    private int maxLengthName;
    private int maxLengthTeam;
    private String time;
    private String name;
    private String team;
    private int position = 1;
    private int lineLength = 0;

    public int calculateLengthGapName() {
        return position > LINE_TO_EDIT_GAP ? maxLengthName - name.length() : maxLengthName - name.length() + 1;
    }

    public int calculateLengthGapTeam() {
        return maxLengthTeam - team.length() + 1;
    }

    public void nextPosition() {
        position++;
    }

    public int getMaxLengthName() {
        return maxLengthName;
    }

    public void setMaxLengthName(int maxLengthName) {
        this.maxLengthName = maxLengthName;
    }

    public int getMaxLengthTeam() {
        return maxLengthTeam;
    }

    public void setMaxLengthTeam(int maxLengthTeam) {
        this.maxLengthTeam = maxLengthTeam;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getLineLength() {
        return lineLength;
    }

    public void setLineLength(int lineLength) {
        this.lineLength = lineLength;
    }

}
