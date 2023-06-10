package com.example.javaassignment1200521364;

public class Unemployment {
    private int id;
    private String month, duration, ageGroup;
    private double male, female, total;

    public Unemployment(int id, String month, String duration, String ageGroup, double male, double female, double total) {
        setId(id);
        setMonth(month);
        setDuration(duration);
        setAgeGroup(ageGroup);
        setMale(male);
        setFemale(female);
        setTotal(total);
    }

    public Unemployment(String month, String duration, String ageGroup, double male, double female, double total) {
        this.id = -1;
        setMonth(month);
        setDuration(duration);
        setAgeGroup(ageGroup);
        setMale(male);
        setFemale(female);
        setTotal(total);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getAgeGroup() {
        return ageGroup;
    }

    public void setAgeGroup(String ageGroup) {
        this.ageGroup = ageGroup;
    }

    public double getMale() {
        return male;
    }

    public void setMale(double male) {
        this.male = male;
    }

    public double getFemale() {
        return female;
    }

    public void setFemale(double female) {
        this.female = female;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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
