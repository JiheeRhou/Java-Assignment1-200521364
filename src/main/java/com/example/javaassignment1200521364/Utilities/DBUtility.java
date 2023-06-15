package com.example.javaassignment1200521364.Utilities;

import com.example.javaassignment1200521364.Model.Unemployment;
import javafx.scene.chart.XYChart;

import java.sql.*;
import java.util.ArrayList;

public class DBUtility {
    private static String user = "JiHee200521364";
    private static String pass = "yozPGBBYRE";
    private static String connectURL = "jdbc:mysql://172.31.22.43:3306/" + user;

    public static ArrayList<Unemployment> retrieveUnemploymentFromDB(String type){
        ArrayList<Unemployment> unemploymentList = new ArrayList<>();
        String sql = "";

        if(type.equals("Duration")){
            sql = "SELECT 0 AS id, m.month_name, d.duration_name, '' AS age_group_name, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total\n" +
                    "FROM unemployment u\n" +
                    "JOIN month m\n" +
                    "ON u.month_id = m.id\n" +
                    "JOIN duration d\n" +
                    "ON u.duration_id = d.id\n" +
                    "GROUP BY m.id, d.id\n" +
                    "ORDER BY m.id, d.id;";

        } else if(type.equals("Age Group")){
            sql = "SELECT 0 AS id, m.month_name, '' AS duration_name, ag.age_group_name, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total\n" +
                    "FROM unemployment u\n" +
                    "JOIN month m\n" +
                    "ON u.month_id = m.id\n" +
                    "JOIN ageGroup ag\n" +
                    "ON u.age_group_id = ag.id\n" +
                    "GROUP BY m.id, ag.id\n" +
                    "ORDER BY m.id, ag.id;";
        } else {
            sql = "SELECT u.id, m.month_name, d.duration_name, ag.age_group_name, format(sum(u.male), 1) AS male, format(sum(u.female), 1) AS female, format(sum(u.male + u.female), 1) AS total\n" +
                    "FROM unemployment u\n" +
                    "JOIN month m\n" +
                    "ON u.month_id = m.id\n" +
                    "JOIN duration d\n" +
                    "ON u.duration_id = d.id\n" +
                    "JOIN ageGroup ag\n" +
                    "ON u.age_group_id = ag.id\n" +
                    "GROUP BY u.id, m.id, d.id, ag.id\n" +
                    "ORDER BY u.id, m.id, d.id, ag.id;";
        }

        try (
                Connection conn = DriverManager.getConnection(connectURL, user, pass);
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery(sql);
                ) {
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String month = resultSet.getString("month_name");
                String duration = resultSet.getString("duration_name");
                String ageGroup = resultSet.getString("age_group_name");
                Double male = resultSet.getDouble("male");
                Double female = resultSet.getDouble("female");
                Double total = resultSet.getDouble("total");

                if(type.equals("Duration")) {
                    Unemployment newUnemployment = new Unemployment(month, duration, total);
                    unemploymentList.add(newUnemployment);
                }
                else if(type.equals("Age Group")) {
                    Unemployment newUnemployment = new Unemployment(month, total, ageGroup);
                    unemploymentList.add(newUnemployment);
                }
                else {
                    Unemployment newUnemployment = new Unemployment(id, month, duration, ageGroup, male, female, total);
                    unemploymentList.add(newUnemployment);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return unemploymentList;
    }

    public static XYChart.Series<String, Double> retrieveUnemploymentChartFromDB(String type, String month) {
        XYChart.Series<String, Double> unemploymentForChart = new XYChart.Series<String, Double>();
        ArrayList<Unemployment> unemploymentList = retrieveUnemploymentFromDB(type);

        for(Unemployment unemployment : unemploymentList){
            if(month.equals(unemployment.getMonth())){
                if(type.equals("Duration")){
                    unemploymentForChart.getData().add(new XYChart.Data<>(unemployment.getDuration(), unemployment.getTotal()));
                } else if(type.equals("Age Group")){
                    unemploymentForChart.getData().add(new XYChart.Data<>(unemployment.getAgeGroup(), unemployment.getTotal()));
                }
            }
        }
        unemploymentForChart.setName(month);

        return unemploymentForChart;
    }
}
