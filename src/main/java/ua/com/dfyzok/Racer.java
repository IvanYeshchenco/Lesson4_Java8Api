package ua.com.dfyzok;

public class Racer {

    private String abbreviation;
    private String name;
    private String team;
    private int timeLap;

    public Racer(String abbreviation, String name, String team, int timeLap) {
        this.abbreviation = abbreviation;
        this.name = name;
        this.team = team;
        this.timeLap = timeLap;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
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

    public int getTimeLap() {
        return timeLap;
    }

    public void setTimeLap(int timeLap) {
        this.timeLap = timeLap;
    }

    @Override
    public String toString() {
        return "Racer [abbreviation=" + abbreviation + ", name=" + name + ", team=" + team + ", timeLapMilliseconds="
                + timeLap + "]";
    }

}
