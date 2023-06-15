package com.example.javaassignment1200521364.Model;

import java.util.Arrays;
import java.util.List;

/**
 * This is Unemployment model
 */
public class Unemployment {
    private int id;
    private String month, duration, ageGroup;
    private double male, female, total;

    // constructor
    public Unemployment(int id, String month, String duration, String ageGroup, double male, double female, double total) {
        setId(id);
        setMonth(month);
        setDuration(duration);
        setAgeGroup(ageGroup);
        setMale(male);
        setFemale(female);
        setTotal(total);
    }

    // overload constructor for the Duration Chart
    public Unemployment(String month, String duration, double total) {
        setMonth(month);
        setDuration(duration);
        setTotal(total);
    }

    // overload constructor for the Age Group Chart
    public Unemployment(String month, double total, String ageGroup) {
        setMonth(month);
        setAgeGroup(ageGroup);
        setTotal(total);
    }

    // getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id <= 0){
            throw new IllegalArgumentException("Id cannot not be negative.");
        }
        else {
            this.id = id;
        }
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        List<String> validMonths = findMonths();
        if(validMonths.contains(month)){
            this.month = month;
        }
        else {
            throw new IllegalArgumentException("Month should be from the list: " + validMonths);
        }
    }

    public static List<String> findMonths(){
        return Arrays.asList("Mar", "Jun", "Sep", "Dec");
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        List<String> validDurations = findDurations();
        if(validDurations.contains(duration)){
            this.duration = duration;
        }
        else {
            throw new IllegalArgumentException("Duration should be from the list: " + validDurations);
        }
    }

    public static List<String> findDurations(){
        return Arrays.asList("1-4 weeks", "5-13 weeks", "14-25 weeks", "26 weeks", "27-51 weeks", "52 weeks", "53 weeks or more", "unknown");
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        List<String> validAgeGroups = findAgeGroups();
        if(validAgeGroups.contains(ageGroup)){
            this.ageGroup = ageGroup;
        }
        else {
            throw new IllegalArgumentException("Age Group should be from the list: " + validAgeGroups);
        }
    }

    public static List<String> findAgeGroups(){
        return Arrays.asList("15-19", "20-24", "25-44", "45-54", "55-64", "65 years and over");
    }

    public double getMale() {
        return male;
    }

    public void setMale(double male) {
        if(male < 0){
            throw new IllegalArgumentException("Male cannot not be negative.");
        }
        else {
            this.male = male;
        }
    }

    public double getFemale() {
        return female;
    }

    public void setFemale(double female) {
        if(female < 0){
            throw new IllegalArgumentException("Female cannot not be negative.");
        }
        else {
            this.female = female;
        }
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        if(total < 0){
            throw new IllegalArgumentException("Total cannot not be negative.");
        }
        else {
            this.total = total;
        }
    }

    @Override
    public String toString() {
        return "Unemployment{" +
                "id=" + id +
                ", month='" + month + '\'' +
                ", duration='" + duration + '\'' +
                ", ageGroup='" + ageGroup + '\'' +
                ", male=" + male +
                ", female=" + female +
                ", total=" + total +
                '}';
    }
}
