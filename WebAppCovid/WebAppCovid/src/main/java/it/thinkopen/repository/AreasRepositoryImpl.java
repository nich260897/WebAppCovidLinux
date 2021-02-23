package it.thinkopen.repository;

import it.thinkopen.config.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AreasRepositoryImpl implements AreasRepository{
    @Override
    public List<Integer> numSearch() {
        Connection connection = ConnectionDatabase.getConnection();

        List<Integer> searches = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT number_of_searches_area FROM geographic_area");


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                searches.add(resultSet.getInt("number_of_searches_area"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searches;
    }

    @Override
    public List<String> countries() {
        Connection connection = ConnectionDatabase.getConnection();

        List<String> countries = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT country FROM geographic_area");


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                countries.add(resultSet.getString("country"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return countries;

    }

}
