package it.thinkopen.model;

public class LinePeriod {
    String week;
    int number_of_searches_period;

    public LinePeriod(){

    }


    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public int getNumber_of_searches_period() {
        return number_of_searches_period;
    }

    public void setNumber_of_searches_period(int number_of_searches_period) {
        this.number_of_searches_period = number_of_searches_period;
    }

    @Override
    public String toString() {
        return "DocumentPeriod{" +
                ", week='" + week + '\'' +
                ", number_of_searches_area=" + number_of_searches_period +
                '}';
    }
}
