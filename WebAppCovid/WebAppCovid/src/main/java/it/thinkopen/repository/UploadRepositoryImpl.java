package it.thinkopen.repository;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import it.thinkopen.config.ConnectionDatabase;
import it.thinkopen.model.LineGeoArea;
import it.thinkopen.model.LinePeriod;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.stream.Collectors;

public class UploadRepositoryImpl implements UploadRepository {



    @Override
    public void uploadPeriod(String path) {
        try  {
            CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(3).build();
            List<LinePeriod> lines = reader.readAll().stream().map(data -> {
              LinePeriod line = new LinePeriod();
              line.setWeek(data[0]);
              line.setNumber_of_searches_period(Integer.parseInt(data[1]));
              return line;
                    }).collect(Collectors.toList());

            Connection connection = ConnectionDatabase.getConnection();

            Statement s = connection.createStatement();
            s.execute("TRUNCATE TABLE period");
            s.close();



            for(LinePeriod line : lines){
                PreparedStatement ps = connection.prepareStatement("INSERT INTO period  VALUES (null,?,?)");
                ps.setString(1,line.getWeek());
                ps.setInt(2,line.getNumber_of_searches_period());

                ps.executeUpdate();
                ps.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void uploadGeoAreas(String path) {
        try  {
            CSVReader reader = new CSVReaderBuilder(new FileReader(path)).withSkipLines(3).build();
            List<LineGeoArea> lines = reader.readAll().stream().map(data -> {
                LineGeoArea line = new LineGeoArea();
                line.setCountry(data[0]);
                line.setNumber_of_searches_area(Integer.parseInt(data[1]));
                return line;
            }).collect(Collectors.toList());

            Connection connection = ConnectionDatabase.getConnection();
            Statement s = connection.createStatement();
            s.execute("TRUNCATE TABLE geographic_area");
            s.close();

            for(LineGeoArea line : lines){
                PreparedStatement ps = connection.prepareStatement("INSERT INTO geographic_area VALUES (null,?,?)");
                ps.setString(1,line.getCountry());
                ps.setInt(2,line.getNumber_of_searches_area());

                ps.executeUpdate();
                ps.close();
            }
            connection.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
