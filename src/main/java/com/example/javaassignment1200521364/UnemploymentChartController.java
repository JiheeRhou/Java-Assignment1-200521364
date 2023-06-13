package com.example.javaassignment1200521364;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UnemploymentChartController implements Initializable {

    @FXML
    private BarChart<String, Double> barChart;

    @FXML
    private CategoryAxis categoryAxis;

    @FXML
    private NumberAxis numberAxis;

    @FXML
    private CheckBox juneCheckBox;

    @FXML
    private CheckBox marchCheckBox;

    @FXML
    private CheckBox septemberCheckBox;

    @FXML
    private CheckBox decemberCheckBox;

    @FXML
    private ComboBox<String> typeComboBox;

    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "unemployment-table-view.fxml", "Unemployment");
    }

    @FXML
    void monthCheckBox_onClick(ActionEvent event) {
        drawChart();
    }

    @FXML
    void typeComboBox_onChange(ActionEvent event) {
        marchCheckBox.setSelected(true);
        juneCheckBox.setSelected(false);
        septemberCheckBox.setSelected(false);
        decemberCheckBox.setSelected(false);

        drawChart();

        String type = typeComboBox.getValue();
        categoryAxis.setLabel(type);
    }

    public void drawChart(){
        barChart.getData().clear();

        String type = typeComboBox.getValue();
        String[] months = getMonthCheck().split(",");
        for(String month : months){
            barChart.getData().addAll(DBUtility.retrieveUnemploymentChartFromDB(type, month));
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        typeComboBox.getItems().add("Duration");
        typeComboBox.getItems().add("Age Group");
        typeComboBox.setValue("Duration");

        drawChart();
        numberAxis.setLabel("Unemployment");
        categoryAxis.setLabel("Duration");
    }

    public String getMonthCheck(){
        String checkedMonths = "";

        if (marchCheckBox.isSelected()){
            checkedMonths += "Mar";
        }
        if (juneCheckBox.isSelected()){
            if (!checkedMonths.equals("")) checkedMonths += ",";
            checkedMonths += "Jun";
        }
        if (septemberCheckBox.isSelected()){
            if (!checkedMonths.equals("")) checkedMonths += ",";
            checkedMonths += "Sep";
        }
        if (decemberCheckBox.isSelected()){
            if (!checkedMonths.equals("")) checkedMonths += ",";
            checkedMonths += "Dec";
        }

        return checkedMonths;
    }
}
