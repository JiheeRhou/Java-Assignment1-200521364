package com.example.javaassignment1200521364.Controller;

import com.example.javaassignment1200521364.Utilities.DBUtility;
import com.example.javaassignment1200521364.Utilities.SceneChanger;
import com.example.javaassignment1200521364.Model.Unemployment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Unemployment Table Controller class
 *
 * @author Ji Hee Rhou
 */
public class UnemploymentTableController implements Initializable {

    @FXML
    private TableView<Unemployment> tableView;
    @FXML
    private TableColumn<Unemployment, Double> monthColumn;

    @FXML
    private TableColumn<Unemployment, String> ageGroupColumn;

    @FXML
    private TableColumn<Unemployment, String> durationColumn;

    @FXML
    private TableColumn<Unemployment, Double> maleColumn;

    @FXML
    private TableColumn<Unemployment, Double> femaleColumn;

    @FXML
    private TableColumn<Unemployment, Double> totalColumn;

    /**
     * This is a method for the event when the user click the 'View Chart' button
     * change the chart scene to table scene
     * @param event
     * @throws IOException
     */
    @FXML
    void viewChart_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "unemployment-chart-view.fxml", "Unemployment Chart");
    }

    /**
     * This is a method to initialize the table scene
     * get the data from the database and display the table
     * @param url
     * @param resourceBundle
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        durationColumn.setCellValueFactory(new PropertyValueFactory<>("duration"));
        ageGroupColumn.setCellValueFactory(new PropertyValueFactory<>("ageGroup"));
        maleColumn.setCellValueFactory(new PropertyValueFactory<>("male"));
        femaleColumn.setCellValueFactory(new PropertyValueFactory<>("female"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));

        tableView.getItems().addAll(DBUtility.retrieveUnemploymentFromDB(""));
    }

}
