package it.thinkopen.repository;

import it.thinkopen.config.ConnectionDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepositoryImpl implements PeriodRepository {
    @Override
    public List<Integer> numSearch() {
        Connection connection = ConnectionDatabase.getConnection();

        List<Integer> searches = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT number_of_searches_period FROM period");


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                searches.add(resultSet.getInt("number_of_searches_period"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return searches;
    }

    @Override
    public List<String> weeks() {
        Connection connection = ConnectionDatabase.getConnection();

        List<String> weeks = new ArrayList<>();

        try {
            PreparedStatement statement = connection.prepareStatement("SELECT week FROM period");


            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()) {
                weeks.add(resultSet.getString("week"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return weeks;
    }
}
