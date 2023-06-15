package com.example.javaassignment1200521364.Controller;

import com.example.javaassignment1200521364.Utilities.DBUtility;
import com.example.javaassignment1200521364.Utilities.SceneChanger;
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

/**
 * Unemployment Chart Controller class
 *
 * @author Ji Hee Rhou
 */
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

    /**
     * This is a method for the event when the user click the 'View Table' button
     * change the table scene to chart scene
     * @param event
     * @throws IOException
     */
    @FXML
    void viewTable_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "unemployment-table-view.fxml", "Unemployment");
    }

    /**
     * This is a method for the event when the user check or uncheck the month check boxes
     * @param event
     */
    @FXML
    void monthCheckBox_onClick(ActionEvent event) {
        // display the chart
        displayChart();
    }

    /**
     * This is a method for the event when the user change the type
     * @param event
     */
    @FXML
    void typeComboBox_onChange(ActionEvent event) {
        // initialize the month checkBoxes
        marchCheckBox.setSelected(true);
        juneCheckBox.setSelected(false);
        septemberCheckBox.setSelected(false);
        decemberCheckBox.setSelected(false);

        // display the chart
        displayChart();
    }

    /**
     * This is a method to initialize the chart scene
     * get the data from the database and display the chart
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //set type combobox items and set the value
        typeComboBox.getItems().addAll("Duration", "Age Group");
        typeComboBox.setValue("Duration");

        // display the chart
        displayChart();
    }

    /**
     * This is a method to get the data from the database and display the chart
     */
    public void displayChart(){
        // clear the chart
        barChart.getData().clear();

        // get the type from the type comboBox
        String type = typeComboBox.getValue();

        // set the axis labels
        numberAxis.setLabel("Unemployment");
        categoryAxis.setLabel(type);

        // get the checked months
        String[] months = getMonthCheck().split(",");
        // add the chart of each checked month
        for(String month : months){
            barChart.getData().addAll(DBUtility.retrieveUnemploymentChartFromDB(type, month));
        }
    }

    // get the checked months
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
