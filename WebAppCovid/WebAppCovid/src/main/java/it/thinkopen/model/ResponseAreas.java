package it.thinkopen.model;

import java.util.List;

public class ResponseAreas {
    private List<String> countries;
    private List<Integer> num_search;

    public ResponseAreas(){

    }

    public List<String> getCountries() {
        return countries;
    }

    public void setCountries(List<String> countries) {
        this.countries = countries;
    }

    public List<Integer> getNum_search() {
        return num_search;
    }

    public void setNum_search(List<Integer> num_search) {
        this.num_search = num_search;
    }

    @Override
    public String toString() {
        return "ResponseAreas{" +
                "countries=" + countries +
                ", num_search=" + num_search +
                '}';
    }
}
