package com.example.javaassignment1200521364;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

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

    @FXML
    void viewChart_onClick(ActionEvent event) throws IOException {
        SceneChanger.changeScene(event, "unemployment-chart-view.fxml", "Unemployment Chart");
    }

}
