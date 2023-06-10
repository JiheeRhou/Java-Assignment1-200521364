package com.example.javaassignment1200521364;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "JiHee200521364";
    private static String pass = "yozPGBBYRE";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/" + user;

    public static ArrayList<Unemployment> retrieveUnemploymentFromDB(){
        ArrayList<Unemployment> unemploymentList = new ArrayList<>();
        String sql = "SELECT id, month, duration, age_group, male, female, total FROM unemployment;";

        try (
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String month = resultSet.getString("month");
                String duration = resultSet.getString("duration");
                String ageGroup = resultSet.getString("age_group");
                Double male = resultSet.getDouble("male");
                Double female = resultSet.getDouble("female");
                Double total = resultSet.getDouble("total");

                Unemployment newUnemployment = new Unemployment(id, month, duration, ageGroup, male, female, total);
                unemploymentList.add(newUnemployment);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return unemploymentList;
    }
}
