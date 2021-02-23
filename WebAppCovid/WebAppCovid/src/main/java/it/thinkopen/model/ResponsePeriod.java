package it.thinkopen.model;

import java.util.List;

public class ResponsePeriod {
    private List<String> weeks;
    private List<Integer> num_search;

    public ResponsePeriod(){

    }

    public List<String> getWeeks() {
        return weeks;
    }

    public void setWeeks(List<String> weeks) {
        this.weeks = weeks;
    }

    public List<Integer> getNum_search() {
        return num_search;
    }

    public void setNum_search(List<Integer> num_search) {
        this.num_search = num_search;
    }

    @Override
    public String toString() {
        return "ResponsePeriod{" +
                "weeks=" + weeks +
                ", num_search=" + num_search +
                '}';
    }
}
