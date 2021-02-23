package it.thinkopen.model;

public class LineGeoArea {
    String country;
    int number_of_searches_area;

    public LineGeoArea(){

    }



    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getNumber_of_searches_area() {
        return number_of_searches_area;
    }

    public void setNumber_of_searches_area(int number_of_searches_area) {
        this.number_of_searches_area = number_of_searches_area;
    }

    @Override
    public String toString() {
        return "DocumentArea{" +
                ", country='" + country + '\'' +
                ", number_of_searches_area=" + number_of_searches_area +
                '}';
    }
}
